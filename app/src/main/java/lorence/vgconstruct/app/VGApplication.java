package lorence.vgconstruct.app;

import android.content.Context;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class VGApplication extends android.app.Application {

    private VGAppComponent mApplicationComponent;
    private Context mContext;

    public static VGApplication get(Context context) {
        return (VGApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
        mContext = getApplicationContext();
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
