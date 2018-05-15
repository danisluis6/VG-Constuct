package lorence.construction.view.activity.home;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import lorence.construction.R;
import lorence.construction.helper.Constants;
import lorence.construction.helper.PresenterManager;
import lorence.construction.view.activity.BaseActivity;
import lorence.construction.view.fragment.Listings.ListingsFragment;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class HomeActivity extends BaseActivity implements HomeView {

    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;

    @BindView(R.id.logo)
    ImageView mToolbarLogo;

    @BindView(R.id.tvCurrentOption)
    TextView tvCurrentOption;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private int mLastSelectedTab;

    //  Constants
    public static final String SELECTED_TAB_KEY = "selectedTabKey";
    private String CLASS_TAG = "HomeActivity";

    // MVP
    private HomePresenter mHomePresenter;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
        PresenterManager.getInstance().put(CLASS_TAG, mHomePresenter);
        savedInstanceState.putInt(SELECTED_TAB_KEY, mLastSelectedTab);
    }

    @Override
    public void distributedDaggerComponents() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.layout_home;
    }

    @Override
    protected void initAttributes() {
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mHomePresenter= (HomePresenter) PresenterManager.getInstance().get(CLASS_TAG);
        if (mHomePresenter == null) {
            mHomePresenter = new HomePresenter(this);
        }
        mHomePresenter.bindView(this);
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (mLastSelectedTab != tabId) {
                    mHomePresenter.navigationSelected(tabId);
                    mLastSelectedTab = tabId;
                }
            }
        });
    }

    @Override
    public void displayFragment(Fragment newFragment, String tag) {
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        if (fragmentManager.findFragmentByTag(tag) != null) {
            fragment = fragmentManager.findFragmentByTag(tag);
            ft.replace(R.id.frameLayout, fragment, tag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        } else {
            fragment = newFragment;
            ft.replace(R.id.frameLayout, fragment, tag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
