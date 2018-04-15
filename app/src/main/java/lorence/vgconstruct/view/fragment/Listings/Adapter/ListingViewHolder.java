package lorence.vgconstruct.view.fragment.Listings.Adapter;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import lorence.vgconstruct.R;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */
public class ListingViewHolder extends RecyclerView.ViewHolder implements ListingView {

    // MVP
    private ListingPresenter mPresenter;

    // CardView
    private CardView vCardView;

    // View
    private ImageView mListingImg;

    public void bindPresenter(ListingPresenter presenter) {
        mPresenter = presenter;
        mPresenter.bindView(this);
    }

    public void unbindPresenter() {
        //if this causes problems take out and see why
        mPresenter.unbindView();
    }

    public ListingViewHolder(View itemView) {
        super(itemView);
        vCardView = itemView.findViewById(R.id.card_view_listing);
        mListingImg = itemView.findViewById(R.id.listing_image);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.cardClicked();
            }
        });

    }

    @Override
    public int getListingPosition() {
        return this.getAdapterPosition();
    }

    @Override
    public void displayBackground(int resId) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            vCardView.setPreventCornerOverlap(false);
        }
        Picasso
                .with(itemView.getContext())
                .load(resId)
                .centerCrop()
                .fit()
                .into(mListingImg);
        mListingImg.setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    public void setCardMeasurements(int height, int width, int margin) {
        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) vCardView.getLayoutParams();
        lp.height = height;
        lp.width = width;
        lp.setMargins(margin, margin, margin, margin);
    }
}
