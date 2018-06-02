package lorence.construction.di.module.beams;

import android.content.Context;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import lorence.construction.data.storage.async.BeamsAsynTask;
import lorence.construction.data.storage.entity.Beams;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.beams.BeamsFragment;
import lorence.construction.view.fragment.beams.BeamsModel;
import lorence.construction.view.fragment.beams.BeamsPresenter;
import lorence.construction.view.fragment.beams.BeamsPresenterImpl;
import lorence.construction.view.fragment.beams.BeamsView;
import lorence.construction.view.fragment.beams.adapter.BeamsAdapter;
import lorence.construction.view.fragment.listing.module.DataSource;
import lorence.construction.view.fragment.listing.module.ListingDataSourceImpl;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

@Module
public class BeamsModule {

    private Context mContext;
    private HomeActivity mActivity;
    private BeamsFragment mFragment;
    private BeamsView mBeamsView;

    public BeamsModule(Context context, HomeActivity homeActivity, BeamsFragment fragment, BeamsView beamsView) {
        mContext = context;
        mActivity = homeActivity;
        mFragment = fragment;
        mBeamsView = beamsView;
    }

    public BeamsModule(Context context, HomeActivity homeActivity, BeamsFragment fragment) {
        mContext = context;
        mActivity = homeActivity;
        mFragment = fragment;
    }

    @Provides
    @ActivityScope
    BeamsPresenter provideBeamsPresenter(Context context, HomeActivity activity, BeamsModel beamsModel, BeamsAsynTask beamsAsynTask) {
        return new BeamsPresenterImpl(context, activity, mBeamsView, beamsModel, beamsAsynTask);
    }

    @Provides
    @ActivityScope
    BeamsAdapter provideBeamsAdapter(Context context) {
        return new BeamsAdapter(context, mFragment, new ArrayList<Beams>());
    }

    @Provides
    @ActivityScope
    DataSource provideListingDataSource() {
        return new ListingDataSourceImpl();
    }
}
