package lorence.construction.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
        HomeComponent plus(HomeModule module);
}
