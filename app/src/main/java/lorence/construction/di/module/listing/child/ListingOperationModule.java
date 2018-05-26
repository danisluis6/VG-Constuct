package lorence.construction.di.module.listing.child;

import android.content.Context;

import dagger.Module;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.fragment.ListingOperationFragment;
import lorence.construction.view.fragment.listing.fragment.ListingOperationView;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

@Module
public class ListingOperationModule {

    private Context mContext;
    private HomeActivity mActivity;
    private ListingOperationFragment mFragment;
    private ListingOperationView mListingOperationView;

    public ListingOperationModule(Context context, HomeActivity homeActivity, ListingOperationFragment fragment, ListingOperationView listingOperationView) {
        mContext = context;
        mActivity = homeActivity;
        mFragment = fragment;
        mListingOperationView = listingOperationView;
    }
}
