package lorence.construction.view.fragment.beams;

import java.util.List;

import lorence.construction.data.storage.entity.Beams;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface BeamsPresenter {
    void getBeamss();

    void onInsertBeamsSuccess();

    void onInsertBeamsFailed();

    void onGetBeamsSuccess(List<Beams> beams);

    void saveBeams(List<Beams> defaultBeamsData);
}
