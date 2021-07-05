package lorence.construction.view.fragment.beams;

import android.content.Context;

import java.util.List;

import lorence.construction.data.storage.async.BeamsAsynTask;
import lorence.construction.data.storage.entity.Beams;
import lorence.construction.view.activity.home.HomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class BeamsPresenterImpl implements BeamsPresenter {

    private Context mContext;
    private HomeActivity mActivity;
    private BeamsView mBeamsView;
    private BeamsModel mBeamsModel;

    public BeamsPresenterImpl(Context context, HomeActivity activity, BeamsView beamsView, BeamsModel beamsModel, BeamsAsynTask beamsAsynTask) {
        mContext = context;
        mActivity = activity;
        mBeamsView = beamsView;
        mBeamsModel = beamsModel;
        mBeamsModel.attachBeamAsynTask(beamsAsynTask);
        mBeamsModel.attachBeamPresenter(this);
    }

    @Override
    public void getBeamss() {
        mBeamsModel.getBeamss();
    }

    @Override
    public void onInsertBeamsSuccess() {

    }

    @Override
    public void onInsertBeamsFailed() {

    }

    @Override
    public void onGetBeamsSuccess(List<Beams> beams) {
        mBeamsView.onGetBeamsSuccess(beams);
    }

    @Override
    public void saveBeams(List<Beams> beams) {
        mBeamsModel.insertBeams(beams);
    }
}
