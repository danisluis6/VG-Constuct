package lorence.construction.di.component;

import dagger.Subcomponent;
import lorence.construction.di.module.concrete.DetailConcreteModule;
import lorence.construction.di.scope.FragmentScope;
import lorence.construction.view.fragment.concrete.DetailedConcreteFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@FragmentScope
@Subcomponent(
        modules = {
            DetailConcreteModule.class
        }
)

public interface DetailConcreteComponent {
    DetailedConcreteFragment inject(DetailedConcreteFragment fragment);
}
