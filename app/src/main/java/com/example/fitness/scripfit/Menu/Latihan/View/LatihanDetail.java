package com.example.fitness.scripfit.Menu.Latihan.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.fitness.scripfit.Menu.Latihan.LatihanGridAdapter;
import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.Latihan.Presenter.LatihanPresenter;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;

public class LatihanDetail extends AppCompatActivity implements LatihanPresenter.View {
    RecyclerView rv_latihanDetail;
    String jenis;
    List<LatihanModel> dataDetail = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_detail);

        rv_latihanDetail = (RecyclerView) findViewById(R.id.rv_latihanDetail);

        Intent intent = getIntent();
        jenis = intent.getStringExtra("jenis");

        LatihanPresenter latihanPresenter = new LatihanPresenter(this);
        latihanPresenter.listLatihan(jenis);
    }

    public void getDataLatihan(){
        LatihanGridAdapter adapter = new LatihanGridAdapter(getApplicationContext(), dataDetail);

        rv_latihanDetail.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        rv_latihanDetail.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void resultDataDetail(List<LatihanModel> data) {
        dataDetail = data;
        getDataLatihan();
    }
}
