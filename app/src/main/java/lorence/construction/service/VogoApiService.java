package lorence.construction.service;

import io.reactivex.Observable;
import lorence.construction.data.storage.response.ConfigurationResponse;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public interface VogoApiService {

    @GET("https://www.youtube.com/")
    Observable<Response<ConfigurationResponse>> getConfigurationResponseObservable();

}
