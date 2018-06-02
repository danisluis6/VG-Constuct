package lorence.construction.view.fragment.beams;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import lorence.construction.data.storage.async.BeamsAsynTask;
import lorence.construction.data.storage.dao.BeamsDao;
import lorence.construction.data.storage.entity.Beams;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class BeamsModelImpl implements BeamsModel {

    private Context mContext;
    private BeamsDao mBeamsDao;

    private BeamsPresenter mBeamsPresenter;
    private BeamsAsynTask mBeamsAsynTask;

    @Inject
    public BeamsModelImpl(Context context, BeamsDao beamsDao) {
        mContext = context;
        mBeamsDao = beamsDao;
    }

    @Override
    public void getBeamss() {
        mBeamsAsynTask.getBeams();
    }

    @Override
    public void insertBeams(List<Beams> list) {
        mBeamsAsynTask.insertBeams(list);
    }

    @Override
    public void attachBeamPresenter(BeamsPresenterImpl beamsPresenter) {
        mBeamsPresenter = beamsPresenter;
        mBeamsAsynTask.attachBeamsPresenter(mBeamsPresenter);
    }

    @Override
    public void attachBeamAsynTask(BeamsAsynTask beamsAsynTask) {
        mBeamsAsynTask = beamsAsynTask;
        mBeamsAsynTask.attachBeamsDao(mContext, mBeamsDao);
    }
}
