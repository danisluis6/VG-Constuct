package lorence.construction.di.module.listing;

import android.content.Context;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import lorence.construction.data.storage.async.ListingAsynTask;
import lorence.construction.data.storage.async.ListingAsynTaskImpl;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.utitilize.Utils;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.ListingFragment;
import lorence.construction.view.fragment.listing.ListingModel;
import lorence.construction.view.fragment.listing.ListingPresenter;
import lorence.construction.view.fragment.listing.ListingPresenterImpl;
import lorence.construction.view.fragment.listing.adapter.ListingAdapter;
import lorence.construction.view.fragment.listing.module.GridSpacingItemDecoration;
import lorence.construction.view.fragment.listing.module.ListingDataSource;
import lorence.construction.view.fragment.listing.module.ListingDataSourceImpl;
import lorence.construction.view.fragment.listing.module.ListingView;

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
    private ListingView mListingView;

    public ListingModule(Context context, HomeActivity homeActivity, ListingFragment fragment, ListingView listingView) {
        mContext = context;
        mActivity = homeActivity;
        mFragment = fragment;
        mListingView = listingView;
    }

    @Provides
    @ActivityScope
    ListingAsynTask provideListingAsynTask() {
        return new ListingAsynTaskImpl();
    }

    @Provides
    @ActivityScope
    ListingPresenter provideListingPresenter(Context context, HomeActivity activity, ListingModel listingModel, ListingAsynTask listingAsynTask) {
        return new ListingPresenterImpl(context, activity, mListingView, listingModel, listingAsynTask);
    }

    @Provides
    @ActivityScope
    ListingAdapter provideListingAdapter(Context context) {
        return new ListingAdapter(context, mFragment, new ArrayList<Listing>());
    }

    @Provides
    @ActivityScope
    ListingDataSource provideListingDataSource() {
        return new ListingDataSourceImpl();
    }

    @Provides
    @ActivityScope
    GridSpacingItemDecoration provideGridSpacingItemDecoration() {
        return new GridSpacingItemDecoration(2, Utils.dpToPx(mActivity,10), true);
    }
}
