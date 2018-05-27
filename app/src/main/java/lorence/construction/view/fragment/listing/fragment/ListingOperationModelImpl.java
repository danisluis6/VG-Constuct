package lorence.construction.view.fragment.listing.fragment;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import lorence.construction.data.storage.async.ListingOperationAsynTask;
import lorence.construction.data.storage.dao.ListingOperationDao;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.view.fragment.listing.ListingPresenterImpl;

public class ListingOperationModelImpl implements ListingOperationModel {

    private Context mContext;
    private ListingOperationDao mListingOperationDao;

    private ListingOperationPresenter mListingOperationPresenter;
    private ListingOperationAsynTask mListingOperationAsynTask;

    @Inject
    public ListingOperationModelImpl(Context context, ListingOperationDao listingOperationDao) {
        mContext = context;
        mListingOperationDao = listingOperationDao;
    }

    @Override
    public void attachListingOperationPresenter(ListingOperationPresenterImpl listingOperationPresenter) {
        mListingOperationPresenter = listingOperationPresenter;
        mListingOperationAsynTask.attachListingOperationPresenter(listingOperationPresenter);
    }

    @Override
    public void attachListingOperationAsynTask(ListingOperationAsynTask listingOperationAsynTask) {
        mListingOperationAsynTask = listingOperationAsynTask;
        mListingOperationAsynTask.attachListingOperationDao(mContext, mListingOperationDao);
    }

    @Override
    public void getListingOperationByListingPresenters(ListingPresenterImpl listingPresenter) {
        mListingOperationAsynTask.getListingOperationByListingPresenters(listingPresenter);
    }

    @Override
    public void getListingOperationByListingPresenterByListingOperationPresenters(ListingOperationPresenter listingOperationPresenter) {
        mListingOperationAsynTask.getListingOperationByListingOperationPresenters(listingOperationPresenter);
    }

    @Override
    public void inertListingOperationByListingPresenters(List<ListingOperation> list, ListingPresenterImpl listingPresenter) {
        mListingOperationAsynTask.inertListingOperations(list, listingPresenter);
    }
}
