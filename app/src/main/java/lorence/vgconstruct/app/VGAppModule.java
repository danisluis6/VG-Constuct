package lorence.vgconstruct.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import lorence.vgconstruct.helper.Validator;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class VGAppModule {

    private VGApplication mApplication;
    private Context mContext;

    VGAppModule(VGApplication application, Context context) {
        this.mApplication = application;
        this.mContext = context;
    }

    @Provides
    @Singleton
    VGApplication provideApplication() {
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

}
