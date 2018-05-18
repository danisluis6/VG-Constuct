package lorence.construction.di.module.app;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import lorence.construction.app.Application;
import lorence.construction.data.AppDatabase;
import lorence.construction.view.fragment.listing.ListingModelImpl;
import lorence.construction.view.fragment.listing.ListingModel;
import lorence.construction.data.storage.dao.ListingDao;

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

    @Singleton
    @Provides
    AppDatabase provideAppDatabase() {
        return mAppDatabase;
    }

    @Singleton
    @Provides
    ListingDao providesListingDao() {
        return mAppDatabase.getListingDao();
    }

    @Singleton
    @Provides
    ListingModel providesListingModel(ListingDao listingDao) {
        return new ListingModelImpl(mContext, listingDao);
    }

}
