package com.example.fitness.scripfit.Menu.Latihan.Presenter;

import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanMainModel;
import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaMainModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Network.Api;
import com.example.fitness.scripfit.Network.Common;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LatihanPresenter {

    Api mService;
    private View view;

    public LatihanPresenter(View view) {
        this.view = view;
    }

    public void listLatihan(final String jenis){
        final List<LatihanModel> data = new ArrayList<>();
        mService = Common.getAPIService();

        Call<LatihanMainModel> call = mService.getLatihanData();

        call.enqueue(new Callback<LatihanMainModel>() {
            @Override
            public void onResponse(Call<LatihanMainModel> call, Response<LatihanMainModel> response) {
                for(LatihanModel latihanModel : response.body().getLatihan()){
                    if(latihanModel.getJenis().contains(jenis)){
                        data.add(latihanModel);
                    }
                }
                view.resultDataDetail(data);
            }

            @Override
            public void onFailure(Call<LatihanMainModel> call, Throwable t) {
                view.showErrorMessage(t.toString());
            }
        });
    }

    public interface View {

        void showErrorMessage(String errorMessage);

        void resultDataDetail(List<LatihanModel> data);
    }
}
