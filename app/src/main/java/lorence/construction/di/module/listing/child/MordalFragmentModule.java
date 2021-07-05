package lorence.construction.di.module.listing.child;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import lorence.construction.di.scope.FragmentScope;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.fragment.child.mordal.MordalFragment;
import lorence.construction.view.fragment.listing.fragment.child.mordal.MordalModel;
import lorence.construction.view.fragment.listing.fragment.child.mordal.MordalPresenter;
import lorence.construction.view.fragment.listing.fragment.child.mordal.MordalPresenterImpl;
import lorence.construction.view.fragment.listing.fragment.child.mordal.MordalView;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class MordalFragmentModule {

    private Context mContext;
    private HomeActivity mActivity;
    private MordalFragment mFragment;
    private MordalView mMordalView;

    public MordalFragmentModule(Context context, HomeActivity homeActivity, MordalFragment fragment, MordalView mordalView) {
        mContext = context;
        mActivity = homeActivity;
        mFragment = fragment;
        mMordalView = mordalView;
    }

    @Provides
    @FragmentScope
    MordalPresenter provideMordalPresenter(Context context, HomeActivity activity, MordalModel mordalModel) {
        return new MordalPresenterImpl(context, activity, mMordalView, mordalModel);
    }

}