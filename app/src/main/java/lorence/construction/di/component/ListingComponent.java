package lorence.construction.di.component;

import dagger.Subcomponent;
import lorence.construction.di.module.listing.FragmentListingModule;
import lorence.construction.di.module.listing.ListingModule;
import lorence.construction.di.module.listing.child.ListingOperationModule;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.view.fragment.listing.ListingFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@ActivityScope
@Subcomponent(
        modules = {
                ListingModule.class,
                FragmentListingModule.class
        }
)

public interface ListingComponent {
    ListingFragment inject(ListingFragment fragment);

    ListingOperationComponent plus(ListingOperationModule module);
}
