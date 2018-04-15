package lorence.vgconstruct.view.fragment.Listings;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import lorence.vgconstruct.R;
import lorence.vgconstruct.app.VGApplication;
import lorence.vgconstruct.custom.SpannableGridLayoutManager;
import lorence.vgconstruct.custom.adapter.CardConfig;
import lorence.vgconstruct.helper.PresenterManager;
import lorence.vgconstruct.model.ListingItem;
import lorence.vgconstruct.view.EBaseFragment;
import lorence.vgconstruct.view.fragment.Listings.Adapter.ListingAdapter;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class ListingsFragment extends EBaseFragment implements ListingsView {

    @BindView(R.id.listing_card_list)
    RecyclerView mRecyclerView;

    // Adapter
    private ListingAdapter mListingsAdapter;

    // KEY
    private final String CLASS_TAG = this.getClass().getSimpleName();

    // MVP
    private ListingsPresenter mListingsPresenter;
    private int mColumnConstant;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        PresenterManager.getInstance().put(CLASS_TAG, mListingsPresenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_listings, container, false);
        if (PresenterManager.getInstance().get(CLASS_TAG) != null) {
            mListingsPresenter = (ListingsPresenter) PresenterManager.getInstance().get(CLASS_TAG);
        } else {
            mListingsPresenter = new ListingsPresenter();
        }
        bindView(view);
        initAdapter();
        return view;
    }

    private void initAdapter() {
        mListingsAdapter = new ListingAdapter();
        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);
        }
        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2));
        mRecyclerView.setAdapter(mListingsAdapter);
    }

    @Override
    public void showListingItems(List<ListingItem> categoryItemList, CardConfig categoryCardConfig) {
        mListingsAdapter.updateCategories(categoryItemList);
        mListingsAdapter.updateCardConfig(categoryCardConfig);
        mListingsAdapter.notifyDataSetChanged();
    }

    @Override
    public int getScreenColumns() {
        return mColumnConstant;
    }

    @Override
    public Context getViewContext() {
        return getContext().getApplicationContext();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateColumnCount(VGApplication.SCREEN_WIDTH_DP);
        mListingsPresenter.bindView(this);
    }

    public void updateColumnCount(float screenWidthDp) {
        if (screenWidthDp < 600) {
            mColumnConstant = 2;
        } else if (screenWidthDp >= 600 && screenWidthDp < 900) {
            mColumnConstant = 3;
        } else if (screenWidthDp >= 900) {
            mColumnConstant = 4;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mListingsPresenter.unbindView();
    }

    @Override
    public void onStop() {
        super.onStop();
        mRecyclerView.setVisibility(View.GONE);
    }
}
