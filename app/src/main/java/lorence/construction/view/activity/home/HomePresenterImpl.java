package lorence.construction.view.activity.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;

import lorence.construction.R;

import lorence.construction.helper.Constants;
import lorence.construction.helper.Validator;
import lorence.construction.view.fragment.about.AboutFragment;
import lorence.construction.view.fragment.beams.BeamFragment;
import lorence.construction.view.fragment.listing.ListingFragment;
import lorence.construction.view.fragment.setting.SettingFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class HomePresenterImpl implements HomePresenter {

    private Validator mValidator;
    private Context mContext;
    private HomeActivity mActivity;
    private HomeView mHomeView;

    // Fragments
    private ListingFragment mListingsFragment;
    private BeamFragment mBeamFragment;
    private SettingFragment mSettingFragment;
    private AboutFragment mAboutFragment;

    public HomePresenterImpl(Validator validator, Context context, HomeActivity homeActivity,
                             ListingFragment listingFragment,
                             BeamFragment beamFragment,
                             SettingFragment settingFragment,
                             AboutFragment aboutFragment) {
        super();
        mValidator = validator;
        mContext = context;
        mActivity = homeActivity;
        mListingsFragment = listingFragment;
        mBeamFragment = beamFragment;
        mSettingFragment = settingFragment;
        mAboutFragment = aboutFragment;
    }

    @Override
    public void attachView(HomeView homeView) {
        mHomeView = homeView;
    }

    @Override
    public void initializes() {
        mHomeView.updateTitleToolbar(mActivity.getString(R.string.title_listings));
    }

    @Override
    public void navigationSelected(@IdRes int menuItemId) {

        switch (menuItemId) {
            case R.id.listings:
                mHomeView.displayFragment(moveToFragListings(), Constants.TAG.LISTING);
                mHomeView.updateTitleToolbar(mActivity.getString(R.string.title_listings));
                break;
            case R.id.beams:
                mHomeView.displayFragment(moveToFragBeams(), Constants.TAG.BEAM);
                mHomeView.updateTitleToolbar(mActivity.getString(R.string.title_beams));
                break;
            case R.id.settings:
                mHomeView.displayFragment(moveToFragSetting(), Constants.TAG.SETTING);
                mHomeView.updateTitleToolbar(mActivity.getString(R.string.title_settings));
                break;
            case R.id.help:
                mHomeView.displayFragment(moveToFragAbout(), Constants.TAG.ABOUT);
                mHomeView.updateTitleToolbar(mActivity.getString(R.string.title_abouts));
                break;
        }
    }

    private Fragment moveToFragListings() {
        Bundle fragArgs = new Bundle();
        mListingsFragment.setArguments(fragArgs);
        return mListingsFragment;
    }

    private Fragment moveToFragBeams() {
        Bundle fragArgs = new Bundle();
        mBeamFragment.setArguments(fragArgs);
        return mBeamFragment;
    }

    private Fragment moveToFragSetting() {
        Bundle fragArgs = new Bundle();
        mSettingFragment.setArguments(fragArgs);
        return mSettingFragment;
    }

    private Fragment moveToFragAbout() {
        Bundle fragArgs = new Bundle();
        mAboutFragment.setArguments(fragArgs);
        return mAboutFragment;
    }

}
