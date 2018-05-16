package lorence.construction.view.fragment.listing.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lorence.construction.R;
import lorence.construction.model.Listing;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */
public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.MyViewHolder> {

    private Context mContext;
    private List<Listing> mGroupListings;

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        MyViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
        }
    }

    public ListingAdapter(Context context, List<Listing> groupListing) {
        mContext = context;
        mGroupListings = groupListing;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_listing_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Listing item = mGroupListings.get(position);
        Picasso.with(mContext).load(item.getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mGroupListings.size();
    }

}
