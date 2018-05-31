package lorence.construction.view.fragment.listing.fragment;

import android.content.Context;

import java.util.List;

import lorence.construction.data.storage.async.ListingOperationAsynTask;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.view.activity.home.HomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingOperationPresenterImpl implements ListingOperationPresenter {

    private ListingOperationModel mListingOperationModel;

    private Context mContext;
    private HomeActivity mActivity;
    private ListingOperationView mListingOperationView;

    public ListingOperationPresenterImpl(Context context, HomeActivity activity, ListingOperationView listingOperationView, ListingOperationModel listingOperationModel, ListingOperationAsynTask listingOperationAsynTask) {
        mContext = context;
        mActivity = activity;
        mListingOperationModel = listingOperationModel;
        mListingOperationView = listingOperationView;
        listingOperationModel.attachListingOperationAsynTask(listingOperationAsynTask);
        listingOperationModel.attachListingOperationPresenter(this);
    }

    @Override
    public void getListingOperations() {
        mListingOperationModel.getListingOperationByListingOperationPresenters(this);
    }

    @Override
    public void onGetListingOperationsSuccess(List<ListingOperation> listingOperations) {
        mListingOperationView.onGetListingOperationsSuccess(listingOperations);
    }

}
