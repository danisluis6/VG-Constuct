package lorence.construction.di.module.splash;

import android.content.Context;

import lorence.construction.R;
import lorence.construction.data.SessionManager;
import lorence.construction.data.storage.entity.Configuration;
import lorence.construction.data.storage.response.ConfigurationResponse;
import lorence.construction.helper.Constants;
import lorence.construction.helper.connect.rx.DisposableManager;
import lorence.construction.helper.connect.rx.IDisposableListener;
import lorence.construction.service.VogoApiService;
import lorence.construction.utitilize.Utils;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class SplashModelImpl implements SplashModel, IDisposableListener<ConfigurationResponse> {

    private Context mContext;
    private SplashPresenter mSplashPresenter;
    private VogoApiService mApiService;
    private DisposableManager<ConfigurationResponse> mDisposableManager;

    public SplashModelImpl(Context context) {
        mContext = context;
        mDisposableManager = new DisposableManager<>(this);
    }

    @Override
    public void attachPresenter(SplashPresenter splashPresenter) {
        mSplashPresenter = splashPresenter;
    }

    @Override
    public void attachApiService(VogoApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public void loadApplicationSettings() {
        mSplashPresenter.setDisposable(mDisposableManager.callDisposable(mApiService.getConfigurationResponseObservable()));
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onHandleData(ConfigurationResponse configurationResponseResponse) {
        if (configurationResponseResponse != null) {
            if (Utils.equalsIgnoreCase(configurationResponseResponse.getError().getMessage(), Constants.SUCCESS_RESPONSE)) {
                Configuration configuration = configurationResponseResponse.getData();
                mSplashPresenter.onGetConfigurationSuccess();
                saveInfoConfigureApp(configuration);
            }
        }
    }

    private void saveInfoConfigureApp(Configuration configuration) {
        SessionManager.getInstance(mContext).setMinimumVersion(configuration.getMinimumVersion());
        SessionManager.getInstance(mContext).setLatestVersion(configuration.getNewestVersion());
    }

    @Override
    public void onRequestWrongData(int code) {
        mSplashPresenter.onGetConfigurationFailure(mContext.getString(R.string.cannot_get_data));
    }

    @Override
    public void onApiFailure(Throwable error) {
        mSplashPresenter.onGetConfigurationFailure(mContext.getString(R.string.error_time_out));
    }
}
