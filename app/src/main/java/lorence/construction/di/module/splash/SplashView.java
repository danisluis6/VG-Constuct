package lorence.construction.di.module.splash;

import io.reactivex.disposables.Disposable;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public interface SplashView {
    void distributedDaggerComponents();
    void setDisposable(Disposable disposable);
    void onGetConfigurationSuccess();
    void onGetConfigurationFailure(String message);
}
