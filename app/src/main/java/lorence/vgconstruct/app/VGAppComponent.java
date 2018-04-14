package lorence.vgconstruct.app;

import android.content.Context;

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
                VGAppModule.class
        }
)
public interface VGAppComponent {

        // LoginComponent plus(LoginModule module);
        Context exposeContext();

}
