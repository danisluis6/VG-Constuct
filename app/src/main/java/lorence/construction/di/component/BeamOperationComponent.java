package lorence.construction.di.component;

import dagger.Subcomponent;
import lorence.construction.di.module.beams.child.BeamOperationModule;
import lorence.construction.di.scope.FragmentScope;
import lorence.construction.view.fragment.beams.fragment.BeamsOperationFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@FragmentScope
@Subcomponent(
        modules = {
            BeamOperationModule.class
        }
)

public interface BeamOperationComponent {
    BeamsOperationFragment inject(BeamsOperationFragment fragment);
}
