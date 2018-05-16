package lorence.construction.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import lorence.construction.helper.Validator;
import lorence.construction.scope.ActivityScope;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.activity.home.HomePresenter;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

@Module
public class HomeModule {

    private HomeActivity mHomeActivity;

    public HomeModule(HomeActivity homeActivity) {
        this.mHomeActivity = homeActivity;
    }

    @Provides
    @ActivityScope
    HomeActivity provideHomeActivity() {
        return mHomeActivity;
    }

    @Provides
    @ActivityScope
    HomePresenter provideLoginPresenter(/* get Parents */Validator validator, /* get Parents */Context context, /* get its */HomeActivity homeActivity) {
        return new HomePresenter(validator, context, homeActivity);
    }
}
