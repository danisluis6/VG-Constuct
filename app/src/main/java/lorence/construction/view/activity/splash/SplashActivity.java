package lorence.construction.view.activity.splash;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import java.util.Date;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import lorence.construction.R;
import lorence.construction.app.Application;
import lorence.construction.data.SessionManager;
import lorence.construction.di.module.splash.SplashModule;
import lorence.construction.di.module.splash.SplashPresenter;
import lorence.construction.di.module.splash.SplashView;
import lorence.construction.helper.AlertDialog;
import lorence.construction.helper.Constants;
import lorence.construction.utitilize.Utils;
import lorence.construction.view.activity.home.HomeActivity;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class SplashActivity extends AppCompatActivity implements SplashView {

    private boolean mApiSuccess = false;
    private boolean mTimeOut = false;
    private boolean isUpgrade = false;
    private Disposable mDisposable;
    private AlertDialog mAlertDialogConfirm;

    @Inject
    Context mContext;

    @Inject
    SessionManager mSessionManager;

    @Inject
    SplashPresenter mSplashPresenter;

    @Override
    public void distributedDaggerComponents() {
        Application.getInstance()
                .getAppComponent()
                .plus(new SplashModule(mContext, this, this))
                .inject(this);
    }

    @Override
    public void setDisposable(Disposable disposable) {
        mDisposable = disposable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        distributedDaggerComponents();
        if (!isTaskRoot()) {
            final Intent intent = getIntent();
            final String intentAction = intent.getAction();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && TextUtils.equals(intentAction, Intent.ACTION_MAIN)) {
                finish();
            }
        }
//        mSplashPresenter.loadApplicationSettings();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mTimeOut = true;
                moveToNextActivity();
            }
        }, 200);
    }


    @Override
    protected void onResume() {
        super.onResume();
//        if (isUpgrade) {
//            String currentVersionApp = Utils.versionToComparable(Utils.getVersionName(getApplicationContext()));
//            String minimumVersionApp = Utils.versionToComparable(SessionManager.getInstance(this).getMinimumVersion());
//            if (currentVersionApp.compareTo(minimumVersionApp) < 0) {
//                forceUserUpgradeLatestVersion(true);
//                return;
//            }
//            mApiSuccess = true;
//            moveToNextActivity();
//        }
    }

    @Override
    public void onGetConfigurationSuccess() {
        String currentVersionApp = Utils.versionToComparable(Utils.getVersionName(getApplicationContext()));
        String minimumVersionApp = Utils.versionToComparable(SessionManager.getInstance(this).getMinimumVersion());
        String newestVersionApp = Utils.versionToComparable(SessionManager.getInstance(this).getLatestVersion());
        if (currentVersionApp.compareTo(minimumVersionApp) < 0) {
            forceUserUpgradeLatestVersion(true);
        } else if (currentVersionApp.compareTo(minimumVersionApp) >= 0 && currentVersionApp.compareTo(newestVersionApp) < 0) {
            forceUserUpgradeLatestVersion(false);
        } else {
            mApiSuccess = true;
            moveToNextActivity();
        }
    }

    private void forceUserUpgradeLatestVersion(boolean isForce) {
        if (isFinishing()) {
            return;
        }
        if (TextUtils.equals(Utils.getVersionName(getApplicationContext()), SessionManager.getInstance(this).getLatestVersion()) || !isTimeExpire() && !isForce) {
            mApiSuccess = true;
            moveToNextActivity();
        } else {
            if (mAlertDialogConfirm == null) {
                mAlertDialogConfirm = new AlertDialog().createDialog(String.format(getString(R.string.warning_upgrade_new_version),
                        String.valueOf(SessionManager.getInstance(this).getLatestVersion())), getString(R.string.btn_update), !isForce ? getString(R.string.btn_dismiss) : null);
                mAlertDialogConfirm.setOnPositiveListener(new AlertDialog.OnPositiveListener() {
                    @Override
                    public void onPositiveListener() {
                        final String appPackageName = getPackageName();
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.URL_APP_MARKET + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.URL_APP_STORE + appPackageName)));
                        }
                        isUpgrade = true;
                    }
                });
                mAlertDialogConfirm.setOnNegativeListener(new AlertDialog.OnNegativeListener() {
                    @Override
                    public void onNegativeListener() {
                        mApiSuccess = true;
                        setTimeToOpenDialog();
                        moveToNextActivity();
                    }
                });
            }
            if (!mAlertDialogConfirm.isAdded()) {
                mAlertDialogConfirm.show(SplashActivity.this.getSupportFragmentManager(), getString(R.string.error));
            }
        }
    }

    private boolean isTimeExpire() {
        Date date = new Date(System.currentTimeMillis());
        long result = (date.getTime() - SessionManager.getInstance(this).getDateUpgradeApp()) / 1000;
        return result > 24 * 60 * 60;
    }

    public void setTimeToOpenDialog() {
        Date date = new Date(System.currentTimeMillis());
        SessionManager.getInstance(this).setDateUpgradeApp(date.getTime());
    }

    /**
     * Move to next activity
     */
    private void moveToNextActivity() {
        if (mTimeOut /* && mApiSuccess*/) {
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            finish();
        }
    }

    @Override
    public void onGetConfigurationFailure(String message) {
        AlertDialog mAlertDialogFailed = new AlertDialog().createDialog(message, getString(R.string.btn_retry), getString(R.string.btn_exit));
        mAlertDialogFailed.setOnPositiveListener(new AlertDialog.OnPositiveListener() {
            @Override
            public void onPositiveListener() {
                mSplashPresenter.loadApplicationSettings();
            }
        });
        mAlertDialogFailed.setOnNegativeListener(new AlertDialog.OnNegativeListener() {
            @Override
            public void onNegativeListener() {
                finish();
            }
        });
        mAlertDialogFailed.show(SplashActivity.this.getSupportFragmentManager(), getString(R.string.error));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}
