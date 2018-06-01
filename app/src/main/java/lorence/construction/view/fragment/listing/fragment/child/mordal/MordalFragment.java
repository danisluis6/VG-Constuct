package lorence.construction.view.fragment.listing.fragment.child.mordal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.listing.child.MordalFragmentModule;
import lorence.construction.helper.Constants;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.fragment.ListingOperationFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class MordalFragment extends EBaseFragment implements MordalView {

    @BindView(R.id.edtD)
    EditText edtD;

    @Inject
    ListingOperationFragment mListingOperationFragment;

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
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new MordalFragmentModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mordal, container, false);
        bindView(view);
        return view;
    }

    public void updateValueL1() {
        Bundle bundle = mListingOperationFragment.getArguments();
        if (bundle != null) {
            String L1 = bundle.getString(Constants.ARGUMENT_FRAGMENT.L1, Constants.EMPTY_STRING);
            edtD.setText(L1);
        }
    }
}
