package lorence.construction.view.fragment.listing;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import lorence.construction.data.storage.async.ListingAsynTask;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.view.activity.home.HomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingPresenterImpl implements ListingPresenter {

    private ListingModel mListingModel;

    private Context mContext;
    private HomeActivity mActivity;

    public ListingPresenterImpl(Context context, HomeActivity activity, ListingModel listingModel, ListingAsynTask listingAsynTask) {
        mContext = context;
        mActivity = activity;
        mListingModel = listingModel;
        listingModel.attachListingAsynTask(listingAsynTask);
        listingModel.attachListingPresenter(this);
    }

    @Override
    public void saveListings(List<Listing> list) {
        mListingModel.inertListings(list);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailed() {

    }

}
