package lorence.construction.di.module.listing.child;

import android.app.FragmentManager;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import lorence.construction.data.storage.async.ListingAsynTask;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.ListingModel;
import lorence.construction.view.fragment.listing.ListingPresenter;
import lorence.construction.view.fragment.listing.ListingPresenterImpl;
import lorence.construction.view.fragment.listing.fragment.ListingOperationFragment;
import lorence.construction.view.fragment.listing.fragment.ListingOperationPresenter;
import lorence.construction.view.fragment.listing.fragment.ListingOperationPresenterImpl;
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

    @Provides
    @ActivityScope
    FragmentManager provideFragmentManager() {
        return mActivity.getFragmentManager();
    }

    @Provides
    @ActivityScope
    ListingOperationPresenter provideListingOperationPresenter(Context context, HomeActivity activity, ListingModel listingModel, ListingAsynTask listingAsynTask) {
        return new ListingOperationPresenterImpl(context, activity, mListingOperationView, listingModel, listingAsynTask);
    }
}
