package lorence.construction.di.module.splash;

import lorence.construction.service.VogoApiService;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface SplashModel {
    void attachPresenter(SplashPresenter splashPresenter);
    void attachApiService(VogoApiService vogoApiService);
    void loadApplicationSettings();
}
