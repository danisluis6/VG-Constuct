package lorence.construction.view.fragment.beams.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lorence.construction.R;
import lorence.construction.data.storage.entity.Beams;
import lorence.construction.view.fragment.beams.BeamsFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */
public class BeamsAdapter extends RecyclerView.Adapter<BeamsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Beams> mGroupBeams;
    private BeamsFragment mFragment;

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView m1,m2,type;

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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_beam_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Beams item = mGroupBeams.get(position);
        Picasso.with(mContext).load(item.getImage()).into(holder.image);
        holder.type.setText(item.getType());
        holder.m1.setText(item.getM1());
        holder.m2.setText(item.getM2());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragment.navigatePageOperation(item.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGroupBeams.size();
    }

    public void updateBeams(List<Beams> beams) {
        mGroupBeams = beams;
        notifyDataSetChanged();
    }
}
