package lorence.construction.view.fragment.listing.fragment.child.calculate;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.SessionManager;
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

    @BindView(R.id.tvk1)
    TextView tvk1;

    @BindView(R.id.tvk2)
    TextView tvk2;

    @BindView(R.id.tvm1)
    TextView tvm1;

    @BindView(R.id.tvm2)
    TextView tvm2;

    @BindView(R.id.tvM1)
    TextView tvM1;

    @BindView(R.id.tvM2)
    TextView tvM2;

    @BindView(R.id.tvMM1)
    TextView tvMM1;

    @BindView(R.id.tvMM2)
    TextView tvMM2;

    @BindView(R.id.tvq)
    TextView tvq;

    @BindView(R.id.tvP)
    TextView tvP;

    @BindView(R.id.edtAs)
    EditText edtAs;

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

    @Inject
    SessionManager mSessionManager;

    private List<ListingOperation> mGrListingOperations;

    public CalculateFragment() {
    }

    public Fragment newInstance(CalculateFragment fragment, int position) {
        Bundle b = new Bundle();
        fragment.setArguments(b);
        return fragment;
    }

    private void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new CalculateFragmentModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        distributedDaggerComponents();
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
        edtL1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mSessionManager.setL1(edtL1.getText().toString());
            }
        });
        mHomeActivity.attachShareButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.equals(edtAs.getText().toString(), Constants.EMPTY_STRING)) {
                    Toast.makeText(mContext, "Bạn chưa thực hiện tính toán", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, "THÔNG SỐ BAN ĐẦU:" +
                            "\nl1 = "+ edtL1.getText() +
                            "\nl2 = "+ edtL2.getText() +
                            "\nhs = "+ edth.getText() +
                            "\na = "+ edta.getText() +
                            "\nRb = "+ edtRb.getText() +
                            "\nRs = "+ edtRs.getText() +
                            "\ng = "+ edtStaticLoad.getText() +
                            "\np = "+ edtDynamicLoad.getText() +
                            "\nTHỰC THI PHÉP TÍNH:" +
                            "\nk1 = "+ tvk1.getText() +
                            "\nk2 = " + tvk2.getText() +
                            "\nm1 = " + tvm1.getText() +
                            "\nm2 = " + tvm2.getText() +
                            "\nq = " + tvq.getText() +
                            "\nP = " + tvP.getText() +
                            "\nM1 = " + tvM1.getText() +
                            "\nM2 = " + tvM2.getText() +
                            "\nMI = " + tvMM1.getText() +
                            "\nMII = " + tvMM2.getText() +
                            "\nAs = "+ edtAs.getText());
                    startActivity(Intent.createChooser(intent, "Chia sẻ với bạn bè"));
                }
            }
        });
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
                    if (mConditionCalculating.islistingOrBeams(mConverterUtils.getDoubleValue(edtL1), mConverterUtils.getDoubleValue(edtL2), mHomeActivity.getTitleToolbar())) {
                        Operation operation = mInternalFormula.calculate(mGrListingOperations, mHomeActivity.getTitleToolbar(), mConverterUtils.getDoubleValue(edtL2) / mConverterUtils.getDoubleValue(edtL1));
                        showStepByStepOfCalculating(operation);
                    } else {
                        Toast.makeText(mContext, "Vui lòng chuyển qua mục bản dầm", Toast.LENGTH_SHORT).show();
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

    private void showStepByStepOfCalculating(Operation operation) {
        tvk1.setText(operation.getK1());
        tvk2.setText(operation.getK2());
        tvm1.setText(operation.getM1());
        tvm2.setText(operation.getM2());
        tvq.setText(mInternalFormula.calculateq(Double.parseDouble(edtStaticLoad.getText().toString()), Double.parseDouble(edtDynamicLoad.getText().toString())));
        tvP.setText(mInternalFormula.calculateP(Double.parseDouble(edtStaticLoad.getText().toString()), Double.parseDouble(edtDynamicLoad.getText().toString()), Double.parseDouble(edtL1.getText().toString()), Double.parseDouble(edtL2.getText().toString())));
        tvM1.setText(mInternalFormula.calculateM1(Double.parseDouble(tvm1.getText().toString()), Double.parseDouble(tvP.getText().toString())));
        tvM2.setText(mInternalFormula.calculateM2(Double.parseDouble(tvm2.getText().toString()), Double.parseDouble(tvP.getText().toString())));
        tvMM1.setText(mInternalFormula.calculateK1(Double.parseDouble(tvk1.getText().toString()), Double.parseDouble(tvP.getText().toString())));
        tvMM2.setText(mInternalFormula.calculateK2(Double.parseDouble(tvk2.getText().toString()), Double.parseDouble(tvP.getText().toString())));
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
        if (!mRegularUtils.isRealNumber(edtStaticLoad.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho g", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtDynamicLoad.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho p", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onGetListingOperationsSuccess(List<ListingOperation> listingOperations) {
        mGrListingOperations = listingOperations;
    }
}
