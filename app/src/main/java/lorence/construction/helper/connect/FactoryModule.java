package lorence.construction.helper.connect;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import lorence.construction.BuildConfig;
import lorence.construction.app.Application;
import lorence.construction.data.SessionManager;
import lorence.construction.helper.Validator;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

@Module
public class FactoryModule {

    private Application mApplication;
    private Context mContext;

    public FactoryModule(Application application, Context context) {
        mApplication = application;
        mContext = context;
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor();
    }

    @Singleton
    @Provides
    @Named("ok-1")
    OkHttpClient.Builder provideOkHttpClient1(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
    }

    @Singleton
    @Provides
    @Named("ok-2")
    OkHttpClient.Builder provideOkHttpClient2(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
    }

    @Singleton
    @Provides
    TrustHtppS provideTrustHtppS(@Named("ok-1") OkHttpClient.Builder client) {
        return new TrustHtppS(client);
    }

    @Singleton
    @Provides
    @Named("url-configure")
    String provideBaseURL1() {
        return BuildConfig.BASE_URL;
    }

    @Singleton
    @Provides
    @Named("url-data")
    String provideBaseURL2(Validator validator, SessionManager sessionManager) {
        return validator.getUrlData(sessionManager);
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(TrustHtppS trustHtppS, @Named("ok-1") OkHttpClient.Builder client, @Named("url-configure") String baseUrl) {

        trustHtppS.intializeCertificate();
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
