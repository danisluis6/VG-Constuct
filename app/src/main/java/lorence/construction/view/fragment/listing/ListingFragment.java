package lorence.construction.view.fragment.listing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.Stack;

import javax.inject.Inject;

import butterknife.BindView;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.listing.ListingModule;
import lorence.construction.helper.FragmentStack;
import lorence.construction.helper.FragmentUtils;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.adapter.ListingAdapter;
import lorence.construction.view.fragment.listing.fragment.ListingOperationFragment;
import lorence.construction.view.fragment.listing.module.DataSource;
import lorence.construction.view.fragment.listing.module.GridSpacingItemDecoration;
import lorence.construction.view.fragment.listing.module.ListingView;

/**
 * Created by vuongluis on 4/14/2018.
 *
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
    ListingOperationFragment mListingOperationFragment;

    @Inject
    ListingPresenter mListingPresenter;

    @Inject
    ListingAdapter mListingAdapter;

    @Inject
    DataSource mListingDataSource;

    @Inject
    GridSpacingItemDecoration mGridSpacingItemDecoration;

    private Stack<FragmentStack> mCurrentFrgStack;
    private FragmentUtils mFragmentUtils;

    @SuppressLint("ValidFragment")
    public ListingFragment() {
    }

    private void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new ListingModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing, container, false);
        distributedDaggerComponents();
        bindView(view);
        initComponents();
        return view;
    }

    @Override
    public void initComponents() {
        GridLayoutManager mLayoutManager = new GridLayoutManager(mActivity, 2);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (mListingAdapter.getItemViewType(position)) {
                    case ListingAdapter.TYPE_ITEM:
                        return 1;
                    case ListingAdapter.TYPE_ADS:
                        return 2;
                    default:
                        return -1;
                }
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(mGridSpacingItemDecoration);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mListingAdapter);

        mCurrentFrgStack = new Stack<>();
        mFragmentUtils = new FragmentUtils(mActivity, mListingFragment, mCurrentFrgStack, R.id.content_listing);

        mListingPresenter.getListings();
        mListingPresenter.getListingOperations();
    }

    @Override
    public void onResume() {
        super.onResume();
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
    public void onGetListingOperationsSuccess(List<ListingOperation> listingOperations) {
        if (listingOperations.size() == 0) {
            initializeNewListingOperations();
        }
    }

    @Override
    public void initializeNewListings() {
        mListingPresenter.saveListings(mListingDataSource.getDefaultListingData());
        mListingAdapter.updateListing(mListingDataSource.getDefaultListingData());
    }

    @Override
    public void initializeNewListingOperations() {
        mListingPresenter.saveListingOperations(mListingDataSource.getDefaultListingOperationData());
    }

    @Override
    public void navigatePageOperation(String tag) {
        mListingOperationFragment = (ListingOperationFragment) mListingOperationFragment.newInstance(tag);
        pushFragment(mListingOperationFragment, tag);
    }

    @Override
    public void pushFragment(Fragment fragment, String tag) {
        fragment.setArguments(getTitleTitle(tag));
        switchFragment(fragment, tag);
        mActivity.attachListingFragment(this);
        defineToolbar(tag);
    }

    void switchFragment(@NonNull Fragment fragment, String tag) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content_listing, fragment);
        transaction.addToBackStack(tag);
        transaction.commit();
        fragmentManager.executePendingTransactions();
    }

    @Override
    public void defineToolbar(String title) {
        mActivity.updateTitleToolbar(title);
    }

    public Bundle getTitleTitle(String tag) {
        Bundle bundle = new Bundle();
        bundle.putString("Title", tag);
        return bundle;
    }
}
