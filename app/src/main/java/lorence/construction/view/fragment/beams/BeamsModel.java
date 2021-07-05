package lorence.construction.view.fragment.beams;

import java.util.List;

import lorence.construction.data.storage.async.BeamsAsynTask;
import lorence.construction.data.storage.entity.Beams;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public interface BeamsModel {
    void getBeamss();

    void insertBeams(List<Beams> list);

    void attachBeamPresenter(BeamsPresenterImpl beamsPresenter);

    void attachBeamAsynTask(BeamsAsynTask beamsAsynTask);
}
