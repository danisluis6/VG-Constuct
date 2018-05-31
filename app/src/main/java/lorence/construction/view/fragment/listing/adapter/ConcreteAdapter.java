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
import lorence.construction.view.fragment.listing.fragment.ListingOperationFragment;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */
public class ConcreteAdapter extends RecyclerView.Adapter<ConcreteAdapter.MyViewHolder> {

    private Context mContext;
    private List<Concrete> mGroupConcretes;
    private CalculateFragment mFragment;

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvConcrete, tvValueConcrete;

        MyViewHolder(View view) {
            super(view);
            tvConcrete = view.findViewById(R.id.tvConcrete);
            tvValueConcrete = view.findViewById(R.id.tvValueConcrete);
        }
    }

    public ConcreteAdapter(Context context, CalculateFragment fragment, List<Concrete> groupConcrete) {
        mContext = context;
        mGroupConcretes = groupConcrete;
        mFragment = fragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_concrete, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Concrete item = mGroupConcretes.get(position);
        holder.tvConcrete.setText(item.getName());
        holder.tvValueConcrete.setText(item.getValue());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterfaceConcreteAdapter.onClickItem(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGroupConcretes.size();
    }

    private InterfaceConcreteAdapter mInterfaceConcreteAdapter;

    public interface InterfaceConcreteAdapter {
        void onClickItem(Concrete concrete);
    }

    public void attachEventInterface(InterfaceConcreteAdapter interfaceConcreteAdapter) {
        mInterfaceConcreteAdapter = interfaceConcreteAdapter;
    }
}

