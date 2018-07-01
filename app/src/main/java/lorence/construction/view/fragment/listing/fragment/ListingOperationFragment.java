package lorence.construction.view.fragment.listing.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.storage.entity.ListingOperation;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.di.module.listing.ListingModule;
import lorence.construction.di.module.listing.child.ListingOperationModule;
import lorence.construction.view.EBaseFragment;
import lorence.construction.view.activity.home.HomeActivity;
import lorence.construction.view.fragment.listing.ListingFragment;
import lorence.construction.view.fragment.listing.adapter.PagerAdapterPushed;
import lorence.construction.view.fragment.listing.fragment.child.calculate.CalculateFragment;
import lorence.construction.view.fragment.listing.fragment.child.mordal.MordalFragment;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@SuppressLint("ValidFragment")
public class ListingOperationFragment extends EBaseFragment implements ListingOperationView {

    @BindView(R.id.pager)
    ViewPager mViewPager;

    @BindView(R.id.tabs)
    PagerSlidingTabStrip mTabs;

    @Inject
    Context mContext;

    @Inject
    HomeActivity mHomeActivity;

    @Inject
    ListingOperationPresenter mListingOperationPresenter;

    @Inject
    FragmentManager mFragmentManager;

    @Inject
    PagerAdapterPushed mPagerAdapterPushed;

    @Inject
    CalculateFragment mCalculateFragment;

    @Inject
    MordalFragment mMordalFragment;

    private List<ListingOperation> mGrListingOperations;
    private String mTitle;

    public ListingOperationFragment() {
    }

    private void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule((HomeActivity) getActivity()))
                .plus(new ListingModule(Application.getInstance(), (HomeActivity) getActivity(), (ListingFragment) getParentFragment()))
                .plus(new ListingOperationModule(Application.getInstance(), (HomeActivity) getActivity(), this, this))
                .inject(this);
    }

    public Fragment newInstance(String tag) {
        ListingOperationFragment fragment = new ListingOperationFragment();
        Bundle b = new Bundle();
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing_operation, container, false);
        bindView(view);
        distributedDaggerComponents();
        mHomeActivity.hiddenBottomBar();
        mTitle = getArguments().getString("Title");
        mHomeActivity.updateShareButton(R.drawable.ic_share);
        mGrListingOperations = new ArrayList<>();
        mListingOperationPresenter.getListingOperations();
        mViewPager.setAdapter(mPagerAdapterPushed);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mHomeActivity.attachShareButton().setVisibility(View.VISIBLE);
                } else if (position == 1) {
                    mHomeActivity.attachShareButton().setVisibility(View.GONE);
                    mMordalFragment.updateValueL1();
                } else if (position == 2) {
                    mHomeActivity.attachShareButton().setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mTabs.setViewPager(mViewPager);
        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onResume() {
        mHomeActivity.updateTitleToolbar(mTitle);
        super.onResume();
    }

    @Override
    public void onGetListingOperationsSuccess(List<ListingOperation> listingOperations) {
        mGrListingOperations = listingOperations;
    }

    @Override
    public void onDestroyView() {
        mHomeActivity.updateTitleToolbar(getString(R.string.title_listings));
        mHomeActivity.showBottomBar();
        mHomeActivity.updateShareButton(R.drawable.ic_more_vert);
        super.onDestroyView();
    }

    public List<ListingOperation> getListingOperations() {
        return mGrListingOperations;
    }
}
