package lorence.construction.view.fragment.listing.fragment.child.calculate;

import android.annotation.SuppressLint;
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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

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
import lorence.construction.other.TemporaryStorage;
import lorence.construction.utitilize.Utils;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.beams.fragment.BeamsOperationFragment;
import lorence.construction.view.fragment.beams.fragment.SpinnerFragment;
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

    @BindView(R.id.edtAsM1)
    EditText edtAsM1;

    @BindView(R.id.edtAsM2)
    EditText edtAsM2;

    @BindView(R.id.edtAsMM1)
    EditText edtAsMM1;

    @BindView(R.id.edtAsMM2)
    EditText edtAsMM2;

    @BindView(R.id.edtPhi1)
    EditText edtPhi1;

    @BindView(R.id.edtPhi2)
    EditText edtPhi2;

    @BindView(R.id.edtPhi3)
    EditText edtPhi3;

    @BindView(R.id.edtPhi4)
    EditText edtPhi4;

    @BindView(R.id.edtA1)
    EditText edtA1;

    @BindView(R.id.edtA2)
    EditText edtA2;

    @BindView(R.id.edtA3)
    EditText edtA3;

    @BindView(R.id.edtA4)
    EditText edtA4;

    @BindView(R.id.edtAs1)
    EditText edtAs1;

    @BindView(R.id.edtAs2)
    EditText edtAs2;

    @BindView(R.id.edtAs3)
    EditText edtAs3;

    @BindView(R.id.edtAs4)
    EditText edtAs4;

    @BindView(R.id.edtPhiAsM1)
    EditText edtPhiAsM1;

    @BindView(R.id.edtPhiAsM2)
    EditText edtPhiAsM2;

    @BindView(R.id.edtPhiAsMM1)
    EditText edtPhiAsMM1;

    @BindView(R.id.edtPhiAsMM2)
    EditText edtPhiAsMM2;

    @BindView(R.id.adView)
    AdView adView;

    @BindView(R.id.adView1)
    AdView adView1;

    @BindView(R.id.adView2)
    AdView adView2;

    @BindView(R.id.adView3)
    AdView adView3;

    @BindView(R.id.adView4)
    AdView adView4;

    @BindView(R.id.adView5)
    AdView adView5;

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
    SpinnerFragment mSpinnerFragment;

    @Inject
    InternalFormula mInternalFormula;

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
        mSpinnerFragment.setParentFragment(mContext,mCalculateFragment);
        mSpinnerFragment.attachEventInterface(new SpinnerFragment.InterfaceSpinnerFragment() {
            @Override
            public void onClickItem(String value, BeamsOperationFragment.CASE _case) {
                mSpinnerFragment.dismiss();
                if (BeamsOperationFragment.CASE.ONE == _case) {
                    edtPhi1.setText(value);
                } else if (BeamsOperationFragment.CASE.TWO == _case) {
                    edtPhi2.setText(value);
                } else if (BeamsOperationFragment.CASE.THREE == _case) {
                    edtPhi3.setText(value);
                } else if (BeamsOperationFragment.CASE.FOUR == _case) {
                    edtPhi4.setText(value);
                }
            }

            @Override
            public void onClickItem(String value) {

            }
        });

        edtA1.addTextChangedListener(new AsTextWatcher(edtA1));
        edtA2.addTextChangedListener(new AsTextWatcher(edtA2));
        edtA3.addTextChangedListener(new AsTextWatcher(edtA3));
        edtA4.addTextChangedListener(new AsTextWatcher(edtA4));
        edtPhi1.addTextChangedListener(new AsTextWatcher(edtPhi1));
        edtPhi2.addTextChangedListener(new AsTextWatcher(edtPhi2));
        edtPhi3.addTextChangedListener(new AsTextWatcher(edtPhi3));
        edtPhi4.addTextChangedListener(new AsTextWatcher(edtPhi4));

        mCalculatePresenter.getListingOperations();
        edtL1.addTextChangedListener(new GenericTextWatcher(edtL1));
        edtStaticLoad.addTextChangedListener(new GenericTextWatcher(edtStaticLoad));
        edtDynamicLoad.addTextChangedListener(new GenericTextWatcher(edtDynamicLoad));
        mHomeActivity.attachShareButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.isInternetOn(mContext)) {
                    if (TextUtils.equals(edtAsM1.getText().toString(), Constants.EMPTY_STRING)) {
                        Toast.makeText(mContext, "Bạn chưa thực hiện tính toán", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT, "THÔNG SỐ BAN ĐẦU:" +
                                "\nl1 = " + edtL1.getText() +
                                "\nl2 = " + edtL2.getText() +
                                "\nhs = " + edth.getText() +
                                "\na = " + edta.getText() +
                                "\nRb = " + edtRb.getText() +
                                "\nRs = " + edtRs.getText() +
                                "\ng = " + edtStaticLoad.getText() +
                                "\np = " + edtDynamicLoad.getText() +
                                "\nTHỰC THI PHÉP TÍNH:" +
                                "\nk1 = " + tvk1.getText() +
                                "\nk2 = " + tvk2.getText() +
                                "\nm1 = " + tvm1.getText() +
                                "\nm2 = " + tvm2.getText() +
                                "\nq = " + tvq.getText() +
                                "\nP = " + tvP.getText() +
                                "\nM1 = " + tvM1.getText() +
                                "\nM2 = " + tvM2.getText() +
                                "\nMI = " + tvMM1.getText() +
                                "\nMII = " + tvMM2.getText() +
                                "\nAs(M1) = " + edtAsM1.getText() +
                                "\nAs(M2) = " + edtAsM2.getText() +
                                "\nAs(MI) = " + edtAsMM1.getText() +
                                "\nAs(MII) = " + edtAsMM2.getText());
                        startActivity(Intent.createChooser(intent, "Chia sẻ với bạn bè"));
                    }
                } else {
                    Toast.makeText(mContext, getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
                }
            }
        });

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        adView.loadAd(adRequest);
        adView1.loadAd(adRequest);
        adView2.loadAd(adRequest);
        adView3.loadAd(adRequest);
        adView4.loadAd(adRequest);
        adView5.loadAd(adRequest);
        return view;
    }

    private class GenericTextWatcher implements TextWatcher{

        private View view;
        private GenericTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        public void afterTextChanged(Editable editable) {
            String text = editable.toString();
            switch(view.getId()){
                case R.id.edtL1:
                    TemporaryStorage.getInstance().put(Constants.HASH_MAP.L1, text);
                    break;
                case R.id.edtStaticLoad:
                    TemporaryStorage.getInstance().put(Constants.HASH_MAP.STATIC_LOAD, text);
                    break;
                case R.id.edtDynamicLoad:
                    TemporaryStorage.getInstance().put(Constants.HASH_MAP.DYNAMIC_LOAD, text);
                    break;
            }
        }
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
        mConcreteFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.CONCRETE);
    }

    @Override
    public void showSteelDialog() {
        mSteelFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.STEEL);
    }

    @OnClick({R.id.btnPerformCalculator, R.id.edtConcrete, R.id.edtRb, R.id.edtSteel, R.id.edtRs, R.id.edtPhi1, R.id.edtPhi2, R.id.edtPhi3, R.id.edtPhi4, R.id.mainContent})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPerformCalculator:
                if (Utils.isInternetOn(mContext)) {
                    if (checkValidDataInput()) {
                        if (mConditionCalculating.islistingOrBeams(mConverterUtils.getDoubleValue(edtL1), mConverterUtils.getDoubleValue(edtL2), mHomeActivity.getTitleToolbar())) {
                            Operation operation = mInternalFormula.calculate(mGrListingOperations, mHomeActivity.getTitleToolbar(), mConverterUtils.getDoubleValue(edtL2) / mConverterUtils.getDoubleValue(edtL1));
                            showStepByStepOfCalculating(operation);
                            Utils.hiddenKeyBoard(mHomeActivity);
                        } else {
                            Toast.makeText(mContext, "Vui lòng chuyển qua mục bản dầm", Toast.LENGTH_SHORT).show();
                            TemporaryStorage.getInstance().put(Constants.HASH_MAP.RB, edtRb.getText().toString());
                            TemporaryStorage.getInstance().put(Constants.HASH_MAP.RS, edtRs.getText().toString());
                            TemporaryStorage.getInstance().put(Constants.HASH_MAP.VALUE_B, "1");
                            TemporaryStorage.getInstance().put(Constants.HASH_MAP.H, edth.getText().toString());
                            TemporaryStorage.getInstance().put(Constants.HASH_MAP.A, edta.getText().toString());
                        }
                    }
                } else {
                    Toast.makeText(mContext, getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
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
            case R.id.edtPhi1:
                mSpinnerFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.SPINNER);
                mSpinnerFragment.addCase(BeamsOperationFragment.CASE.ONE);
                break;
            case R.id.edtPhi2:
                mSpinnerFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.SPINNER);
                mSpinnerFragment.addCase(BeamsOperationFragment.CASE.TWO);
                break;
            case R.id.edtPhi3:
                mSpinnerFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.SPINNER);
                mSpinnerFragment.addCase(BeamsOperationFragment.CASE.THREE);
                break;
            case R.id.mainContent:
                Utils.hiddenKeyBoard(mHomeActivity);
                break;
            case R.id.edtPhi4:
                mSpinnerFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.SPINNER);
                mSpinnerFragment.addCase(BeamsOperationFragment.CASE.FOUR);
                break;

        }
    }

    public class AsTextWatcher implements TextWatcher {

        private View view;

        private AsTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            String text = editable.toString();
            switch (view.getId()) {
                case R.id.edtPhi1:
                case R.id.edtA1:
                    if (!mRegularUtils.isRealNumber(edtA1.getText().toString())) {
                        Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho a", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!TextUtils.equals(text, Constants.EMPTY_STRING) && !TextUtils.equals(edtPhi1.getText().toString(), Constants.EMPTY_STRING)) {
                            edtAs1.setText(mInternalFormula.calculateAs1(Double.parseDouble(edtPhi1.getText().toString()), Double.parseDouble(edtA1.getText().toString())));
                        }
                    }
                    break;
                case R.id.edtPhi2:
                case R.id.edtA2:
                    if (!mRegularUtils.isRealNumber(edtA2.getText().toString())) {
                        Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho a", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!TextUtils.equals(text, Constants.EMPTY_STRING) && !TextUtils.equals(edtPhi2.getText().toString(), Constants.EMPTY_STRING)) {
                            edtAs2.setText(mInternalFormula.calculateAs1(Double.parseDouble(edtPhi2.getText().toString()), Double.parseDouble(edtA2.getText().toString())));
                        }
                    }
                    break;
                case R.id.edtPhi3:
                case R.id.edtA3:
                    if (!mRegularUtils.isRealNumber(edtA3.getText().toString())) {
                        Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho a", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!TextUtils.equals(text, Constants.EMPTY_STRING) && !TextUtils.equals(edtPhi3.getText().toString(), Constants.EMPTY_STRING)) {
                            edtAs3.setText(mInternalFormula.calculateAs1(Double.parseDouble(edtPhi3.getText().toString()), Double.parseDouble(edtA3.getText().toString())));
                        }
                    }
                    break;
                case R.id.edtPhi4:
                case R.id.edtA4:
                    if (!mRegularUtils.isRealNumber(edtA4.getText().toString())) {
                        Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho a", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!TextUtils.equals(text, Constants.EMPTY_STRING) && !TextUtils.equals(edtPhi4.getText().toString(), Constants.EMPTY_STRING)) {
                            edtAs4.setText(mInternalFormula.calculateAs1(Double.parseDouble(edtPhi4.getText().toString()), Double.parseDouble(edtA4.getText().toString())));
                        }
                    }
                    break;
            }
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
        String AsM1 = mInternalFormula.calculateAs(Double.parseDouble(edtRb.getText().toString()), Double.parseDouble(edtRs.getText().toString()), 1, Double.parseDouble(tvM1.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString()));
        String AsM2 = mInternalFormula.calculateAs(Double.parseDouble(edtRb.getText().toString()), Double.parseDouble(edtRs.getText().toString()), 1, Double.parseDouble(tvM2.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString()));
        String AsMM1 = mInternalFormula.calculateAs(Double.parseDouble(edtRb.getText().toString()), Double.parseDouble(edtRs.getText().toString()), 1, Double.parseDouble(tvMM1.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString()));
        String AsMM2 = mInternalFormula.calculateAs(Double.parseDouble(edtRb.getText().toString()), Double.parseDouble(edtRs.getText().toString()), 1, Double.parseDouble(tvMM2.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString()));
        edtAsM1.setText(AsM1);
        edtAsM2.setText(AsM2);
        edtAsMM1.setText(AsMM1);
        edtAsMM2.setText(AsMM2);
        edtPhiAsM1.setText(mInternalFormula.calculateAsMX(Double.parseDouble(edtAsM1.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString())));
        edtPhiAsM2.setText(mInternalFormula.calculateAsMX(Double.parseDouble(edtAsM2.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString())));
        edtPhiAsMM1.setText(mInternalFormula.calculateAsMX(Double.parseDouble(edtAsMM1.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString())));
        edtPhiAsMM2.setText(mInternalFormula.calculateAsMX(Double.parseDouble(edtAsMM2.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString())));
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
        if (!mRegularUtils.isRealNumber(edtRb.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng chọn cấp độ bê tông", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtRs.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng chọn loại thép", Toast.LENGTH_SHORT).show();
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

