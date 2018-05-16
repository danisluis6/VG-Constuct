package lorence.construction.di.component;

import javax.inject.Singleton;

import dagger.Component;
import lorence.construction.di.module.AppModule;
import lorence.construction.di.module.HomeModule;
import lorence.construction.di.module.RoomModule;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Singleton
@Component(
        modules = {
                AppModule.class,
                RoomModule.class
        }
)
public interface AppComponent {
        HomeComponent plus(HomeModule module);
}