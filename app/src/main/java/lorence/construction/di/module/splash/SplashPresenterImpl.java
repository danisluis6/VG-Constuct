package lorence.construction.di.module.splash;

import android.content.Context;

import io.reactivex.disposables.Disposable;
import lorence.construction.service.VogoApiService;
import lorence.construction.view.activity.splash.SplashActivity;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class SplashPresenterImpl implements SplashPresenter {

    private Context mContext;
    private SplashActivity mActivity;
    private SplashView mSplashView;
    private SplashModel mSplashModel;

    public SplashPresenterImpl(Context context, SplashActivity activity, SplashView splashView, SplashModel splashModel, VogoApiService vogoApiService) {
        mContext = context;
        mActivity = activity;
        mSplashView = splashView;
        mSplashModel = splashModel;
        mSplashModel.attachPresenter(this);
        mSplashModel.attachApiService(vogoApiService);
    }

    @Override
    public void loadApplicationSettings() {
        mSplashModel.loadApplicationSettings();
    }

    @Override
    public void setDisposable(Disposable disposable) {
        mSplashView.setDisposable(disposable);
    }

    @Override
    public void onGetConfigurationSuccess() {
        mSplashView.onGetConfigurationSuccess();
    }

    @Override
    public void onGetConfigurationFailure(String message) {
        mSplashView.onGetConfigurationFailure(message);
    }
}
