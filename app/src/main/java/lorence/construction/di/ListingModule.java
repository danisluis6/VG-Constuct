package lorence.construction.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import lorence.construction.scope.ActivityScope;
import lorence.construction.utitilize.Utils;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.ListingFragment;
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
    HomeActivity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityScope
    GridSpacingItemDecoration provideGridSpacingItemDecoration() {
        return new GridSpacingItemDecoration(2, Utils.dpToPx(mActivity,10), true);
    }
}
