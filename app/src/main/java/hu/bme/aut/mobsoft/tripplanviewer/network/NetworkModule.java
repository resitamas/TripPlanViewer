package hu.bme.aut.mobsoft.tripplanviewer.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.tripplanviewer.utils.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Resi Tamas on 04/05/2017.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }


    @Provides
    @Singleton
    public TripApi provideTripApi(Retrofit retrofit){
        return retrofit.create(TripApi.class);
    }


}
