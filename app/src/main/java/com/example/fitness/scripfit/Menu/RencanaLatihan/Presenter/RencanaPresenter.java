package com.example.fitness.scripfit.Menu.RencanaLatihan.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaDayMainModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaDayModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaMainModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Network.Api;
import com.example.fitness.scripfit.Network.Common;
import com.example.fitness.scripfit.Preferences;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RencanaPresenter {
    Api mService;
    private View view;
    Context context;
    Preferences preferences;

    public RencanaPresenter(View view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void getListRencana(){
        preferences = new Preferences(context);
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
                        if(preferences.getPref() != null){
                            if(Integer.valueOf(preferences.getPref()) == listModel.getId()){
                                dataRecentOpen.add(listModel);
                            }
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

    public void getDataByIdDay(final int id, final int day){
        final List<RencanaDayModel> data = new ArrayList<>();
        mService = Common.getAPIService();

        Call<RencanaDayMainModel> call = mService.getRencanaDay();

        call.enqueue(new Callback<RencanaDayMainModel>() {
            @Override
            public void onResponse(Call<RencanaDayMainModel> call, Response<RencanaDayMainModel> response) {
                try{

                        for(RencanaDayModel rencanaDayModel : response.body().getRencanaday()){
                            if(rencanaDayModel.getIdRencana().equals(id) && rencanaDayModel.getHari().equals(day)){
                                data.add(rencanaDayModel);
                                Log.i("dayJudulId", rencanaDayModel.getIdRencana().toString());
                                Log.i("dayJudulDay",rencanaDayModel.getJudul());
                            }
                        }
                        view.resultDataDay(data);

                }
                catch (Exception e){
                    view.showErrorMessage(e.toString());
                }
            }

            @Override
            public void onFailure(Call<RencanaDayMainModel> call, Throwable t) {
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

        void resultDataDay(List<RencanaDayModel> data);
    }
}
