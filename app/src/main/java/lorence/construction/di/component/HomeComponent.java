package lorence.construction.di.component;

import dagger.Subcomponent;
import lorence.construction.di.module.HomeModule;
import lorence.construction.di.module.ListingModule;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.activity.home.module.FragmentModule;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@ActivityScope
@Subcomponent(

        modules = {
                HomeModule.class,
                FragmentModule.class
        }
)
public interface HomeComponent {

    HomeActivity inject(HomeActivity homeActivity);

    ListingComponent plus(ListingModule module);
}


