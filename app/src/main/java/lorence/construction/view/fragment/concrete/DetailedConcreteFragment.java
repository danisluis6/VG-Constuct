package lorence.construction.view.fragment.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.storage.entity.Concrete;
import lorence.construction.data.storage.entity.Operation;
import lorence.construction.data.storage.entity.Steel;
import lorence.construction.di.module.concrete.DetailConcreteModule;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.helper.Constants;
import lorence.construction.helper.RegularUtils;
import lorence.construction.helper.math.InternalFormula;
import lorence.construction.other.TemporaryStorage;
import lorence.construction.utitilize.Utils;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.beams.fragment.BeamsOperationFragment;
import lorence.construction.view.fragment.beams.fragment.SpinnerFragment;
import lorence.construction.view.fragment.concrete.omega.OmegaFragment;
import lorence.construction.view.fragment.listing.fragment.ConcreteFragment;
import lorence.construction.view.fragment.listing.fragment.SteelFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class DetailedConcreteFragment extends EBaseFragment implements DetailedConcreteView {

    @Inject
    Context mContext;

    @Inject
    HomeActivity mActivity;

    @Inject
    ConcreteFragment mConcreteFragment;

    @Inject
    SteelFragment mSteelFragment;

    @Inject
    RegularUtils mRegularUtils;

    @Inject
    SpinnerFragment mSpinnerFragment;

    @Inject
    OmegaFragment mOmegaFragment;

    @Inject
    InternalFormula mInternalFormula;

    @BindView(R.id.edtConcrete)
    EditText edtConcrete;

    @BindView(R.id.edtSteel)
    EditText edtSteel;

    @BindView(R.id.edtRb)
    EditText edtRb;

    @BindView(R.id.edtRs)
    EditText edtRs;

    @BindView(R.id.edty)
    EditText edty;

    @BindView(R.id.edtMx)
    EditText edtMx;

    @BindView(R.id.edtMy)
    EditText edtMy;

    @BindView(R.id.edtN)
    EditText edtN;

    @BindView(R.id.edtL)
    EditText edtL;

    @BindView(R.id.edtCx)
    EditText edtCx;

    @BindView(R.id.edtCy)
    EditText edtCy;

    @BindView(R.id.edta)
    EditText edta;

    @BindView(R.id.edtω)
    EditText edtω;

    @BindView(R.id.edtPhi1)
    EditText edtPhi1;

    public DetailedConcreteFragment() {
    }

    private void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new DetailConcreteModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_concrete, container, false);
        distributedDaggerComponents();
        bindView(view);

        mConcreteFragment.setParentFragment(mContext, this);
        mConcreteFragment.attachEventInterface(new ConcreteFragment.InterfaceConcreteFragment() {
            @Override
            public void onClickItem(Concrete concrete) {
                mConcreteFragment.dismiss();
                updateValueFieldConcrete(concrete);
            }
        });

        mSteelFragment.setParentFragment(mContext, this);
        mSteelFragment.attachEventInterface(new SteelFragment.InterfaceSteelFragment() {
            @Override
            public void onClickItem(Steel steel) {
                mSteelFragment.dismiss();
                updateValueFieldSteel(steel);
            }
        });
        mSpinnerFragment.setParentFragment(mContext, this);
        mSpinnerFragment.attachEventInterface(new SpinnerFragment.InterfaceSpinnerFragment() {
            @Override
            public void onClickItem(String value, BeamsOperationFragment.CASE _case) {

            }

            @Override
            public void onClickItem(String value) {
                mSpinnerFragment.dismiss();
                edtPhi1.setText(value);
            }
        });

        mOmegaFragment.setParentFragment(mContext, this);
        mOmegaFragment.attachEventInterface(new OmegaFragment.InterfaceSpinnerFragment() {
            @Override
            public void onClickItem(String value) {
                mOmegaFragment.dismiss();
                edtω.setText(value);
            }
        });
        return view;
    }

    @BindView(R.id.edtAsBT)
    EditText edtAsBT;

    @OnClick({R.id.edtConcrete, R.id.edtRb, R.id.edtSteel, R.id.edtRs, R.id.btnPerformCalculator, R.id.edtPhi1, R.id.edtω})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edtConcrete:
            case R.id.edtRb:
                showConcreteDialog();
                break;
            case R.id.edtSteel:
            case R.id.edtRs:
                showSteelDialog();
                break;
            case R.id.edtPhi1:
                mSpinnerFragment.show(mActivity.getFragmentManager(), Constants.TAG.SPINNER);
                break;
            case R.id.edtω:
                mOmegaFragment.show(mActivity.getFragmentManager(), Constants.TAG.SPINNER);
                break;
            case R.id.btnPerformCalculator:
                if (Utils.isInternetOn(mContext)) {
                    if (checkValidDataInput()) {
                        edtAsBT.setText(mInternalFormula.calculateAsBT(Double.parseDouble(edtL.getText().toString()), Double.parseDouble(edtω.getText().toString()),
                                Double.parseDouble(edtCx.getText().toString()), Double.parseDouble(edtCy.getText().toString())
                                , Double.parseDouble(edtMx.getText().toString()), Double.parseDouble(edtMy.getText().toString())
                        , Double.parseDouble(edtN.getText().toString()), Double.parseDouble(edtRb.getText().toString()),
                                Double.parseDouble(edty.getText().toString()), Double.parseDouble(edta.getText().toString()),
                                Double.parseDouble(edtRs.getText().toString())));
                    }
                } else {
                    Toast.makeText(mContext, getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }

    @Override
    public boolean checkValidDataInput() {
        if (!mRegularUtils.isRealNumber(edty.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho y", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtMx.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho Mx", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtMy.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho My", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtN.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho N", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtL.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho L", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtCx.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho Cx", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtCy.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho Cy", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edta.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho a", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void showConcreteDialog() {
        mConcreteFragment.show(mActivity.getFragmentManager(), Constants.TAG.CONCRETE);
    }

    @Override
    public void showSteelDialog() {
        mSteelFragment.show(mActivity.getFragmentManager(), Constants.TAG.STEEL);
    }

    @Override
    public void updateValueFieldConcrete(Concrete concrete) {
        edtConcrete.setText(concrete.getName());
        edtRb.setText(concrete.getValue());
    }

    @Override
    public void updateValueFieldSteel(Steel steel) {
        edtSteel.setText(steel.getName());
        edtRs.setText(steel.getValue());
    }
}
