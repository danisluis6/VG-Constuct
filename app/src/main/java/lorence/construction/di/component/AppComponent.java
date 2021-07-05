package lorence.construction.di.component;

import javax.inject.Singleton;

import dagger.Component;
import lorence.construction.di.module.app.AppModule;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.app.RoomModule;
import lorence.construction.di.module.splash.SplashModule;
import lorence.construction.helper.connect.FactoryModule;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                RoomModule.class,
                FactoryModule.class
        }
)
public interface AppComponent {
        HomeComponent plus(HomeModule module);
        SplashComponent plus(SplashModule module);
}
