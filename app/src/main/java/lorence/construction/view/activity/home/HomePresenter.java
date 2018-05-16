package lorence.construction.view.activity.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;

import lorence.construction.R;
import lorence.construction.helper.BasePresenter;
import lorence.construction.helper.Constants;
import lorence.construction.helper.Validator;
import lorence.construction.view.fragment.listings.ListingFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class HomePresenter extends BasePresenter<HomeViewData, HomeView> {

    private ListingFragment mListingsFragment;
    private Validator mValidator;
    private Context mContext;
    private HomeActivity mActivity;

    public HomePresenter(Validator validator, Context context, HomeActivity homeActivity) {
        super();
        mValidator = validator;
        mContext = context;
        mActivity = homeActivity;
    }

    @Override
    protected void updateView() {

    }

    void navigationSelected(@IdRes int menuItemId) {
        switch (menuItemId) {
            case R.id.listings:
                mActivity.displayFragment(moveToFragListings(), Constants.TAG.LISTINGS);
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
