package lorence.construction.di.module.listing.child;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import lorence.construction.data.storage.async.ListingOperationAsynTask;
import lorence.construction.di.scope.FragmentScope;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateFragment;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateModel;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculatePresenter;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculatePresenterImpl;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateView;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class CalculateFragmentModule {

    private Context mContext;
    private HomeActivity mActivity;
    private CalculateFragment mFragment;
    private CalculateView mCalculateView;

    public CalculateFragmentModule(Context context, HomeActivity homeActivity, CalculateFragment fragment, CalculateView calculateView) {
        mContext = context;
        mActivity = homeActivity;
        mFragment = fragment;
        mCalculateView = calculateView;
    }

    @Provides
    @FragmentScope
    CalculatePresenter provideCalculatePresenter(Context context, HomeActivity activity, CalculateModel calculateModel, ListingOperationAsynTask listingOperationAsynTask) {
        return new CalculatePresenterImpl(context, activity, mCalculateView, calculateModel, listingOperationAsynTask);
    }

}