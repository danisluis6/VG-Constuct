package lorence.construction.view.fragment.listing.fragment.child.calculate;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.storage.entity.Concrete;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.data.storage.entity.Operation;
import lorence.construction.data.storage.entity.Steel;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.listing.child.CalculateFragmentModule;
import lorence.construction.helper.ConditionCalculating;
import lorence.construction.helper.Constants;
import lorence.construction.helper.ConverterUtils;
import lorence.construction.helper.RegularUtils;
import lorence.construction.helper.math.InternalFormula;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.fragment.ConcreteFragment;
import lorence.construction.view.fragment.listing.fragment.ListingOperationFragment;
import lorence.construction.view.fragment.listing.fragment.SteelFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class CalculateFragment extends EBaseFragment implements CalculateView {

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

    @BindView(R.id.btnPerformCalculator)
    Button btnPerformCalculator;

    @Inject
    Context mContext;

    @Inject
    HomeActivity mHomeActivity;

    @Inject
    RegularUtils mRegularUtils;

    @Inject
    ConditionCalculating mConditionCalculating;

    @Inject
    ConverterUtils mConverterUtils;

    @Inject
    ConcreteFragment mConcreteFragment;

    @Inject
    SteelFragment mSteelFragment;

    @Inject
    InternalFormula mInternalFormula;

    @Inject
    FragmentManager mFragmentManager;

    @Inject
    ListingOperationFragment mListingOperationFragment;

    @Inject
    CalculatePresenter mCalculatePresenter;

    @Inject
    CalculateFragment mCalculateFragment;

    private List<ListingOperation> mGrListingOperations;

    public CalculateFragment() {
    }

    public Fragment newInstance(CalculateFragment fragment, int position) {
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
                .plus(new CalculateFragmentModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        bindView(view);
        mGrListingOperations = new ArrayList<>();
        mConcreteFragment.setParentFragment(mContext, mCalculateFragment);
        mConcreteFragment.attachEventInterface(new ConcreteFragment.InterfaceConcreteFragment() {
            @Override
            public void onClickItem(Concrete concrete) {
                mConcreteFragment.dismiss();
                updateValueFieldConcrete(concrete);
            }
        });

        mSteelFragment.setParentFragment(mContext, mCalculateFragment);
        mSteelFragment.attachEventInterface(new SteelFragment.InterfaceSteelFragment() {
            @Override
            public void onClickItem(Steel steel) {
                mSteelFragment.dismiss();
                updateValueFieldSteel(steel);
            }
        });
        mCalculatePresenter.getListingOperations();
        return view;
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

    @Override
    public void showConcreteDialog() {
        mConcreteFragment.show(mFragmentManager, Constants.TAG.CONCRETE);
    }

    @Override
    public void showSteelDialog() {
        mSteelFragment.show(mFragmentManager, Constants.TAG.STEEL);
    }

    @OnClick({R.id.btnPerformCalculator, R.id.edtConcrete, R.id.edtRb, R.id.edtSteel, R.id.edtRs})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPerformCalculator:
                if (checkValidDataInput()) {
                    if (mConditionCalculating.islistingOrBeams(mConverterUtils.getDoubleValue(edtL1), mConverterUtils.getDoubleValue(edtL2))) {
                        Operation operation = mInternalFormula.calculate(mGrListingOperations, mHomeActivity.getTitleToolbar(), mConverterUtils.getDoubleValue(edtL2) / mConverterUtils.getDoubleValue(edtL1));
                    }
                }
                break;
            case R.id.edtConcrete:
            case R.id.edtRb:
                showConcreteDialog();
                break;
            case R.id.edtSteel:
            case R.id.edtRs:
                showSteelDialog();
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

    @Override
    public void onGetListingOperationsSuccess(List<ListingOperation> listingOperations) {
        mGrListingOperations = listingOperations;
    }
}
