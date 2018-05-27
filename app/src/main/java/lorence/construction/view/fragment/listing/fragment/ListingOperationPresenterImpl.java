package lorence.construction.view.fragment.listing.fragment;

import android.content.Context;

import java.util.List;

import lorence.construction.data.storage.async.ListingAsynTask;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.ListingModel;
import lorence.construction.view.fragment.listing.ListingPresenter;
import lorence.construction.view.fragment.listing.module.ListingView;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingOperationPresenterImpl implements ListingOperationPresenter {

    private ListingModel mListingModel;

    private Context mContext;
    private HomeActivity mActivity;
    private ListingView mListingView;

    public ListingOperationPresenterImpl(Context context, HomeActivity activity, ListingView listingView, ListingModel listingModel, ListingAsynTask listingAsynTask) {
        mContext = context;
        mActivity = activity;
        mListingModel = listingModel;
        mListingView = listingView;
        listingModel.attachListingAsynTask(listingAsynTask);
        listingModel.attachListingPresenter(this);
    }

    @Override
    public void getListingOperations() {
        mListingModel.getListingOperations();
    }

    @Override
    public void onGetListingOperationsSuccess(List<ListingOperation> listingOperations) {
        mListingView.onGetListingOperationsSuccess(listingOperations);
    }

}
