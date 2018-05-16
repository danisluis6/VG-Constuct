package lorence.construction.model.storage;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import lorence.construction.model.entity.Listing;
import lorence.construction.model.storage.dao.ListingDao;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Database(entities = {Listing.class}, version = DatabaseInfo.DB_VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME = DatabaseInfo.DB_NAME;

    public abstract ListingDao listingDao();

}



