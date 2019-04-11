package com.example.fitness.scripfit.Menu.RencanaLatihan.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.ListRencanaAdapter;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaDayModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Presenter.RencanaPresenter;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;

public class RencanaLatihanDetail extends AppCompatActivity implements RencanaPresenter.View {
    RecyclerView rv_rencanaDetail;
    List<RencanaModel> dataDetail = new ArrayList<>();
    String judul;
    RencanaPresenter rencanaPresenter;
    ListRencanaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rencana_latihan_detail);
        rv_rencanaDetail = (RecyclerView) findViewById(R.id.rv_rencanaDetail);

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
        judul = intent.getStringExtra("judul");

        rencanaPresenter = new RencanaPresenter(this, getApplicationContext());
        rencanaPresenter.getDataDetail(judul);
    }

    public void list(){
        adapter = new ListRencanaAdapter(RencanaLatihanDetail.this, dataDetail, 1);

        rv_rencanaDetail.setLayoutManager(new LinearLayoutManager(RencanaLatihanDetail.this, LinearLayoutManager.VERTICAL, false));

        rv_rencanaDetail.setAdapter(adapter);
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
        Toast.makeText(RencanaLatihanDetail.this, errorMessage, Toast.LENGTH_SHORT).show();
        Log.i("errorRencana", errorMessage);
    }

    @Override
    public void resultDataDetail(List<RencanaModel> data) {
        dataDetail = data;
        list();
    }

    @Override
    public void resultDataDay(List<LatihanModel> data) {

    }

}
