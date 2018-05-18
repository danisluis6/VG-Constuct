package lorence.construction.di.module.home;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.helper.Validator;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.activity.home.HomePresenter;
import lorence.construction.view.activity.home.HomePresenterImpl;
import lorence.construction.view.fragment.about.AboutFragment;
import lorence.construction.view.fragment.beams.BeamFragment;
import lorence.construction.view.fragment.listing.ListingFragment;
import lorence.construction.view.fragment.setting.SettingFragment;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

@Module
public class HomeModule {

    private HomeActivity mHomeActivity;

    public HomeModule(HomeActivity homeActivity) {
        this.mHomeActivity = homeActivity;
    }

    @Provides
    @ActivityScope
    HomeActivity provideHomeActivity() {
        return mHomeActivity;
    }

    @Provides
    @ActivityScope
    HomePresenter provideHomePresenter(/* get Parents */Validator validator, /* get Parents */Context context, /* get its */HomeActivity homeActivity,
                                           ListingFragment listingFragment,
                                           BeamFragment beamFragment,
                                           SettingFragment settingFragment,
                                           AboutFragment aboutFragment) {
        return new HomePresenterImpl(validator, context, homeActivity,
                listingFragment,
                beamFragment,
                settingFragment,
                aboutFragment
                );
    }
}
