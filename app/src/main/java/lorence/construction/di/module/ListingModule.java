package lorence.construction.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import lorence.construction.data.storage.async.ListingAsynTask;
import lorence.construction.data.storage.async.ListingAsynTaskImpl;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.utitilize.Utils;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.ListingFragment;
import lorence.construction.view.fragment.listing.ListingModel;
import lorence.construction.view.fragment.listing.ListingPresenter;
import lorence.construction.view.fragment.listing.ListingPresenterImpl;
import lorence.construction.view.fragment.listing.module.GridSpacingItemDecoration;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

@Module
public class ListingModule {

    private Context mContext;
    private HomeActivity mActivity;
    private ListingFragment mFragment;

    public ListingModule(Context context, HomeActivity homeActivity, ListingFragment fragment) {
        mContext = context;
        mActivity = homeActivity;
        mFragment = fragment;
    }

    @Provides
    @ActivityScope
    ListingFragment provideFragment() {
        return mFragment;
    }

    @Provides
    @ActivityScope
    ListingAsynTask provideListingAsynTask() {
        return new ListingAsynTaskImpl();
    }

    @Provides
    @ActivityScope
    ListingPresenter provideListingPresenter(Context context, HomeActivity activity, ListingModel listingModel, ListingAsynTask listingAsynTask) {
        return new ListingPresenterImpl(context, activity, listingModel, listingAsynTask);
    }

    @Provides
    @ActivityScope
    GridSpacingItemDecoration provideGridSpacingItemDecoration() {
        return new GridSpacingItemDecoration(2, Utils.dpToPx(mActivity,10), true);
    }
}
