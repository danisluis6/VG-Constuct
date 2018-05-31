package lorence.construction.di.module.listing.child;

import android.content.Context;

import dagger.Module;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateFragment;
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

}