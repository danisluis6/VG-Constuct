package lorence.construction.helper.connect.rx;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import lorence.construction.data.storage.response.ConfigurationResponse;
import retrofit2.Response;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class DisposableManager<T> {
    private IDisposableListener listener;
    private Disposable disposable = null;

    public DisposableManager(IDisposableListener<T> listener) {
        this.listener = listener;
    }

    public Disposable callDisposable(Observable<Response<ConfigurationResponse>> observable) {
        disposable = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Response<ConfigurationResponse>>() {
                    @Override
                    public void onComplete() {
                        listener.onComplete();
                    }

                    @Override
                    public void onNext(Response<ConfigurationResponse> value) {
                        if (value.isSuccessful()) {
                            listener.onHandleData(value.body());
                        } else {
                            listener.onRequestWrongData(value.code());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onApiFailure(e);
                    }
                });
        return disposable;
    }
}