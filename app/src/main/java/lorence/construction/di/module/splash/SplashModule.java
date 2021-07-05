package lorence.construction.di.module.splash;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import lorence.construction.di.scope.ActivityScope;
import lorence.construction.service.VogoApiService;
import lorence.construction.view.activity.splash.SplashActivity;
import retrofit2.Retrofit;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class SplashModule {

    private Context mContext;
    private SplashActivity mSplashActivity;
    private SplashView mSplashView;

    public SplashModule(Context context, SplashActivity splashActivity, SplashView splashView) {
        mContext = context;
        mSplashActivity = splashActivity;
        mSplashView = splashView;
    }

    @Provides
    @ActivityScope
    SplashActivity provideSplashActivity() {
        return mSplashActivity;
    }

    @Provides
    @ActivityScope
    VogoApiService provideVogoApiService(Retrofit retrofit) {
        return retrofit.create(VogoApiService.class);
    }

    @Provides
    @ActivityScope
    SplashPresenter provideSplashPresenter(Context context, SplashActivity activity, SplashModel splashModel, VogoApiService vogoApiService) {
        return new SplashPresenterImpl(context, activity, mSplashView, splashModel, vogoApiService);
    }

}
