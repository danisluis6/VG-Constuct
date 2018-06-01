package lorence.construction.di.component;

import dagger.Subcomponent;
import lorence.construction.di.module.listing.child.MordalFragmentModule;
import lorence.construction.di.scope.FragmentScope;
import lorence.construction.view.fragment.listing.fragment.child.mordal.MordalFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@FragmentScope
@Subcomponent(
        modules = MordalFragmentModule.class
)

public interface MordalFragmentComponent {
    MordalFragment inject(MordalFragment fragment);
}
