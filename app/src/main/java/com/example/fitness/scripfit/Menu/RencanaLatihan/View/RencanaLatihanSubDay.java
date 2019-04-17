package com.example.fitness.scripfit.Menu.RencanaLatihan.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.ListRencanaDayAdapter;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Presenter.RencanaPresenter;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;

public class RencanaLatihanSubDay extends AppCompatActivity implements RencanaPresenter.View {
    RecyclerView rv_rencanaSubDay;
    ListRencanaDayAdapter adapter;
    List<LatihanModel> menuDay = new ArrayList<>();
    RencanaPresenter rencanaPresenter;
    int id;
    int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rencana_latihan_sub_day);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        getSupportActionBar().setTitle("NEWS");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        day = intent.getIntExtra("day", 0);

        rencanaPresenter = new RencanaPresenter(this, getApplicationContext());

        rencanaPresenter.getDataByIdDay(id, day);

        rv_rencanaSubDay = (RecyclerView) findViewById(R.id.rv_rencanaSubDay);
    }

    public void listDay(){
        adapter = new ListRencanaDayAdapter(getApplicationContext(), menuDay);

        rv_rencanaSubDay.setLayoutManager(new LinearLayoutManager(getApplication(), LinearLayoutManager.VERTICAL, false));

        rv_rencanaSubDay.setAdapter(adapter);
    }

    @Override
    public void resultRecentOpen(List<RencanaModel> data) {

    }

    @Override
    public void resultList1(List<RencanaModel> data) {

    }

    @Override
    public void resultList2(List<RencanaModel> data) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Log.i("ErrorSubDay", errorMessage);
    }

    @Override
    public void resultDataDetail(List<RencanaModel> data) {

    }

    @Override
    public void resultDataDay(List<LatihanModel> data) {
        menuDay = data;
        listDay();
    }
}
