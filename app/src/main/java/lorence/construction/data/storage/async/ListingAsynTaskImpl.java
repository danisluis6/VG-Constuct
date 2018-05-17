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
import io.reactivex.schedulers.Schedulers;
import lorence.construction.data.storage.dao.ListingDao;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.view.fragment.listing.ListingPresenter;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class ListingAsynTaskImpl implements ListingAsynTask {

    private static ListingDao mListingDao;
    private static Context mContext;
    private static ListingPresenter mPresenter;

    @Override
    public void inertListings(Context context, ListingDao listingDao, List<Listing> items, ListingPresenter presenter) {
        mListingDao = listingDao;
        mPresenter = presenter;
        new InsertAll().execute(items);
    }

    static class InsertAll extends AsyncTask<List<Listing>, Void, Integer> {

        @Override
        protected Integer doInBackground(final List<Listing>[] params) {
            Completable.fromAction(new Action() {
                @Override
                public void run() throws Exception {
                    mListingDao.insertListings(params[0]);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onComplete() {
                    mPresenter.onSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    mPresenter.onFailed();
                }
            });

            return 1;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mPresenter.showMessage("Add all listings successfully!");
        }
    }
    // READ MORE: https://medium.com/@alahammad/database-with-room-using-rxjava-764ee6124974
}
