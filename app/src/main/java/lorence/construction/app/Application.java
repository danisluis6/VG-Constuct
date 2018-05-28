package lorence.construction.app;

import android.content.Context;

import lorence.construction.di.component.AppComponent;
import lorence.construction.di.component.DaggerAppComponent;
import lorence.construction.di.module.app.AppModule;
import lorence.construction.di.module.app.RoomModule;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class Application extends android.app.Application {

    private AppComponent mApplicationComponent;
    private Context mContext;
    private static Application sInstance;

    public static synchronized Application getInstance() {
        if (sInstance == null) {
            sInstance = new Application();
        }
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        sInstance = this;
        initAppComponent();
    }

    private void initAppComponent() {
        mApplicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this,mContext))
                .roomModule(new RoomModule(this, mContext))
                .build();
    }

    public AppComponent getAppComponent() {
        return mApplicationComponent;
    }

}


