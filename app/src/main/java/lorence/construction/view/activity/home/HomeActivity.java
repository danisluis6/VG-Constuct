package lorence.construction.view.activity.home;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import javax.inject.Inject;

import butterknife.BindView;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.di.module.home.HomeModule;
import lorence.construction.helper.Validator;
import lorence.construction.view.activity.BaseActivity;

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

    @Inject
    Context mContext;

    @Inject
    Validator mValidator;

    @Inject
    HomeActivity mHomeActivity;

    @Inject
    HomePresenter mHomePresenter;

    @Override
    public void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new HomeModule(this))
                .inject(this);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void initAttributes() {
        mHomePresenter.attachView(this);
    }

    @Override
    protected void initViews() {
        mHomePresenter.initializes();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                mHomePresenter.navigationSelected(tabId);
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
            ft.replace(R.id.frameLayout, newFragment, tag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.disallowAddToBackStack();
        }
        ft.commit();
    }

    @Override
    public void updateTitleToolbar(String title) {
        if (tvCurrentOption != null)
            tvCurrentOption.setText(title);
    }

    @Override
    public  String getTitleToolbar() {
        return tvCurrentOption.getText().toString();
    }

    @Override
    public void hiddenBottomBar() {
        if (mBottomBar != null)
            mBottomBar.setVisibility(View.GONE);
    }

    @Override
    public void showBottomBar() {
        if (mBottomBar != null)
            mBottomBar.setVisibility(View.VISIBLE);
    }
}
