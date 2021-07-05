package lorence.construction.di.component;

import dagger.Subcomponent;
import lorence.construction.di.module.listing.child.CalculateFragmentModule;
import lorence.construction.di.scope.FragmentScope;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@FragmentScope
@Subcomponent(
        modules = CalculateFragmentModule.class
)

public interface CalculateFragmentComponent {
    CalculateFragment inject(CalculateFragment fragment);
}
