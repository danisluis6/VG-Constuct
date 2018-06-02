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
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.SessionManager;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.listing.child.MordalFragmentModule;
import lorence.construction.helper.Constants;
import lorence.construction.helper.Validator;
import lorence.construction.helper.math.InternalFormula;
import lorence.construction.utitilize.Utils;
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

    @BindView(R.id.edtL1)
    EditText edtL1;

    @BindView(R.id.edth)
    EditText edth;

    @Inject
    HomeActivity mHomeActivity;

    @Inject
    ListingOperationFragment mListingOperationFragment;

    @Inject
    SessionManager mSessionManager;

    @Inject
    InternalFormula mInternalFormula;

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
        edtL1.addTextChangedListener(new GenericTextWatcher(edtL1));
        edtD.addTextChangedListener(new GenericTextWatcher(edtD));
        return view;
    }

    public void updateValueL1() {
        if (edtL1 != null)
            edtL1.setText(mSessionManager.getL1());
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Utils.hiddenKeyBoard(mHomeActivity);
            }
        }, 200);
    }

    @Inject
    Validator mValidator;

    @Inject
    Context mContext;

    private class GenericTextWatcher implements TextWatcher {

        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        public void afterTextChanged(Editable editable) {
            String text = editable.toString();
            switch (view.getId()) {
                case R.id.edtD:
                    if (!TextUtils.equals(text, Constants.EMPTY_STRING) && mValidator.checkValidD(text)) {
                        enableCalculateFloorThickness(edtL1.getText().toString(), edtD.getText().toString());
                    } else {
                        edth.setText(Constants.EMPTY_STRING);
                        Toast.makeText(mContext, "Vui lòng nhập giá trị trong khoảng", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }

    private void enableCalculateFloorThickness(String L1, String D) {
        edth.setText(mInternalFormula.calculateFloorThickness(L1, D));
    }
}
