package lorence.construction.di.component;

import dagger.Subcomponent;
import lorence.construction.di.module.splash.SplashModule;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.view.activity.splash.SplashActivity;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@ActivityScope
@Subcomponent(

        modules = {
                SplashModule.class
        }
)
public interface SplashComponent {

    SplashActivity inject(SplashActivity splashActivity);
}


