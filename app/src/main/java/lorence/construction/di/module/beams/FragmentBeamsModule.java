package lorence.construction.di.module.beams;

import dagger.Module;
import dagger.Provides;
import lorence.construction.di.scope.FragmentScope;
import lorence.construction.view.fragment.beams.fragment.BeamsOperationFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class FragmentBeamsModule {

    public FragmentBeamsModule() {
    }

    @Provides
    @FragmentScope
    BeamsOperationFragment provideBeamsOperationFragment() {
        return new BeamsOperationFragment();
    }
}
