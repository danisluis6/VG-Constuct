package lorence.construction.view.fragment.beams.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lorence.construction.R;
import lorence.construction.data.storage.entity.Beams;
import lorence.construction.helper.Constants;
import lorence.construction.view.fragment.beams.BeamsFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */
public class BeamsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Beams> mGroupBeams;
    private BeamsFragment mFragment;

    public final static int TYPE_ITEM = 0;
    public final static int TYPE_ADS = 1;

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView m1, m2, type;

        MyViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            type = view.findViewById(R.id.type);
            m1 = view.findViewById(R.id.m1);
            m2 = view.findViewById(R.id.m2);
        }
    }

    public BeamsAdapter(Context context, BeamsFragment fragment, List<Beams> groupBeams) {
        mContext = context;
        mFragment = fragment;
        mGroupBeams = groupBeams;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_beam_item, parent, false);
            return new MyViewHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_ITEM) {
            MyViewHolder custom_holder = (MyViewHolder) holder;
            final Beams item = mGroupBeams.get(position);
            Picasso.with(mContext).load(item.getImage()).into(custom_holder.image);
            custom_holder.type.setText(item.getType());
            custom_holder.m1.setText(item.getM1());
            custom_holder.m2.setText(item.getM2());
            custom_holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFragment.navigatePageOperation(item.getName());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mGroupBeams.size();
    }

    public void updateBeams(List<Beams> beams) {
        mGroupBeams = beams;
        notifyDataSetChanged();
    }

    public List<Beams> getlistOfBeams() {
        return mGroupBeams;
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.equals(mGroupBeams.get(position).getName(), Constants.EMPTY_STRING)) {
            return TYPE_ADS;
        } else {
            return TYPE_ITEM;
        }
    }
}
