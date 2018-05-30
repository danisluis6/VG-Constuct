package lorence.construction.view.fragment.listing.fragment;

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
import lorence.construction.data.storage.dao.ListingOperationDao;
import lorence.construction.data.storage.entity.Concrete;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.data.storage.entity.Operation;
import lorence.construction.data.storage.entity.Steel;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.listing.ListingModule;
import lorence.construction.di.module.listing.child.ListingOperationModule;
import lorence.construction.helper.ConditionCalculating;
import lorence.construction.helper.Constants;
import lorence.construction.helper.ConverterUtils;
import lorence.construction.helper.RegularUtils;
import lorence.construction.helper.math.InternalFormula;
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

    @Inject
    ConditionCalculating mConditionCalculating;

    @Inject
    ConverterUtils mConverterUtils;

    @Inject
    ListingOperationDao mListingOperationDao;

    @Inject
    ConcreteFragment mConcreteFragment;

    @Inject
    SteelFragment mSteelFragment;

    @Inject
    InternalFormula mInternalFormula;

    @Inject
    ListingOperationFragment mListingOperationFragment;

    @Inject
    ListingOperationPresenter mListingOperationPresenter;

    @Inject
    FragmentManager mFragmentManager;

    private List<ListingOperation> mGrListingOperations;

    private static final String ARG_POSITION = "position";
    private String mPosition;

    public ListingOperationFragment() {
    }

    public Fragment newInstance(ListingOperationFragment fragment, String tag) {
        Bundle b = new Bundle();
        b.putString(ARG_POSITION, tag);
        fragment.setArguments(b);
        return fragment;
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
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing_operation, container, false);
        bindView(view);
        mGrListingOperations = new ArrayList<>();
        mHomeActivity.hiddenBottomBar();
        mConcreteFragment.setParentFragment(mContext, mListingOperationFragment);
        mConcreteFragment.attachEventInterface(new ConcreteFragment.InterfaceConcreteFragment() {
            @Override
            public void onClickItem(Concrete concrete) {
                mConcreteFragment.dismiss();
                updateValueFieldConcrete(concrete);
            }
        });

        mSteelFragment.setParentFragment(mContext, mListingOperationFragment);
        mSteelFragment.attachEventInterface(new SteelFragment.InterfaceSteelFragment() {
            @Override
            public void onClickItem(Steel steel) {
                mSteelFragment.dismiss();
                updateValueFieldSteel(steel);
            }
        });
        mListingOperationPresenter.getListingOperations();
        mPosition = getArguments().getString(ARG_POSITION);
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

    @Override
    public void onResume() {
        super.onResume();
    }

    @OnClick({R.id.btnPerformCalculator, R.id.edtConcrete, R.id.edtRb, R.id.edtSteel, R.id.edtRs})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPerformCalculator:
                if (checkValidDataInput()) {
                    if(mConditionCalculating.islistingOrBeams(mConverterUtils.getDoubleValue(edtL1), mConverterUtils.getDoubleValue(edtL2))) {
                        Operation operation = mInternalFormula.calculate(mGrListingOperations, mHomeActivity.getTitleToolbar(), mConverterUtils.getDoubleValue(edtL2)/mConverterUtils.getDoubleValue(edtL1));
                        Log.i("TAG", "m1: "+operation.getM1());
                        Log.i("TAG", "m2: "+operation.getM2());
                        Log.i("TAG", "k1: "+operation.getK1());
                        Log.i("TAG", "k2: "+operation.getK2());
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
//        if (!mRegularUtils.isRealNumber(edth.getText().toString())) {
//            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho hs", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        if (!mRegularUtils.isRealNumber(edta.getText().toString())) {
//            Toast.makeText(mContext, "Vui lòng nhập dữ liệu hợp lệ cho a", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        return true;
    }

    @Override
    public void onGetListingOperationsSuccess(List<ListingOperation> listingOperations) {
        mGrListingOperations = listingOperations;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mHomeActivity.updateTitleToolbar(getString(R.string.title_listings));
        mHomeActivity.showBottomBar();
    }

}
