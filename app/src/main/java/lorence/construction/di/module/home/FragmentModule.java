package lorence.construction.di.module.home;

import dagger.Module;
import dagger.Provides;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.view.fragment.about.AboutFragment;
import lorence.construction.view.fragment.beams.BeamsFragment;
import lorence.construction.view.fragment.listing.ListingFragment;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateFragment;
import lorence.construction.view.fragment.listing.fragment.child.mordal.MordalFragment;
import lorence.construction.view.fragment.listing.fragment.child.reference.ReferenceFragment;
import lorence.construction.view.fragment.listing.fragment.child.result.ResultFragment;
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
    ListingFragment provideListingFragment() {
        return new ListingFragment();
    }

    @Provides
    @ActivityScope
    BeamsFragment provideBeamFragment() {
        return new BeamsFragment();
    }

    @Provides
    @ActivityScope
    SettingFragment provideSettingFragment() {
        return new SettingFragment();
    }

    @Provides
    @ActivityScope
    AboutFragment provideAboutFragment() {
        return new AboutFragment();
    }

    @Provides
    @ActivityScope
    CalculateFragment provideCalculateFragment() {
        return new CalculateFragment();
    }

    @Provides
    @ActivityScope
    ResultFragment provideResultFragment() {
        return new ResultFragment();
    }

    @Provides
    @ActivityScope
    MordalFragment provideMordalFragment() {
        return new MordalFragment();
    }

    @Provides
    @ActivityScope
    ReferenceFragment provideReferenceFragment() {
        return new ReferenceFragment();
    }

}
