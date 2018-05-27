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
import lorence.construction.data.storage.dao.ListingDao;
import lorence.construction.data.storage.dao.ListingOperationDao;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.data.storage.entity.ListingOperation;
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
    private static ListingOperationDao mListingOperationDao;

    @Override
    public void attachListingDao(Context context, ListingDao listingDao) {
        mContext = context;
        mListingDao = listingDao;
    }

    @Override
    public void attachListingOperationDao(Context context, ListingOperationDao listingOperationDao) {
        mContext = context;
        mListingOperationDao = listingOperationDao;
    }

    @Override
    public void attachListingPresenter(ListingPresenter listingPresenter) {
        mPresenter = listingPresenter;
    }

    @Override
    public void inertListings(List<Listing> items) {
        new InsertAll().execute(items);
    }

    @Override
    public void inertListingOperations(List<ListingOperation> items) {
        new InsertAllCustom().execute(items);
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
                    mPresenter.onInsertListingsSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    mPresenter.onInsertListingsFailed();
                }
            });

            return 1;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

    }

    static class InsertAllCustom extends AsyncTask<List<ListingOperation>, Void, Integer> {

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

    @Override
    public void getListings() {
        new GetAll().execute();
    }

    @Override
    public void getListingOperations() {
        new GetAllCustom().execute();
    }

    static class GetAll extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            mListingDao.getListings().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Listing>>() {
                @Override
                public void accept(@io.reactivex.annotations.NonNull List<Listing> listings) throws Exception {
                    mPresenter.onGetListingsSuccess(listings);
                }
            });
            return null;
        }
    }

    static class GetAllCustom extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            mListingOperationDao.getListingOperations().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<ListingOperation>>() {
                @Override
                public void accept(@io.reactivex.annotations.NonNull List<ListingOperation> listings) throws Exception {
                    mPresenter.onGetListingOperationsSuccess(listings);
                }
            });
            return null;
        }
    }
}
