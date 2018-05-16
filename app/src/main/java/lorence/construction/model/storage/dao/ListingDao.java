package lorence.construction.model.storage.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import lorence.construction.model.entity.Listing;
import lorence.construction.model.storage.DatabaseInfo;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */
@Dao
public interface ListingDao {

    @Query("SELECT * FROM "+ DatabaseInfo.Tables.Listing)
    List<Listing> getUsers();
    @Insert
    long insertUsers(Listing listing);
    @Update
    int updateUsers(Listing... listings);
}
