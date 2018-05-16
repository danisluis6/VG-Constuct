package lorence.construction.view.fragment.listing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.storage.entity.Listing;
import lorence.construction.di.module.HomeModule;
import lorence.construction.di.module.ListingModule;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.adapter.ListingAdapter;
import lorence.construction.view.fragment.listing.module.GridSpacingItemDecoration;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class ListingFragment extends EBaseFragment {

    @BindView(R.id.listing_card_list)
    RecyclerView mRecyclerView;

    private ListingAdapter mAdapter;
    private List<Listing> mGroupListings;

    private Activity mActivity;

    @Inject
    Context mContext;

    @Inject
    ListingFragment mListingFragment;
    @Inject
    ListingPresenter mListingPresenter;

    @Inject
    GridSpacingItemDecoration mGridSpacingItemDecoration;

    @SuppressLint("ValidFragment")
    public ListingFragment(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Application.get(mActivity)
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) mActivity))
                .plus(new ListingModule(mContext, (HomeActivity) mActivity, this))
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing, container, false);
        bindView(view);
        mGroupListings = new ArrayList<>();
        mAdapter = new ListingAdapter(mActivity, mGroupListings);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mActivity, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(mGridSpacingItemDecoration);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        prepareListings();
    }

    private void prepareListings() {
        int[] covers = new int[]{
                R.drawable.ic_bang_ke_1,
                R.drawable.ic_bang_ke_2,
                R.drawable.ic_bang_ke_3,
                R.drawable.ic_bang_ke_4,
                R.drawable.ic_bang_ke_5,
                R.drawable.ic_bang_ke_6,
                R.drawable.ic_bang_ke_7,
                R.drawable.ic_bang_ke_8,
                R.drawable.ic_bang_ke_9,
                R.drawable.ic_bang_ke_10,
                R.drawable.ic_bang_ke_11
        };

        mGroupListings.add(new Listing("Bảng Kê 1", covers[0]));
        mGroupListings.add(new Listing("Bảng Kê 2", covers[1]));
        mGroupListings.add(new Listing("Bảng Kê 3", covers[2]));
        mGroupListings.add(new Listing("Bảng Kê 4", covers[3]));
        mGroupListings.add(new Listing("Bảng Kê 5", covers[4]));
        mGroupListings.add(new Listing("Bảng Kê 6", covers[5]));
        mGroupListings.add(new Listing("Bảng Kê 7", covers[6]));
        mGroupListings.add(new Listing("Bảng Kê 8", covers[7]));
        mGroupListings.add(new Listing("Bảng Kê 9", covers[8]));
        mGroupListings.add(new Listing("Bảng Kê 10", covers[9]));
        mGroupListings.add(new Listing("Bảng Kê 11", covers[10]));

        mListingPresenter.saveListings(mGroupListings);
        mAdapter.notifyDataSetChanged();
    }
}
