package lorence.construction.view.fragment.listing;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import lorence.construction.data.storage.async.ListingAsynTask;
import lorence.construction.data.storage.dao.ListingDao;
import lorence.construction.data.storage.dao.ListingOperationDao;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.data.storage.entity.ListingOperation;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingModelImpl implements ListingModel {

    private Context mContext;
    private ListingDao mListingDao;
    private ListingOperationDao mListingOperationDao;

    private ListingPresenter mListingPresenter;
    private ListingAsynTask mListingAsynTask;

    @Inject
    public ListingModelImpl(Context context, ListingDao listingDao, ListingOperationDao listingOperationDao) {
        mContext = context;
        mListingDao = listingDao;
        mListingOperationDao = listingOperationDao;
    }

    @Override
    public void attachListingAsynTask(ListingAsynTask listingAsynTask) {
        mListingAsynTask = listingAsynTask;
        mListingAsynTask.attachListingDao(mContext, mListingDao);
        mListingAsynTask.attachListingOperationDao(mContext, mListingOperationDao);
    }

    @Override
    public void attachListingPresenter(ListingPresenter listingPresenter) {
        mListingPresenter = listingPresenter;
        mListingAsynTask.attachListingPresenter(mListingPresenter);
    }

    @Override
    public void getListings() {
        mListingAsynTask.getListings();
    }

    @Override
    public void getListingOperations() {
        mListingAsynTask.getListingOperations();
    }

    @Override
    public void inertListingOperations(List<ListingOperation> list) {
        mListingAsynTask.inertListingOperations(list);
    }

    @Override
    public void inertListings(List<Listing> list) {
        mListingAsynTask.inertListings(list);
    }

}
