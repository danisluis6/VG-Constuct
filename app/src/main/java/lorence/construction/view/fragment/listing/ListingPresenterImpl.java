package lorence.construction.view.fragment.listing;

import android.content.Context;

import java.util.List;

import lorence.construction.data.storage.async.ListingAsynTask;
import lorence.construction.data.storage.async.ListingOperationAsynTask;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.fragment.ListingOperationModel;
import lorence.construction.view.fragment.listing.module.ListingView;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingPresenterImpl implements ListingPresenter {

    private ListingModel mListingModel;
    private ListingOperationModel mListingOperationModel;

    private Context mContext;
    private HomeActivity mActivity;
    private ListingView mListingView;

    public ListingPresenterImpl(Context context, HomeActivity activity, ListingView listingView, ListingModel listingModel, ListingOperationModel listingOperationModel, ListingAsynTask listingAsynTask, ListingOperationAsynTask listingOperationAsynTask) {
        mContext = context;
        mActivity = activity;
        mListingView = listingView;
        mListingModel = listingModel;
        mListingOperationModel = listingOperationModel;
        listingModel.attachListingAsynTask(listingAsynTask);
        listingModel.attachListingPresenter(this);
        listingOperationModel.attachListingOperationAsynTask(listingOperationAsynTask);
    }

    @Override
    public void saveListings(List<Listing> list) {
        mListingModel.inertListings(list);
    }

    @Override
    public void saveListingOperations(List<ListingOperation> list) {
        mListingOperationModel.inertListingOperationByListingPresenters(list, this);
    }

    @Override
    public void onInsertListingsSuccess() {
    }

    @Override
    public void onInsertListingsFailed() {

    }

    @Override
    public void getListings() {
        mListingModel.getListings();
    }

    @Override
    public void getListingOperations() {
        mListingOperationModel.getListingOperationByListingPresenters(this);
    }

    @Override
    public void onGetListingsSuccess(List<Listing> listings) {
        mListingView.onGetListingsSuccess(listings);
    }

    @Override
    public void onGetListingOperationsSuccess(List<ListingOperation> listingOperations) {
        mListingView.onGetListingOperationsSuccess(listingOperations);
    }

}
