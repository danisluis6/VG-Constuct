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
import lorence.construction.data.storage.entity.Concrete;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.fragment.listing.adapter.ConcreteAdapter;

public class ConcreteFragment extends DialogFragment {

    private RecyclerView rvConcrete;
    private TextView tvTitleConcrete;
    private EBaseFragment mFragment;
    private ConcreteAdapter mConcreteAdapter;
    private Context mContext;

    public ConcreteFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog_concrete,container);
        rvConcrete= view.findViewById(R.id.rcvConcrete);
        tvTitleConcrete = view.findViewById(R.id.tvTitleConcrete);
        rvConcrete.setLayoutManager(new LinearLayoutManager(mContext));
        mConcreteAdapter = new ConcreteAdapter(mContext, mFragment, getConcretes());
        mConcreteAdapter.attachEventInterface(new ConcreteAdapter.InterfaceConcreteAdapter() {
            @Override
            public void onClickItem(Concrete concrete) {
                mInterfaceConcreteFragment.onClickItem(concrete);
            }
        });
        rvConcrete.setAdapter(mConcreteAdapter);
        tvTitleConcrete.setText(getString(R.string.title_concrete));
        return view;
    }

    public List<Concrete> getConcretes() {
        ArrayList<Concrete> list = new ArrayList<>();
        list.add(new Concrete("B12.5", "7.5"));
        list.add(new Concrete("B15", "8.5"));
        list.add(new Concrete("B20", "11.5"));
        list.add(new Concrete("B25", "14.5"));
        list.add(new Concrete("B30", "17.0"));
        list.add(new Concrete("B35", "19.5"));
        return list;
    }

    public void setParentFragment(Context context, EBaseFragment parentFragment) {
        mFragment = parentFragment;
        mContext = context;
    }

    private InterfaceConcreteFragment mInterfaceConcreteFragment;

    public interface InterfaceConcreteFragment {
        void onClickItem(Concrete concrete);
    }

    public void attachEventInterface(InterfaceConcreteFragment interfaceConcreteFragment) {
        mInterfaceConcreteFragment = interfaceConcreteFragment;
    }
}
