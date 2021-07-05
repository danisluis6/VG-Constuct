package lorence.construction.view.fragment.beams.fragment;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lorence.construction.R;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.fragment.beams.adapter.SpinnerAdapter;

public class SpinnerFragment extends DialogFragment {

    private RecyclerView rvSteel;
    private TextView tvTitleSteel;
    private EBaseFragment mFragment;
    private SpinnerAdapter mSteelAdapter;
    private Context mContext;
    private BeamsOperationFragment.CASE _case;

    public SpinnerFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_spinner, container);
        rvSteel = view.findViewById(R.id.rcvSteel);
        tvTitleSteel = view.findViewById(R.id.tvTitleSteel);
        rvSteel.setLayoutManager(new LinearLayoutManager(mContext));
        mSteelAdapter = new SpinnerAdapter(mContext, mFragment, getValues());
        mSteelAdapter.attachEventInterface(new SpinnerAdapter.InterfaceSpinnerAdapter() {
            @Override
            public void onClickItem(String value) {
                mInterfaceSpinnerFragment.onClickItem(value, _case);
                mInterfaceSpinnerFragment.onClickItem(value);
            }
        });
        rvSteel.setAdapter(mSteelAdapter);
        tvTitleSteel.setText(getString(R.string.title_spinner));
        return view;
    }

    public List<String> getValues() {
        ArrayList<String> list = new ArrayList<>();
        list.add("6");
        list.add("8");
        list.add("10");
        list.add("12");
        list.add("14");
        return list;
    }

    public void setParentFragment(Context context, EBaseFragment parentFragment) {
        mFragment = parentFragment;
        mContext = context;
    }

    private InterfaceSpinnerFragment mInterfaceSpinnerFragment;

    public void addCase(BeamsOperationFragment.CASE __case) {
        _case = __case;
    }

    public interface InterfaceSpinnerFragment {
        void onClickItem(String value, BeamsOperationFragment.CASE _case);
        void onClickItem(String value);
    }

    public void attachEventInterface(InterfaceSpinnerFragment interfaceSpinnerFragment) {
        mInterfaceSpinnerFragment = interfaceSpinnerFragment;
    }
}
