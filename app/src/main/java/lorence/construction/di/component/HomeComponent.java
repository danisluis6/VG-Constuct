package lorence.construction.di.component;

import dagger.Subcomponent;
import lorence.construction.di.module.beams.BeamsModule;
import lorence.construction.di.module.beams.FragmentBeamsModule;
import lorence.construction.di.module.concrete.DetailConcreteModule;
import lorence.construction.di.module.home.FragmentModule;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.listing.FragmentListingModule;
import lorence.construction.di.module.listing.ListingModule;
import lorence.construction.di.module.listing.child.CalculateFragmentModule;
import lorence.construction.di.module.listing.child.MordalFragmentModule;
import lorence.construction.di.module.listing.child.ReferenceFragmentModule;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.view.activity.home.HomeActivity;

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
                FragmentModule.class,
                FragmentListingModule.class,
                FragmentBeamsModule.class
        }
)
public interface HomeComponent {

    HomeActivity inject(HomeActivity homeActivity);

    ListingComponent plus(ListingModule module);
    BeamsComponent plus(BeamsModule module);

    CalculateFragmentComponent plus(CalculateFragmentModule module);
    MordalFragmentComponent plus(MordalFragmentModule module);
    ReferenceFragmentComponent plus(ReferenceFragmentModule module);
    DetailConcreteComponent plus(DetailConcreteModule module);
}


