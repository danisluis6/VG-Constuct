package lorence.construction.di.module;

import android.arch.persistence.room.Room;
import android.content.Context;

import dagger.Module;
import lorence.construction.app.Application;
import lorence.construction.model.storage.AppDatabase;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class RoomModule {

    private AppDatabase mAppDatabase;
    private Application mApplication;
    private Context mContext;

    public RoomModule(Application application, Context context) {
        mApplication = application;
        mContext = context;
        mAppDatabase = Room.databaseBuilder(application, AppDatabase.class, AppDatabase.DB_NAME).build();
    }
}
