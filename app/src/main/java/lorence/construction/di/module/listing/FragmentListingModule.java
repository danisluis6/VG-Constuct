package lorence.construction.di.module.listing;

import dagger.Module;
import dagger.Provides;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.di.scope.FragmentScope;
import lorence.construction.view.fragment.listing.fragment.ConcreteFragment;
import lorence.construction.view.fragment.listing.fragment.ListingOperationFragment;
import lorence.construction.view.fragment.listing.fragment.SteelFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class FragmentListingModule {

    public FragmentListingModule() {
    }

    @Provides
    @FragmentScope
    ListingOperationFragment provideListingOperationFragment() {
        return new ListingOperationFragment();
    }

    @Provides
    @FragmentScope
    ConcreteFragment provideConcreteFragment() {
        return new ConcreteFragment();
    }

    @Provides
    @FragmentScope
    SteelFragment provideSteelFragment() {
        return new SteelFragment();
    }
}
