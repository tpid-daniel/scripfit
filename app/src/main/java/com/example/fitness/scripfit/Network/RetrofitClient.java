package com.example.fitness.scripfit.Network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit=null;

    public static Retrofit getClient(String baseUrl){

        if(retrofit == null){

            // Define the interceptor, add authentication headers
            Interceptor interceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = chain.request().newBuilder().build();
                    return chain.proceed(newRequest);
                }
            };

// Add the interceptor to OkHttpClient
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.interceptors().add(interceptor);
            OkHttpClient client = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}
