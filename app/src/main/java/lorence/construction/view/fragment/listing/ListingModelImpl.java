package lorence.construction.view.fragment.listing;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import lorence.construction.app.Application;
import lorence.construction.data.AppDatabase;
import lorence.construction.data.storage.dao.ListingDao;
import lorence.construction.data.storage.entity.Listing;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingModelImpl implements ListingModel {

    private AppDatabase mAppDatabase;
    private Application mApplication;
    private Context mContext;
    private ListingDao mListingDao;

    @Inject
    public ListingModelImpl(Application application, Context context, AppDatabase appDatabase, ListingDao listingDao) {
        mApplication = application;
        mAppDatabase = appDatabase;
        mContext = context;
        mListingDao = listingDao;
    }

    @Override
    public void addAll(List<Listing> list) {
//        mAppDatabase.getListingDao().addAll();
    }
}
