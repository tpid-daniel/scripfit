package com.example.fitness.scripfit.Network;

import com.example.fitness.scripfit.Menu.Blog.Model.BlogMainModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaMainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("rencana?transform=1")
    Call<RencanaMainModel> getRencana();

    @GET("blog?transform=1")
    Call<BlogMainModel> getBlog();
}
