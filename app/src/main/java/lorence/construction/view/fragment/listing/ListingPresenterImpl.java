package lorence.construction.view.fragment.listing;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import lorence.construction.data.storage.async.ListingAsynTask;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.module.ListingView;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingPresenterImpl implements ListingPresenter {

    private ListingModel mListingModel;

    private Context mContext;
    private HomeActivity mActivity;
    private ListingView mListingView;

    public ListingPresenterImpl(Context context, HomeActivity activity, ListingView listingView, ListingModel listingModel, ListingAsynTask listingAsynTask) {
        mContext = context;
        mActivity = activity;
        mListingModel = listingModel;
        mListingView = listingView;
        listingModel.attachListingAsynTask(listingAsynTask);
        listingModel.attachListingPresenter(this);
    }

    @Override
    public void saveListings(List<Listing> list) {
        mListingModel.inertListings(list);
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
    public void onGetListingsSuccess(List<Listing> listings) {
        mListingView.onGetListingsSuccess(listings);
    }

}
