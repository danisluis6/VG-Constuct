package lorence.construction.view.fragment.listing.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
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

    private List<ListingOperation> mGrListingOperations;

    public ListingOperationFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
        mGrListingOperations = new ArrayList<>();
        mHomeActivity.hiddenBottomBar();
        mListingOperationPresenter.getListingOperations();
        mViewPager.setAdapter(mPagerAdapterPushed);
        mTabs.setViewPager(mViewPager);
        return view;
    }

    @Override
    public void onGetListingOperationsSuccess(List<ListingOperation> listingOperations) {
        mGrListingOperations = listingOperations;
    }

    @Override
    public void onDestroyView() {
        mHomeActivity.updateTitleToolbar(getString(R.string.title_listings));
        mHomeActivity.showBottomBar();
        super.onDestroyView();
    }

    public List<ListingOperation> getListingOperations() {
        return mGrListingOperations;
    }
}
