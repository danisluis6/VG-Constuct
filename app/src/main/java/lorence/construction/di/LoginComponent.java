package lorence.construction.di;

import dagger.Subcomponent;
import lorence.construction.scope.ActivityScope;
import lorence.construction.view.activity.login.LoginView;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@ActivityScope
@Subcomponent(
        modules = LoginModule.class
)
public interface LoginComponent {

    LoginView inject(LoginView loginView);
}


