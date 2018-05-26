package lorence.construction.di.component;

import dagger.Subcomponent;
import lorence.construction.di.module.listing.child.ListingOperationModule;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.view.fragment.listing.fragment.ListingOperationFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@ActivityScope
@Subcomponent(
        modules = {
            ListingOperationModule.class
        }
)

public interface ListingOperationComponent {
    ListingOperationFragment inject(ListingOperationFragment fragment);
}
