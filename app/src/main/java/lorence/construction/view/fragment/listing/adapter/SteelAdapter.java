package lorence.construction.view.fragment.listing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lorence.construction.R;
import lorence.construction.data.storage.entity.Concrete;
import lorence.construction.data.storage.entity.Steel;
import lorence.construction.view.fragment.listing.fragment.ListingOperationFragment;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */
public class SteelAdapter extends RecyclerView.Adapter<SteelAdapter.MyViewHolder> {

    private Context mContext;
    private List<Steel> mGroupSteels;
    private CalculateFragment mFragment;

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvSteel, tvValueSteel;

        MyViewHolder(View view) {
            super(view);
            tvSteel = view.findViewById(R.id.tvSteel);
            tvValueSteel = view.findViewById(R.id.tvValueSteel);
        }
    }

    public SteelAdapter(Context context, CalculateFragment fragment, List<Steel> groupSteel) {
        mContext = context;
        mGroupSteels = groupSteel;
        mFragment = fragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_steel, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Steel item = mGroupSteels.get(position);
        holder.tvSteel.setText(item.getName());
        holder.tvValueSteel.setText(item.getValue());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterfaceSteelAdapter.onClickItem(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGroupSteels.size();
    }

    private InterfaceSteelAdapter mInterfaceSteelAdapter;

    public interface InterfaceSteelAdapter {
        void onClickItem(Steel steel);
    }

    public void attachEventInterface(InterfaceSteelAdapter interfaceSteelAdapter) {
        mInterfaceSteelAdapter = interfaceSteelAdapter;
    }
}

