package bitgear.mmwa.installation.manholemonitorinstallation.rest;

import android.content.Context;

import bitgear.mmwa.installation.manholemonitorinstallation.network.ConnectivityInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    public static final String BASE_URL = "http://api.manhole.ila.webdev.bitgear.rs/api/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient(Context context) {
        if (retrofit==null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new ConnectivityInterceptor(context))
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
