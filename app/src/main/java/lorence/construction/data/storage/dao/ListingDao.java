package lorence.construction.data.storage.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Maybe;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.data.DatabaseInfo;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */
@Dao
public interface ListingDao {

    @Insert
    long insertListing(Listing listing);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertListings(List<Listing> items);

    @Query("SELECT * FROM "+ DatabaseInfo.Tables.Listing)
    Maybe<List<Listing>> getListings();

    @Update
    int updateListings(Listing... items);
}
