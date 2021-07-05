package lorence.construction.data.storage.async;

import android.content.Context;

import java.util.List;

import lorence.construction.data.storage.dao.BeamsDao;
import lorence.construction.data.storage.entity.Beams;
import lorence.construction.view.fragment.beams.BeamsPresenter;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public interface BeamsAsynTask {

    void attachBeamsDao(Context mContext, BeamsDao beamsDao);

    void attachBeamsPresenter(BeamsPresenter beamsPresenter);

    void insertBeams(List<Beams> items);

    void getBeams();
}
