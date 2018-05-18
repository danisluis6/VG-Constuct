package lorence.construction.view.activity.home.module;

import dagger.Module;
import dagger.Provides;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.about.AboutFragment;
import lorence.construction.view.fragment.beams.BeamFragment;
import lorence.construction.view.fragment.listing.ListingFragment;
import lorence.construction.view.fragment.setting.SettingFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class FragmentModule {

    public FragmentModule() {
    }

    @Provides
    @ActivityScope
    ListingFragment provideListingFragment(HomeActivity homeActivity) {
        return (ListingFragment) ListingFragment.newInstance();
    }

    @Provides
    @ActivityScope
    BeamFragment provideBeamFragment(HomeActivity homeActivity) {
        return new BeamFragment(homeActivity);
    }

    @Provides
    @ActivityScope
    SettingFragment provideSettingFragment(HomeActivity homeActivity) {
        return new SettingFragment(homeActivity);
    }

    @Provides
    @ActivityScope
    AboutFragment provideAboutFragment(HomeActivity homeActivity) {
        return new AboutFragment(homeActivity);
    }

}
