package lorence.construction.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import lorence.construction.data.storage.dao.BeamsDao;
import lorence.construction.data.storage.dao.ListingDao;
import lorence.construction.data.storage.dao.ListingOperationDao;
import lorence.construction.data.storage.entity.Beams;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.data.storage.entity.ListingOperation;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Database(entities = {Listing.class, ListingOperation.class, Beams.class}, version = DatabaseInfo.DB_VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME = DatabaseInfo.DB_NAME;

    public abstract ListingDao getListingDao();

    public abstract BeamsDao getBeamsDao();

    public abstract ListingOperationDao getListingOperationDao();
}



