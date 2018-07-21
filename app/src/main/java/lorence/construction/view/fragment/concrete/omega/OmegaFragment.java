package lorence.construction.view.fragment.concrete.omega;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lorence.construction.R;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.fragment.beams.adapter.SpinnerAdapter;
import lorence.construction.view.fragment.beams.fragment.BeamsOperationFragment;

public class OmegaFragment extends DialogFragment {

    private RecyclerView rvSteel;
    private TextView tvTitleSteel;
    private EBaseFragment mFragment;
    private SpinnerAdapter mSteelAdapter;
    private Context mContext;
    private BeamsOperationFragment.CASE _case;

    public OmegaFragment() {
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
                String pattern = "={1}\\s.*\\s-{1}\\s";
                Matcher player = Pattern.compile(pattern).matcher(value);
                if (player.find()) {
                    mInterfaceSpinnerFragment.onClickItem(player.group().substring(2, player.group().length()-2));
                }
            }
        });
        rvSteel.setAdapter(mSteelAdapter);
        tvTitleSteel.setText(getString(R.string.title_omega));
        return view;
    }

    /**
     * https://www.jdoodle.com/online-java-compiler
     */
    public List<String> getValues() {
        ArrayList<String> list = new ArrayList<>();
        list.add("ω = 1.3 - Khung 1 tầng, 1 nhịp");
        list.add("ω = 1.17 - Khung 1 tầng, 2 nhịp");
        list.add("ω = 1.04 - Khung 1 tầng, ≥3 nhịp");
        list.add("ω = 0.7 - Khung nhiều tầng, 2 nhịp trở lên");
        list.add("ω = 1 - Cột dưới cùng khung nhiều tầng, 1 nhịp");
        list.add("ω = 1.25 - Cột trên khung nhiều tầng, 1 nhịp");
        return list;
    }

    public void setParentFragment(Context context, EBaseFragment parentFragment) {
        mFragment = parentFragment;
        mContext = context;
    }

    private InterfaceSpinnerFragment mInterfaceSpinnerFragment;

    public interface InterfaceSpinnerFragment {
        void onClickItem(String value);
    }

    public void attachEventInterface(InterfaceSpinnerFragment interfaceSpinnerFragment) {
        mInterfaceSpinnerFragment = interfaceSpinnerFragment;
    }
}
