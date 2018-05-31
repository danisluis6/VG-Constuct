package lorence.construction.di.module.listing.child;

import android.content.Context;

import dagger.Module;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.fragment.child.reference.ReferenceFragment;
import lorence.construction.view.fragment.listing.fragment.child.reference.ReferenceView;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class ReferenceFragmentModule {

    private Context mContext;
    private HomeActivity mActivity;
    private ReferenceFragment mFragment;
    private ReferenceView mReferenceView;

    public ReferenceFragmentModule(Context context, HomeActivity homeActivity, ReferenceFragment fragment, ReferenceView referenceView) {
        mContext = context;
        mActivity = homeActivity;
        mFragment = fragment;
        mReferenceView = referenceView;
    }

}