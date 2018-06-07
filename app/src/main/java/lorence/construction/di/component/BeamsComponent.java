package lorence.construction.di.component;

import dagger.Subcomponent;
import lorence.construction.di.module.beams.BeamsModule;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.di.scope.FragmentScope;
import lorence.construction.view.fragment.beams.BeamsFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@FragmentScope
@Subcomponent(
        modules = {
                BeamsModule.class
        }
)

public interface BeamsComponent {
    BeamsFragment inject(BeamsFragment fragment);
}
