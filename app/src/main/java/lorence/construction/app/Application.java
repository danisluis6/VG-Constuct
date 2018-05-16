package lorence.construction.app;

import android.content.Context;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import lorence.construction.di.component.AppComponent;
import lorence.construction.di.component.DaggerAppComponent;
import lorence.construction.di.module.AppModule;
import lorence.construction.di.module.RoomModule;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class Application extends android.app.Application {

    private AppComponent mApplicationComponent;
    private Context mContext;

    public static Bus eventBus;

    public static Application get(Context context) {
        return (Application) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        eventBus  = new Bus(ThreadEnforcer.ANY);
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

// https://medium.com/@alahammad/database-with-room-using-rxjava-764ee6124974
// https://medium.com/@marco_cattaneo/integrate-dagger-2-with-room-persistence-library-in-few-lines-abf48328eaeb

