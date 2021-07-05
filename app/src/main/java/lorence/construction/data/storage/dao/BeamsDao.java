package lorence.construction.data.storage.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Maybe;
import lorence.construction.data.DatabaseInfo;
import lorence.construction.data.storage.entity.Beams;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */
@Dao
public interface BeamsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBeams(List<Beams> items);

    @Query("SELECT * FROM "+ DatabaseInfo.Tables.Beams)
    Maybe<List<Beams>> getBeams();
}
