package com.example.fitness.scripfit.Menu.RencanaLatihan.Presenter;

import android.util.Log;

import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaMainModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Network.Api;
import com.example.fitness.scripfit.Network.Common;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RencanaPresenter {
    Api mService;
    private View view;

    public RencanaPresenter(View view) {
        this.view = view;
    }

    public void getListRencana(){
        final List<RencanaModel> menu = new ArrayList<>();
        mService = Common.getAPIService();

        Call<RencanaMainModel> call = mService.getRencana();

        call.enqueue(new Callback<RencanaMainModel>() {
            @Override
            public void onResponse(Call<RencanaMainModel> call, Response<RencanaMainModel> response) {
                List<RencanaModel> lists = response.body().getRencana();
                for(RencanaModel listModel : lists){
                    Log.i("judul", listModel.getJudul());
                    menu.add(listModel);
                }
                view.resultListRencana(menu);
            }

            @Override
            public void onFailure(Call<RencanaMainModel> call, Throwable t) {
                view.showErrorMessage(t.toString());
            }
        });
    }


    public interface View {
        void resultListRencana(List<RencanaModel> data);

        void showErrorMessage(String errorMessage);
    }
}
