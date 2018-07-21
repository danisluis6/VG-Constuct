package lorence.construction.view.fragment.listing.fragment.child.mordal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
import lorence.construction.data.SessionManager;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.listing.child.MordalFragmentModule;
import lorence.construction.helper.Constants;
import lorence.construction.helper.ConverterUtils;
import lorence.construction.helper.RegularUtils;
import lorence.construction.helper.Validator;
import lorence.construction.helper.math.InternalFormula;
import lorence.construction.other.TemporaryStorage;
import lorence.construction.utitilize.Utils;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.fragment.ListingOperationFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class MordalFragment extends EBaseFragment implements MordalView {

    @BindView(R.id.edtD)
    EditText edtD;

    @BindView(R.id.edtL1)
    EditText edtL1;

    @BindView(R.id.edth)
    EditText edth;

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

    @BindView(R.id.edtReferDynamicLoadResult)
    EditText edtReferDynamicLoadResult;

    @Inject
    Context mContext;

    @Inject
    Validator mValidator;

    @Inject
    HomeActivity mHomeActivity;

    @Inject
    ListingOperationFragment mListingOperationFragment;

    @Inject
    SessionManager mSessionManager;

    @Inject
    InternalFormula mInternalFormula;

    @Inject
    RegularUtils mRegularUtils;

    @Inject
    ConverterUtils mConverterUtils;

    public MordalFragment() {
    }

    public Fragment newInstance(MordalFragment fragment) {
        Bundle b = new Bundle();
        fragment.setArguments(b);
        return fragment;
    }

    private void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new MordalFragmentModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mordal, container, false);
        distributedDaggerComponents();
        bindView(view);
        edtL1.addTextChangedListener(new GenericTextWatcher(edtL1));
        edtD.addTextChangedListener(new GenericTextWatcher(edtD));
        return view;
    }

    @OnClick({R.id.btnPerformCalculator, R.id.btnPerformCalculator1})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPerformCalculator:
                if (checkValidDataInput()) {
                    String result = mInternalFormula.performStaticLoad(mConverterUtils.getDoubleValue(edtBrick), mConverterUtils.getDoubleValue(edtMortar),
                            mConverterUtils.getDoubleValue(edtConcreteFloor), mConverterUtils.getDoubleValue(edtPlasterMortar));
                    edtReferStaticLoad.setText(result);
                }
                break;
            case R.id.btnPerformCalculator1:
                if (!mRegularUtils.isRealNumber(edtReferDynamicLoad.getText().toString())) {
                    Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho hoạt tải", Toast.LENGTH_SHORT).show();
                } else {
                    Double referDynamicLoad = Double.parseDouble(String.valueOf(edtReferDynamicLoad.getText())) * 1.2;
                    edtReferDynamicLoadResult.setText(String.valueOf(Math.round(referDynamicLoad * 100000.0) / 100000.0));
                }
                break;
        }
    }

    @Override
    public boolean checkValidDataInput() {
        if (!mRegularUtils.isRealNumber(edtBrick.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho lót gạch dày", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtMortar.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho vữa lót dày", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtConcreteFloor.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho chiều dày bê tông sàn", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!mRegularUtils.isRealNumber(edtPlasterMortar.getText().toString())) {
            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho vữa trát trần", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    public void updateValueL1() {
        if (edtL1 != null)
            edtL1.setText(TemporaryStorage.getInstance().get(Constants.HASH_MAP.L1));
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Utils.hiddenKeyBoard(mHomeActivity);
            }
        }, 200);
    }

    private class GenericTextWatcher implements TextWatcher {

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
                case R.id.edtD:
                    if (!TextUtils.equals(text, Constants.EMPTY_STRING) && mValidator.checkValidD(text)) {
                        enableCalculateFloorThickness(edtL1.getText().toString(), edtD.getText().toString());
                    } else {
                        edth.setText(Constants.EMPTY_STRING);
                    }
                    break;
            }
        }
    }

    private void enableCalculateFloorThickness(String L1, String D) {
        edth.setText(mInternalFormula.calculateFloorThickness(L1, D));
    }
}
