package lorence.construction.view.fragment.beams.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import lorence.construction.R;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.fragment.beams.fragment.BeamsOperationFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */
public class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> mGroup;
    private EBaseFragment mFragment;

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvSpinner;

        MyViewHolder(View view) {
            super(view);
            tvSpinner = view.findViewById(R.id.tvSpinner);
        }
    }

    public SpinnerAdapter(Context context, EBaseFragment fragment, List<String> list) {
        mContext = context;
        mGroup = list;
        mFragment = fragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout_spinner, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final String item = mGroup.get(position);
        holder.tvSpinner.setText(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInterfaceSpinnerAdapter.onClickItem(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGroup.size();
    }

    private InterfaceSpinnerAdapter mInterfaceSpinnerAdapter;

    public interface InterfaceSpinnerAdapter {
        void onClickItem(String value);
    }

    public void attachEventInterface(InterfaceSpinnerAdapter interfaceSpinnerAdapter) {
        mInterfaceSpinnerAdapter = interfaceSpinnerAdapter;
    }
}

