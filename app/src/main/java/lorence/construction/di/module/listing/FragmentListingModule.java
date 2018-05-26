package lorence.construction.di.module.listing;

import dagger.Module;
import dagger.Provides;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.view.fragment.listing.fragment.ListingOperationFragment;

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
    @ActivityScope
    ListingOperationFragment provideListingOperationFragment() {
        return new ListingOperationFragment();
    }
}
