package lorence.construction.view.fragment.listing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.listing.ListingModule;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.adapter.ListingAdapter;
import lorence.construction.view.fragment.listing.module.GridSpacingItemDecoration;
import lorence.construction.view.fragment.listing.module.ListingDataSource;
import lorence.construction.view.fragment.listing.module.ListingView;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class ListingFragment extends EBaseFragment implements ListingView {

    @BindView(R.id.listing_card_list)
    RecyclerView mRecyclerView;

    @Inject
    Context mContext;

    @Inject
    HomeActivity mActivity;

    @Inject
    ListingFragment mListingFragment;

    @Inject
    ListingPresenter mListingPresenter;

    @Inject
    ListingAdapter mListingAdapter;

    @Inject
    ListingDataSource mListingDataSource;

    @Inject
    GridSpacingItemDecoration mGridSpacingItemDecoration;

    @SuppressLint("ValidFragment")
    public ListingFragment() {
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new ListingModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing, container, false);
        bindView(view);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mActivity, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(mGridSpacingItemDecoration);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mListingAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mListingPresenter.getListings();
    }

    @Override
    public void onGetListingsSuccess(List<Listing> listings) {
        if (listings.size() == 0) {
            initializeNewListings();
        } else {
            mListingAdapter.updateListing(listings);
        }
    }

    @Override
    public void initializeNewListings() {
        mListingPresenter.saveListings(mListingDataSource.getDefaultListingData());
        mListingAdapter.updateListing(mListingDataSource.getDefaultListingData());
    }
}
