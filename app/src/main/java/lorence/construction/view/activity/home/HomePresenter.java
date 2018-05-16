package lorence.construction.view.activity.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;

import lorence.construction.R;
import lorence.construction.helper.BasePresenter;
import lorence.construction.helper.Constants;
import lorence.construction.view.fragment.listings.ListingFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class HomePresenter extends BasePresenter<HomeViewData, HomeView> {

    private Activity mActivity;

    private ListingFragment mListingsFragment;

    HomePresenter(HomeActivity homeActivity) {
        super();
        this.mActivity = homeActivity;
    }

    @Override
    protected void updateView() {

    }

    void navigationSelected(@IdRes int menuItemId) {
        if (view() == null) {
            return;
        }

        switch (menuItemId) {
            case R.id.listings:
                view().displayFragment(moveToFragListings(), Constants.TAG.LISTINGS);
                break;
            case R.id.beams:
                break;
            case R.id.settings:
                break;
            case R.id.help:
                break;
        }
    }

    private Fragment moveToFragListings() {
        if (mListingsFragment == null) {
            mListingsFragment = new ListingFragment(mActivity);
        }
        Bundle fragArgs = new Bundle();
        mListingsFragment.setArguments(fragArgs);
        return mListingsFragment;
    }
}
