package lorence.construction.di.module.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import lorence.construction.app.Application;
import lorence.construction.helper.ConditionCalculating;
import lorence.construction.helper.ConverterUtils;
import lorence.construction.helper.RegularUtils;
import lorence.construction.helper.Validator;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class AppModule {

    private Application mApplication;
    private Context mContext;

    public AppModule(Application application, Context context) {
        this.mApplication = application;
        this.mContext = context;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }

    @Provides
    @Singleton
    Validator provideValidator() {
        return new Validator();
    }

    @Provides
    @Singleton
    RegularUtils provideRegularUtils() {
        return new RegularUtils();
    }

    @Provides
    @Singleton
    ConditionCalculating provideConditionCalculating() {
        return new ConditionCalculating();
    }

    @Provides
    @Singleton
    ConverterUtils provideConverterUtils() {
        return new ConverterUtils();
    }

}
