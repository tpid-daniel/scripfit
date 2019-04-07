package com.example.fitness.scripfit.Network;


public class Common {
    private static final String BASE_URL="https://vhost.ti.ukdw.ac.id/~ricky/api.php/";

    public static Api getAPIService(){
        return RetrofitClient.getClient(BASE_URL).create(Api.class);
    }
}
