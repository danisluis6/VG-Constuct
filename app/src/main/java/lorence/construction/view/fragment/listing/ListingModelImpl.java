package lorence.construction.view.fragment.listing;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import lorence.construction.data.storage.async.ListingAsynTask;
import lorence.construction.data.storage.dao.ListingDao;
import lorence.construction.data.storage.entity.Listing;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingModelImpl implements ListingModel {

    private Context mContext;
    private ListingDao mListingDao;

    private ListingPresenter mListingPresenter;
    private ListingAsynTask mListingAsynTask;

    @Inject
    public ListingModelImpl(Context context, ListingDao listingDao) {
        mContext = context;
        mListingDao = listingDao;
    }

    @Override
    public void attachListingAsynTask(ListingAsynTask listingAsynTask) {
        mListingAsynTask = listingAsynTask;
    }

    @Override
    public void attachListingPresenter(ListingPresenter listingPresenter) {
        mListingPresenter = listingPresenter;
    }

    @Override
    public void inertListings(List<Listing> list) {
        mListingAsynTask.inertListings(mContext, mListingDao, list, mListingPresenter);
    }

}
