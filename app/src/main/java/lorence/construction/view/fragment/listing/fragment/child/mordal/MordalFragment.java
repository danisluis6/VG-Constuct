package lorence.construction.view.fragment.listing.fragment.child.mordal;

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
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class MordalFragment extends EBaseFragment {

    public MordalFragment() {
    }

    public Fragment newInstance(MordalFragment fragment, int position) {
        Bundle b = new Bundle();
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mordal, container, false);
        bindView(view);

        return view;
    }
}
