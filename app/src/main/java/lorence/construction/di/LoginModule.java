package lorence.construction.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import lorence.construction.helper.Validator;
import lorence.construction.scope.ActivityScope;
import lorence.construction.view.activity.login.LoginActivity;
import lorence.construction.view.activity.login.LoginPresenter;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

@Module
public class LoginModule {

    private LoginActivity mLoginActivity;

    public LoginModule(LoginActivity loginActivity) {
        this.mLoginActivity = loginActivity;
    }

    @Provides
    @ActivityScope
    LoginActivity provideLoginView() {
        return mLoginActivity;
    }

    @Provides
    @ActivityScope
    LoginPresenter provideLoginPresenter(/* get Parents */Validator validator, /* get Parents */Context context, /* get its */LoginActivity loginActivity) {
        return new LoginPresenter(validator, context, loginActivity);
    }
}
