package lorence.construction.view.fragment.beams.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lorence.construction.R;
import lorence.construction.view.EBaseFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class BeamsOperationFragment extends EBaseFragment implements BeamsOperationView {

    public BeamsOperationFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public Fragment newInstance(String tag) {
        BeamsOperationFragment fragment = new BeamsOperationFragment();
        Bundle b = new Bundle();
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beams_operation, container, false);
        bindView(view);
        return view;
    }
}
