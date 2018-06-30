package lorence.construction.view.fragment.listing.fragment.child.reference;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.listing.child.ReferenceFragmentModule;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class ReferenceFragment extends EBaseFragment implements ReferenceView {

    @Inject
    Context mContext;

    @Inject
    HomeActivity mHomeActivity;

    @Inject
    ReferenceFragment mReferenceFragment;

    public ReferenceFragment() {
    }

    private void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new ReferenceFragmentModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reference, container, false);
        distributedDaggerComponents();
        bindView(view);
        return view;
    }

    public Fragment newInstance(ReferenceFragment fragment, int position) {
        Bundle b = new Bundle();
        fragment.setArguments(b);
        return fragment;
    }
}
