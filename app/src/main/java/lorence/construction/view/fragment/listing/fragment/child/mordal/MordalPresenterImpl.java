package lorence.construction.view.fragment.listing.fragment.child.mordal;

import android.content.Context;

import lorence.construction.view.activity.home.HomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class MordalPresenterImpl implements MordalPresenter {

    private Context mContext;
    private HomeActivity mActivity;
    private MordalView mMordalView;
    private MordalModel mMordalModel;

    public MordalPresenterImpl(Context context, HomeActivity activity, MordalView mordalView, MordalModel mordalModel) {
        mContext = context;
        mActivity = activity;
        mMordalView = mordalView;
        mMordalModel = mordalModel;
    }

}
