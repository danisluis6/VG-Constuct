package lorence.vgconstruct.app;

import android.content.Context;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class VGApplication extends android.app.Application {

    private VGAppComponent mApplicationComponent;
    private Context mContext;

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static float SCREEN_WIDTH_DP;
    public static float SCREEN_HEIGHT_DP;

    // Event
    public static Bus eventBus;

    public static VGApplication get(Context context) {
        return (VGApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
        mContext = getApplicationContext();
        eventBus  = new Bus(ThreadEnforcer.ANY);
    }

    private void initAppComponent() {
        mApplicationComponent = DaggerVGAppComponent.builder()
                .vGAppModule(new VGAppModule(this,mContext))
                .build();
    }

    public VGAppComponent getAppComponent() {
        return mApplicationComponent;
    }

}
