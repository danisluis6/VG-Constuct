package lorence.construction.view.fragment.listing.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.listing.ListingModule;
import lorence.construction.di.module.listing.child.ListingOperationModule;
import lorence.construction.helper.RegularUtils;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.ListingFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class ListingOperationFragment extends EBaseFragment implements ListingOperationView {

    @BindView(R.id.edtL1)
    EditText edtL1;

    @BindView(R.id.edtL2)
    EditText edtL2;

    @BindView(R.id.edth)
    EditText edth;

    @BindView(R.id.edta)
    EditText edta;

    @BindView(R.id.edtConcrete)
    EditText edtConcrete;

    @BindView(R.id.edtSteel)
    EditText edtSteel;

    @BindView(R.id.edtRb)
    EditText edtRb;

    @BindView(R.id.edtRs)
    EditText edtRs;

    @BindView(R.id.edtStaticLoad)
    EditText edtStaticLoad;

    @BindView(R.id.edtDynamicLoad)
    EditText edtDynamicLoad;

    @BindView(R.id.edtBrick)
    EditText edtBrick;

    @BindView(R.id.edtMortar)
    EditText edtMortar;

    @BindView(R.id.edtConcreteFloor)
    EditText edtConcreteFloor;

    @BindView(R.id.edtPlasterMortar)
    EditText edtPlasterMortar;

    @BindView(R.id.edtReferStaticLoad)
    EditText edtReferStaticLoad;

    @BindView(R.id.edtReferDynamicLoad)
    EditText edtReferDynamicLoad;

    @BindView(R.id.btnPerformCalculator)
    Button btnPerformCalculator;

    @Inject
    Context mContext;

    @Inject
    HomeActivity mHomeActivity;

    @Inject
    RegularUtils mRegularUtils;

    public ListingOperationFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new ListingModule(Application.getInstance(), (HomeActivity) getActivity(), (ListingFragment) getParentFragment()))
                .plus(new ListingOperationModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing_operation, container, false);
        bindView(view);
        mHomeActivity.hiddenBottomBar();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.btnPerformCalculator})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPerformCalculator:
                if (checkValidDataInput()) {
                    Toast.makeText(mContext, "Calculating successfully!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public boolean checkValidDataInput() {
        if (!mRegularUtils.isRealNumber(edtL1.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho L1", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtL2.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho L2", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edth.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho hs", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edta.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho a", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}

/*
 * onCreateView not find ResourceId android
 * => Put layout in wrong folder.
 */
