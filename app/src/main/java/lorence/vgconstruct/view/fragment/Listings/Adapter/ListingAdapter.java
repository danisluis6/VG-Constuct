package lorence.vgconstruct.view.fragment.Listings.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lorence.vgconstruct.R;
import lorence.vgconstruct.custom.adapter.CardConfig;
import lorence.vgconstruct.model.ListingItem;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingAdapter extends RecyclerView.Adapter <ListingViewHolder>{

    private CardConfig mCardConfig;
    private List<ListingItem> mListings;

    public ListingAdapter(){
        mListings = new ArrayList<>();
    }

    public void updateCategories(List<ListingItem> listings){
        mListings = listings;
    }

    public void updateCardConfig(CardConfig cardConfig){
        mCardConfig = cardConfig;
    }

    @Override
    public ListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.view_listing_card, parent, false);
        return new ListingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListingViewHolder holder, int position) {
        ListingItem item = mListings.get(position);
        ListingPresenter presenter = new ListingPresenter(mCardConfig);
        presenter.setModel(item);
        holder.bindPresenter(presenter);
    }

    @Override
    public int getItemCount() {
        return mListings.size();
    }

    @Override
    public void onViewRecycled(ListingViewHolder holder){
        super.onViewRecycled(holder);
        holder.unbindPresenter();
    }
}
