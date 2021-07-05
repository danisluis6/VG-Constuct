package lorence.construction.view.fragment.listing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

import java.util.List;

import lorence.construction.R;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.helper.Constants;
import lorence.construction.view.fragment.listing.ListingFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */
public class ListingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Listing> mGroupListings;
    private ListingFragment mFragment;

    public final static int TYPE_ITEM = 0;
    public final static int TYPE_ADS = 1;

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageHolder;

        MyViewHolder(View view) {
            super(view);
            imageHolder = view.findViewById(R.id.imageHolder);
        }
    }

    class AdsViewHolder extends RecyclerView.ViewHolder {

        AdView adView;

        AdsViewHolder(View view) {
            super(view);
            adView = view.findViewById(R.id.adView);
        }
    }

    public ListingAdapter(Context context, ListingFragment fragment, List<Listing> groupListing) {
        mContext = context;
        mGroupListings = groupListing;
        mFragment = fragment;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_listing_item, parent, false);
            return new MyViewHolder(itemView);
        } else if (viewType == TYPE_ADS) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_ads_item, parent, false);
            return new AdsViewHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_ITEM) {
            MyViewHolder custom_holder = (MyViewHolder) holder;
            final Listing item = mGroupListings.get(position);
            Picasso.with(mContext).load(item.getImage()).into(custom_holder.imageHolder);
            custom_holder.imageHolder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mFragment.navigatePageOperation(item.getName());
                }
            });
        } else {
            AdsViewHolder custom_holder = (AdsViewHolder) holder;
            AdRequest adRequest = new AdRequest.Builder()
                    .build();
            custom_holder.adView.loadAd(adRequest);
        }
    }

    @Override
    public int getItemCount() {
        return mGroupListings.size();
    }

    public void updateListing(List<Listing> listings) {
        mGroupListings = listings;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.equals(mGroupListings.get(position).getName(), Constants.EMPTY_STRING)) {
            return TYPE_ADS;
        } else {
            return TYPE_ITEM;
        }
    }
}
