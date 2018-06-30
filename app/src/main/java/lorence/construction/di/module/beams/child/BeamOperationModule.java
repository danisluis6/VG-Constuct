package lorence.construction.di.module.beams.child;

import android.content.Context;

import dagger.Module;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.beams.fragment.BeamsOperationFragment;
import lorence.construction.view.fragment.beams.fragment.BeamsOperationView;

/**
 * Created by lorence on 28/12/2017.
 *
 * @version master
 * @since 12/28/2017
 */

@Module
public class BeamOperationModule {

    private Context mContext;
    private HomeActivity mActivity;
    private BeamsOperationFragment mFragment;
    private BeamsOperationView mBeamOperationView;

    public BeamOperationModule(Context context, HomeActivity homeActivity, BeamsOperationFragment fragment, BeamsOperationView beamOperationView) {
        mContext = context;
        mActivity = homeActivity;
        mFragment = fragment;
        mBeamOperationView = beamOperationView;
    }
}
