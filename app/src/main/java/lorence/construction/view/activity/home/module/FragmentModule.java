package lorence.construction.view.activity.home.module;

import android.content.Context;

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
    ListingFragment provideListingFragment(Context context, HomeActivity homeActivity) {
        return ListingFragment.newInstance(context, homeActivity);
    }

    @Provides
    @ActivityScope
    BeamFragment provideBeamFragment() {
        return (BeamFragment) BeamFragment.newInstance();
    }

    @Provides
    @ActivityScope
    SettingFragment provideSettingFragment() {
        return (SettingFragment) SettingFragment.newInstance();
    }

    @Provides
    @ActivityScope
    AboutFragment provideAboutFragment() {
        return (AboutFragment) AboutFragment.newInstance();
    }

}
