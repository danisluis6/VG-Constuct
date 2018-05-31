package lorence.construction.view.fragment.listing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lorence.construction.R;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.view.fragment.listing.ListingFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */
public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.MyViewHolder> {

    private Context mContext;
    private List<Listing> mGroupListings;
    private ListingFragment mFragment;

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        MyViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
        }
    }

    public ListingAdapter(Context context, ListingFragment fragment, List<Listing> groupListing) {
        mContext = context;
        mGroupListings = groupListing;
        mFragment = fragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_listing_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Listing item = mGroupListings.get(position);
        Picasso.with(mContext).load(item.getImage()).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragment.navigatePageOperation(item.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGroupListings.size();
    }

    public void updateListing(List<Listing> listings) {
        mGroupListings = listings;
        notifyDataSetChanged();
    }

}
