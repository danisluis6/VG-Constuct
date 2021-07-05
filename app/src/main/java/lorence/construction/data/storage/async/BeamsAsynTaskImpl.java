package lorence.construction.data.storage.async;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import dagger.Module;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import lorence.construction.data.storage.dao.BeamsDao;
import lorence.construction.data.storage.entity.Beams;
import lorence.construction.view.fragment.beams.BeamsPresenter;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class BeamsAsynTaskImpl implements BeamsAsynTask {

    private static BeamsDao mBeamsDao;
    private static Context mContext;
    private static BeamsPresenter mPresenter;

    @Override
    public void attachBeamsDao(Context context, BeamsDao beamsDao) {
        mContext = context;
        mBeamsDao = beamsDao;
    }

    @Override
    public void attachBeamsPresenter(BeamsPresenter beamsPresenter) {
        mPresenter = beamsPresenter;
    }

    @Override
    public void insertBeams(List<Beams> items) {
        new InsertAll().execute(items);
    }

    static class InsertAll extends AsyncTask<List<Beams>, Void, Integer> {

        @Override
        protected Integer doInBackground(final List<Beams>[] params) {
            Completable.fromAction(new Action() {
                @Override
                public void run() throws Exception {
                    mBeamsDao.insertBeams(params[0]);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onComplete() {
                    mPresenter.onInsertBeamsSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    mPresenter.onInsertBeamsFailed();
                }
            });

            return 1;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

    }

    @Override
    public void getBeams() {
        new GetAll().execute();
    }

    static class GetAll extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            mBeamsDao.getBeams().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Beams>>() {
                @Override
                public void accept(@io.reactivex.annotations.NonNull List<Beams> beams) throws Exception {
                    mPresenter.onGetBeamsSuccess(beams);
                }
            });
            return null;
        }
    }
}
