package lorence.construction.di;

import dagger.Module;
import dagger.Provides;
import lorence.construction.scope.ActivityScope;
import lorence.construction.view.activity.login.LoginView;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

@Module
public class LoginModule {

    private LoginView mLoginView;

    public LoginModule(LoginView loginView) {
        this.mLoginView = loginView;
    }

    @Provides
    @ActivityScope
    LoginView provideLoginView() {
        return mLoginView;
    }
}
