package lorence.construction.di.module.home;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.helper.Validator;
import lorence.construction.other.TitleStringUtils;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.activity.home.HomePresenter;
import lorence.construction.view.activity.home.HomePresenterImpl;
import lorence.construction.view.fragment.about.AboutFragment;
import lorence.construction.view.fragment.beams.BeamsFragment;
import lorence.construction.view.fragment.concrete.DetailedConcreteFragment;
import lorence.construction.view.fragment.listing.ListingFragment;
import lorence.construction.view.fragment.listing.adapter.PagerAdapterPushed;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateFragment;
import lorence.construction.view.fragment.listing.fragment.child.mordal.MordalFragment;
import lorence.construction.view.fragment.listing.fragment.child.reference.ReferenceFragment;

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
                                           BeamsFragment beamFragment,
                                           DetailedConcreteFragment detailedConcreteFragment,
                                           AboutFragment aboutFragment) {
        return new HomePresenterImpl(validator, context, homeActivity,
                listingFragment,
                beamFragment,
                detailedConcreteFragment,
                aboutFragment
                );
    }

    @Provides
    @ActivityScope
    FragmentManager provideFragmentSupportManager() { return this.mHomeActivity.getSupportFragmentManager(); }

    @Provides
    @ActivityScope
    PagerAdapterPushed providePagerAdapterPushed(FragmentManager fragmentManager, TitleStringUtils titleStringUtils,
                                                 CalculateFragment calculateFragment,
                                                 ReferenceFragment referenceFragment,
                                                 MordalFragment mordalFragment) {
        return new PagerAdapterPushed(fragmentManager, titleStringUtils, calculateFragment, referenceFragment, mordalFragment);
    }
}
