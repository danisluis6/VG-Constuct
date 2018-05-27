package lorence.construction.view.fragment.listing.fragment;

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
import lorence.construction.data.storage.entity.Steel;
import lorence.construction.view.fragment.listing.adapter.SteelAdapter;

public class SteelFragment extends DialogFragment {

    private RecyclerView rvSteel;
    private TextView tvTitleSteel;
    private ListingOperationFragment mFragment;
    private SteelAdapter mSteelAdapter;
    private Context mContext;

    public SteelFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_steel,container);
        rvSteel= view.findViewById(R.id.rcvSteel);
        tvTitleSteel = view.findViewById(R.id.tvTitleSteel);
        rvSteel.setLayoutManager(new LinearLayoutManager(mContext));
        mSteelAdapter = new SteelAdapter(mContext, mFragment, getSteels());
        mSteelAdapter.attachEventInterface(new SteelAdapter.InterfaceSteelAdapter() {
            @Override
            public void onClickItem(Steel steel) {
                mInterfaceSteelFragment.onClickItem(steel);
            }
        });
        rvSteel.setAdapter(mSteelAdapter);
        tvTitleSteel.setText(getString(R.string.title_steel));
        return view;
    }

    public List<Steel> getSteels() {
        ArrayList<Steel> list = new ArrayList<>();
        list.add(new Steel("CI", "4.50"));
        list.add(new Steel("CII", "4.50"));
        list.add(new Steel("CIII", "4.50"));
        return list;
    }

    public void setParentFragment(Context context, ListingOperationFragment parentFragment) {
        mFragment = parentFragment;
        mContext = context;
    }

    private InterfaceSteelFragment mInterfaceSteelFragment;

    public interface InterfaceSteelFragment {
        void onClickItem(Steel steel);
    }

    public void attachEventInterface(InterfaceSteelFragment interfaceSteelFragment) {
        mInterfaceSteelFragment = interfaceSteelFragment;
    }
}
