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
        final List<RencanaModel> dataRecentOpen = new ArrayList<>();
        final List<RencanaModel> dataList1 = new ArrayList<>();
        final List<RencanaModel> dataList2 = new ArrayList<>();
        mService = Common.getAPIService();

        Call<RencanaMainModel> call = mService.getRencana();

        call.enqueue(new Callback<RencanaMainModel>() {
            @Override
            public void onResponse(Call<RencanaMainModel> call, Response<RencanaMainModel> response) {
                try {
                    List<RencanaModel> lists = response.body().getRencana();
                    for(RencanaModel listModel : lists){
                        Log.i("status", listModel.getOpen().toString());


                        if(listModel.getJudul().contains("list1")){
                            dataList1.add(listModel);
                        }
                        else if(listModel.getJudul().contains("list2")){
                            dataList2.add(listModel);
                        }

                        if(listModel.getOpen() == 1){
                            dataRecentOpen.add(listModel);
                        }
                    }
                    view.resultRecentOpen(dataRecentOpen);
                    view.resultList1(dataList1);
                    view.resultList2(dataList2);
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<RencanaMainModel> call, Throwable t) {
                view.showErrorMessage(t.toString());
            }
        });
    }

    public void getDataDetail(final String judul){
        final List<RencanaModel> dataDetail = new ArrayList<>();
        mService = Common.getAPIService();

        Call<RencanaMainModel> call = mService.getRencana();

        call.enqueue(new Callback<RencanaMainModel>() {
            @Override
            public void onResponse(Call<RencanaMainModel> call, Response<RencanaMainModel> response) {
                try {
                    List<RencanaModel> lists = response.body().getRencana();
                    for(RencanaModel listModel : lists){
                        if(listModel.getJudul().contains(judul)){
                            dataDetail.add(listModel);
                        }
                    }
                    view.resultDataDetail(dataDetail);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<RencanaMainModel> call, Throwable t) {
                view.showErrorMessage(t.toString());
            }
        });
    }

    public void getDataById(final int id){
        final List<RencanaModel> dataId = new ArrayList<>();
        mService = Common.getAPIService();

        Call<RencanaMainModel> call = mService.getRencana();

        call.enqueue(new Callback<RencanaMainModel>() {
            @Override
            public void onResponse(Call<RencanaMainModel> call, Response<RencanaMainModel> response) {
                try {
                    List<RencanaModel> lists = response.body().getRencana();
                    for(RencanaModel listModel : lists){
                        if(listModel.getId() == id){
                            dataId.add(listModel);
                        }

                    }
                    view.resultDataDetail(dataId);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<RencanaMainModel> call, Throwable t) {
                view.showErrorMessage(t.toString());
            }
        });
    }


    public interface View {

        void resultRecentOpen(List<RencanaModel> data);

        void resultList1(List<RencanaModel> data);

        void resultList2(List<RencanaModel> data);

        void showErrorMessage(String errorMessage);

        void resultDataDetail(List<RencanaModel> data);
    }
}
