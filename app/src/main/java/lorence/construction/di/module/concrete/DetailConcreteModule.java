package lorence.construction.di.module.concrete;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import lorence.construction.di.scope.FragmentScope;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.concrete.DetailedConcreteFragment;
import lorence.construction.view.fragment.concrete.DetailedConcreteView;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class DetailConcreteModule {

    private Context mContext;
    private HomeActivity mActivity;
    private DetailedConcreteFragment mFragment;
    private DetailedConcreteView mView;

    public DetailConcreteModule(Context context, HomeActivity activity, DetailedConcreteFragment fragment, DetailedConcreteView view) {
        mContext = context;
        mActivity = activity;
        mFragment = fragment;
        mView = view;
    }

    @Provides
    @FragmentScope
    DetailedConcreteFragment provideDetailedConcreteFragment() {
        return new DetailedConcreteFragment();
    }
}
