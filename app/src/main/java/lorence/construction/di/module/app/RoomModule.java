package lorence.construction.di.module.app;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import lorence.construction.app.Application;
import lorence.construction.data.AppDatabase;
import lorence.construction.data.storage.async.BeamsAsynTask;
import lorence.construction.data.storage.async.BeamsAsynTaskImpl;
import lorence.construction.data.storage.async.ListingAsynTask;
import lorence.construction.data.storage.async.ListingAsynTaskImpl;
import lorence.construction.data.storage.async.ListingOperationAsynTask;
import lorence.construction.data.storage.async.ListingOperationAsynTaskImpl;
import lorence.construction.data.storage.dao.BeamsDao;
import lorence.construction.data.storage.dao.ListingDao;
import lorence.construction.data.storage.dao.ListingOperationDao;
import lorence.construction.view.fragment.beams.BeamsModel;
import lorence.construction.view.fragment.beams.BeamsModelImpl;
import lorence.construction.view.fragment.listing.ListingModel;
import lorence.construction.view.fragment.listing.ListingModelImpl;
import lorence.construction.view.fragment.listing.fragment.ListingOperationModel;
import lorence.construction.view.fragment.listing.fragment.ListingOperationModelImpl;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateModel;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateModelImpl;

/**
 * Created by vuongluis on 4/14/2018.
 *
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
    BeamsDao provideBeamsDao() {
        return mAppDatabase.getBeamsDao();
    }

    @Singleton
    @Provides
    ListingOperationDao providesListingOperationDao() {
        return mAppDatabase.getListingOperationDao();
    }

    @Singleton
    @Provides
    ListingModel providesListingModel(ListingDao listingDao) {
        return new ListingModelImpl(mContext, listingDao);
    }

    @Singleton
    @Provides
    BeamsModel provideBeamsModel(BeamsDao beamsDao) {
        return new BeamsModelImpl(mContext, beamsDao);
    }

    @Singleton
    @Provides
    ListingOperationModel providesListingOperationModel(ListingOperationDao listingOperationDao) {
        return new ListingOperationModelImpl(mContext, listingOperationDao);
    }

    @Singleton
    @Provides
    CalculateModel provideCalculateModel(ListingOperationDao listingOperationDao) {
        return new CalculateModelImpl(mContext, listingOperationDao);
    }

    @Provides
    @Singleton
    ListingAsynTask provideListingAsynTask() {
        return new ListingAsynTaskImpl();
    }

    @Provides
    @Singleton
    BeamsAsynTask provideBeamsAsynTask() {
        return new BeamsAsynTaskImpl();
    }

    @Provides
    @Singleton
    ListingOperationAsynTask provideListingOperationAsynTask() {
        return new ListingOperationAsynTaskImpl();
    }

}
