package lorence.construction.view.fragment.beams.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.storage.entity.Beams;
import lorence.construction.data.storage.entity.Concrete;
import lorence.construction.data.storage.entity.Steel;
import lorence.construction.di.module.beams.BeamsModule;
import lorence.construction.di.module.beams.child.BeamOperationModule;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.helper.Constants;
import lorence.construction.helper.RegularUtils;
import lorence.construction.helper.math.InternalFormula;
import lorence.construction.other.TemporaryStorage;
import lorence.construction.utitilize.Utils;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.beams.BeamsFragment;
import lorence.construction.view.fragment.listing.fragment.ConcreteFragment;
import lorence.construction.view.fragment.listing.fragment.SteelFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class BeamsOperationFragment extends EBaseFragment implements BeamsOperationView {

    @Inject
    Context mContext;

    @Inject
    HomeActivity mHomeActivity;

    @Inject
    InternalFormula mInternalFormula;

    @Inject
    RegularUtils mRegularUtils;

    @Inject
    SpinnerFragment mSpinnerFragment;

    @Inject
    ConcreteFragment mConcreteFragment;

    @Inject
    SteelFragment mSteelFragment;

    @BindView(R.id.image)
    ImageView imageDescription;

    @BindView(R.id.type)
    TextView type;

    @BindView(R.id.m1)
    TextView m1;

    @BindView(R.id.m2)
    TextView m2;

    @BindView(R.id.edtL1)
    EditText edtL1;

    @BindView(R.id.edtM1)
    EditText edtM1;

    @BindView(R.id.edtM2)
    EditText edtM2;

    @BindView(R.id.edtStaticLoad)
    EditText edtStaticLoad;

    @BindView(R.id.edtDynamicLoad)
    EditText edtDynamicLoad;

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

    @BindView(R.id.edtAsMNAs1)
    EditText edtAsMNAs1;

    @BindView(R.id.edtAsMNAs2)
    EditText edtAsMNAs2;

    @BindView(R.id.edtAsMGAs3)
    EditText edtAsMGAs3;

    @BindView(R.id.edtAsMGAs4)
    EditText edtAsMGAs4;

    @BindView(R.id.edth)
    EditText edth;

    @BindView(R.id.edta)
    EditText edta;

    @BindView(R.id.edtRb)
    EditText edtRb;

    @BindView(R.id.edtRs)
    EditText edtRs;

    @BindView(R.id.edtSteel)
    EditText edtSteel;

    @BindView(R.id.edtConcrete)
    EditText edtConcrete;

    @BindView(R.id.lnExpand)
    LinearLayout lnExpand;

    @BindView(R.id.edtPhiAsMNAs1)
    EditText edtPhiAsMNAs1;

    @BindView(R.id.edtPhiAsMGAs3)
    EditText edtPhiAsMGAs3;

    @BindView(R.id.edtPhiAsMNAs2)
    EditText edtPhiAsMNAs2;

    @BindView(R.id.edtPhiAsMGAs4)
    EditText edtPhiAsMGAs4;

    private String mTitle;

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

    private void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new BeamsModule(Application.getInstance(), (HomeActivity) getActivity(), (BeamsFragment) getParentFragment()))
                .plus(new BeamOperationModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beams_operation, container, false);
        distributedDaggerComponents();
        mHomeActivity.hiddenBottomBar();
        mSpinnerFragment.setParentFragment(mContext, this);
        mSpinnerFragment.attachEventInterface(new SpinnerFragment.InterfaceSpinnerFragment() {
            @Override
            public void onClickItem(String value, CASE _case) {
                mSpinnerFragment.dismiss();
                if (CASE.ONE == _case) {
                    edtPhi1.setText(value);
                } else if (CASE.TWO == _case) {
                    edtPhi2.setText(value);
                } else if (CASE.THREE == _case) {
                    edtPhi3.setText(value);
                } else if (CASE.FOUR == _case) {
                    edtPhi4.setText(value);
                }
            }

            @Override
            public void onClickItem(String value) {

            }
        });
        mSteelFragment.setParentFragment(mContext, this);
        mSteelFragment.attachEventInterface(new SteelFragment.InterfaceSteelFragment() {
            @Override
            public void onClickItem(Steel steel) {
                mSteelFragment.dismiss();
                edtSteel.setText(steel.getName());
                edtRs.setText(steel.getValue());
            }
        });
        mConcreteFragment.setParentFragment(mContext, this);
        mConcreteFragment.attachEventInterface(new ConcreteFragment.InterfaceConcreteFragment() {
            @Override
            public void onClickItem(Concrete concrete) {
                mConcreteFragment.dismiss();
                edtConcrete.setText(concrete.getName());
                edtRb.setText(concrete.getValue());
            }
        });
        bindView(view);
        initViews();
        extractBundle();
        copyValueFromListings();
        edtA1.addTextChangedListener(new GenericTextWatcher(edtA1));
        edtA2.addTextChangedListener(new GenericTextWatcher(edtA2));
        edtA3.addTextChangedListener(new GenericTextWatcher(edtA3));
        edtA4.addTextChangedListener(new GenericTextWatcher(edtA4));
        edtPhi1.addTextChangedListener(new GenericTextWatcher(edtPhi1));
        edtPhi2.addTextChangedListener(new GenericTextWatcher(edtPhi2));
        edtPhi3.addTextChangedListener(new GenericTextWatcher(edtPhi3));
        edtPhi4.addTextChangedListener(new GenericTextWatcher(edtPhi4));
        edtM1.addTextChangedListener(new DectectViewTextWatcher());
        edtM2.addTextChangedListener(new DectectViewTextWatcher());
        return view;
    }

    private void initViews() {
        lnExpand.setVisibility(View.GONE);
    }

    private void copyValueFromListings() {
        if (TemporaryStorage.getInstance().get(Constants.HASH_MAP.RB) != null)
            edtRb.setText(TemporaryStorage.getInstance().get(Constants.HASH_MAP.RB));
        if (TemporaryStorage.getInstance().get(Constants.HASH_MAP.RS) != null)
            edtRb.setText(TemporaryStorage.getInstance().get(Constants.HASH_MAP.RS));
        if (TemporaryStorage.getInstance().get(Constants.HASH_MAP.H) != null)
            edth.setText(TemporaryStorage.getInstance().get(Constants.HASH_MAP.H));
        if (TemporaryStorage.getInstance().get(Constants.HASH_MAP.A) != null)
            edta.setText(TemporaryStorage.getInstance().get(Constants.HASH_MAP.A));
    }

    @Override
    public void onResume() {
        super.onResume();
        mHomeActivity.updateTitleToolbar(mTitle);
    }

    public boolean isValidDataInput() {
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
        return true;
    }

    private class DectectViewTextWatcher implements TextWatcher {

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            if (!TextUtils.equals(edtM1.getText(), Constants.EMPTY_STRING) && !TextUtils.equals(edtM2.getText(), Constants.EMPTY_STRING)) {
                lnExpand.setVisibility(View.VISIBLE);
            } else {
                lnExpand.setVisibility(View.GONE);
            }
        }
    }

    public class GenericTextWatcher implements TextWatcher {

        private View view;

        private GenericTextWatcher(View view) {
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

    private void extractBundle() {
        if (this.getArguments().get("beam") != null) {
            final Beams beam = this.getArguments().getParcelable("beam");
            mTitle = beam.getName();
            imageDescription.setImageResource(beam.getImage());
            type.setText(beam.getType());
            m1.setText(beam.getM1());
            m2.setText(beam.getM2());
            edtL1.setText(TemporaryStorage.getInstance().get(Constants.HASH_MAP.L1));
            edtStaticLoad.setText(TemporaryStorage.getInstance().get(Constants.HASH_MAP.STATIC_LOAD));
            edtDynamicLoad.setText(TemporaryStorage.getInstance().get(Constants.HASH_MAP.DYNAMIC_LOAD));
        }
    }

    @OnClick({R.id.btnPerformCalculator, R.id.edtPhi1, R.id.edtPhi2, R.id.edtPhi3, R.id.edtPhi4, R.id.mainContent, R.id.btnPerformCalculatorAs,
            R.id.edtConcrete, R.id.edtSteel, R.id.edtRs, R.id.edtRb})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPerformCalculator:
                if (checkValidDataInput()) {
                    final Beams beam = this.getArguments().getParcelable("beam");
                    edtM1.setText(mInternalFormula.calculateMN(beam.getName(), Double.parseDouble(edtL1.getText().toString()), Double.parseDouble(edtStaticLoad.getText().toString()), Double.parseDouble(edtDynamicLoad.getText().toString())));
                    edtM2.setText(mInternalFormula.calculateMG(beam.getName(), Double.parseDouble(edtL1.getText().toString()), Double.parseDouble(edtStaticLoad.getText().toString()), Double.parseDouble(edtDynamicLoad.getText().toString())));
                }
                break;
            case R.id.edtPhi1:
                mSpinnerFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.SPINNER);
                mSpinnerFragment.addCase(CASE.ONE);
                break;
            case R.id.edtPhi2:
                mSpinnerFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.SPINNER);
                mSpinnerFragment.addCase(CASE.TWO);
                break;
            case R.id.edtPhi3:
                mSpinnerFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.SPINNER);
                mSpinnerFragment.addCase(CASE.THREE);
                break;
            case R.id.edtPhi4:
                mSpinnerFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.SPINNER);
                mSpinnerFragment.addCase(CASE.FOUR);
                break;
            case R.id.edtConcrete:
            case R.id.edtRb:
                mConcreteFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.CONCRETE);
                break;
            case R.id.edtSteel:
            case R.id.edtRs:
                mSteelFragment.show(mHomeActivity.getFragmentManager(), Constants.TAG.STEEL);
                break;
            case R.id.mainContent:
                Utils.hiddenKeyBoard(mHomeActivity);
                break;
            case R.id.btnPerformCalculatorAs:
                if (isValidDataInput()) {
                    edtAsMNAs1.setText(mInternalFormula.calculateAs(Double.parseDouble(edtRb.getText().toString()),
                            Double.parseDouble(edtRs.getText().toString()),
                            Integer.parseInt("1"),
                            Double.parseDouble(edtM1.getText().toString()),
                            Double.parseDouble(edth.getText().toString()),
                            Double.parseDouble(edta.getText().toString())));

                    edtAsMGAs3.setText(mInternalFormula.calculateAs(Double.parseDouble(edtRb.getText().toString()),
                            Double.parseDouble(edtRs.getText().toString()),
                            Integer.parseInt("1"),
                            Double.parseDouble(edtM2.getText().toString()),
                            Double.parseDouble(edth.getText().toString()),
                            Double.parseDouble(edta.getText().toString())));
                    edtAsMNAs2.setText(mInternalFormula.calculateAsMNAs2(Double.parseDouble(edtAsMNAs1.getText().toString())));
                    edtAsMGAs4.setText(mInternalFormula.calculateAsMNAs2(Double.parseDouble(edtAsMNAs1.getText().toString())));

                    edtPhiAsMNAs1.setText(mInternalFormula.calculateAsMX(Double.parseDouble(edtAsMNAs1.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString())));
                    edtPhiAsMGAs3.setText(mInternalFormula.calculateAsMX(Double.parseDouble(edtAsMGAs3.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString())));
                    edtPhiAsMNAs2.setText(mInternalFormula.calculateAsMX(Double.parseDouble(edtAsMNAs2.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString())));
                    edtPhiAsMGAs4.setText(mInternalFormula.calculateAsMX(Double.parseDouble(edtAsMGAs4.getText().toString()), Double.parseDouble(edth.getText().toString()), Double.parseDouble(edta.getText().toString())));
                }
                break;
        }
    }

    public enum CASE {
        ONE, TWO, THREE, FOUR
    }

    @Override
    public boolean checkValidDataInput() {
        if (!mRegularUtils.isRealNumber(edtL1.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho L1", Toast.LENGTH_SHORT).show();
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
    public void onDestroyView() {
        mHomeActivity.updateTitleToolbar(getString(R.string.title_beams));
        mHomeActivity.showBottomBar();
        super.onDestroyView();
    }
}
