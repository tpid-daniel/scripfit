package com.example.fitness.scripfit.Menu.Blog.Presenter;

import com.example.fitness.scripfit.Menu.Blog.Model.BlogMainModel;
import com.example.fitness.scripfit.Menu.Blog.Model.BlogModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Network.Api;
import com.example.fitness.scripfit.Network.Common;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogPresenter {

    Api mService;
    private View view;

    public BlogPresenter(View view) {

        this.view = view;
    }

    public void getListBlog(){
        final List<BlogModel> dataBlog = new ArrayList<>();

        mService = Common.getAPIService();

        Call<BlogMainModel> call = mService.getBlog();

        call.enqueue(new Callback<BlogMainModel>() {
            @Override
            public void onResponse(Call<BlogMainModel> call, Response<BlogMainModel> response) {
                try{
                    for(BlogModel blogModel : response.body().getBlog()){
                        dataBlog.add(blogModel);
                    }
                    view.resultDataDetail(dataBlog);
                }
                catch (Exception e){
                    view.showErrorMessage(e.toString());
                }
            }

            @Override
            public void onFailure(Call<BlogMainModel> call, Throwable t) {
                view.showErrorMessage(t.toString());
            }
        });

    }

    public void getListBlogById(final int Id){
        final List<BlogModel> dataBlog = new ArrayList<>();

        mService = Common.getAPIService();

        Call<BlogMainModel> call = mService.getBlog();

        call.enqueue(new Callback<BlogMainModel>() {
            @Override
            public void onResponse(Call<BlogMainModel> call, Response<BlogMainModel> response) {
                try{
                    for(BlogModel blogModel : response.body().getBlog()){
                        if(blogModel.getId().equals(Id)){
                            dataBlog.add(blogModel);
                        }
                    }
                    view.resultDataDetail(dataBlog);
                }
                catch (Exception e){
                    view.showErrorMessage(e.toString());
                }
            }

            @Override
            public void onFailure(Call<BlogMainModel> call, Throwable t) {
                view.showErrorMessage(t.toString());
            }
        });

    }

    public interface View {

        void showErrorMessage(String errorMessage);

        void resultDataDetail(List<BlogModel> data);
    }
}
