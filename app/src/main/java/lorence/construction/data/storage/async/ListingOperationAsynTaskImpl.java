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
import lorence.construction.data.storage.dao.ListingOperationDao;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.view.fragment.listing.ListingPresenter;
import lorence.construction.view.fragment.listing.ListingPresenterImpl;
import lorence.construction.view.fragment.listing.fragment.ListingOperationPresenter;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class ListingOperationAsynTaskImpl implements ListingOperationAsynTask {

    private static ListingOperationDao mListingOperationDao;
    private static Context mContext;
    private static ListingOperationPresenter mListingOperationPresenter;
    private static ListingPresenter mListingPresenter;

    @Override
    public void attachListingOperationDao(Context context, ListingOperationDao listingOperationDao) {
        mContext = context;
        mListingOperationDao = listingOperationDao;
    }

    @Override
    public void attachListingOperationPresenter(ListingOperationPresenter listingOperationPresenter) {
        mListingOperationPresenter = listingOperationPresenter;
    }

    @Override
    public void getListingOperationByListingPresenters(ListingPresenter listingPresenter) {
        mListingPresenter = listingPresenter;
        new GetAll().execute();
    }

    @Override
    public void getListingOperationByListingOperationPresenters(ListingOperationPresenter listingOperationPresenter) {
        mListingOperationPresenter = listingOperationPresenter;
        new GetAll().execute();
    }

    static class GetAll extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            mListingOperationDao.getListingOperations().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<ListingOperation>>() {
                @Override
                public void accept(@io.reactivex.annotations.NonNull List<ListingOperation> listingOperations) throws Exception {
                    if (mListingPresenter != null)
                        mListingPresenter.onGetListingOperationsSuccess(listingOperations);
                    if (mListingOperationPresenter != null)
                        mListingOperationPresenter.onGetListingOperationsSuccess(listingOperations);
                }
            });
            return null;
        }
    }

    @Override
    public void inertListingOperations(List<ListingOperation> list, ListingPresenter listingPresenter) {
        mListingPresenter = listingPresenter;
        new InsertAll().execute(list);
    }

    static class InsertAll extends AsyncTask<List<ListingOperation>, Void, Integer> {

        @Override
        protected Integer doInBackground(final List<ListingOperation>[] params) {
            Completable.fromAction(new Action() {
                @Override
                public void run() throws Exception {
                    mListingOperationDao.insertListingOperations(params[0]);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onComplete() {
                }

                @Override
                public void onError(Throwable e) {
                }
            });

            return 1;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

    }
}
