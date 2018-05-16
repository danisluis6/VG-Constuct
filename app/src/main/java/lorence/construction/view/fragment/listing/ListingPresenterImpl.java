package lorence.construction.view.fragment.listing;

import android.content.Context;

import java.util.List;

import lorence.construction.data.storage.entity.Listing;
import lorence.construction.view.activity.home.HomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingPresenterImpl implements ListingPresenter {

    ListingModel mListingModel;

    private Context mContext;
    private HomeActivity mActivity;

    public ListingPresenterImpl(Context context, HomeActivity activity, ListingModel listingModel) {
        mContext = context;
        mActivity = activity;
        mListingModel = listingModel;
    }

    @Override
    public void saveListings(List<Listing> list) {
        mListingModel.addAll(list);
    }

}
