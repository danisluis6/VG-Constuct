package lorence.vgconstruct.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import lorence.vgconstruct.view.activity.BaseActivity;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public abstract class EBaseFragment extends Fragment{

    protected BaseActivity mActivity;
    private Unbinder mUnbinder;
    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        initAtributes(inflater,container,savedInstanceState);
        fragmentCreated();
        return mView;
    }

    protected void initAtributes(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mActivity = (BaseActivity)this.getActivity();
        mView = getViewLayout(inflater, container, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, mView);
    }

    public abstract View getViewLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    public View getView() {
        return mView;
    }

    public abstract void fragmentCreated();

    @Override
    public void onDestroyView() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroyView();
    }
}
