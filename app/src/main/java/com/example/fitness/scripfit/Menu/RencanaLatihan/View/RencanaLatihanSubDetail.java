package com.example.fitness.scripfit.Menu.RencanaLatihan.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Presenter.RencanaPresenter;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;

public class RencanaLatihanSubDetail extends AppCompatActivity implements RencanaPresenter.View {
    TextView tv_keteranganDetail;
    TextView tv_tujuanUtama;
    TextView tv_tingkatPelatihan;
    TextView tv_waktuLatihan;
    TextView tv_peralatan;
    TextView tv_penulis;
    TextView tv_sumber;
    int id;
    List<RencanaModel> dataDetail = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rencana_latihan_sub_detail);

        tv_keteranganDetail = (TextView)findViewById(R.id.tv_keteranganDetail);
        tv_tujuanUtama = (TextView)findViewById(R.id.tv_tujuanUtama);
        tv_tingkatPelatihan = (TextView)findViewById(R.id.tv_tingkatPelatihan);
        tv_waktuLatihan = (TextView)findViewById(R.id.tv_waktuLatihan);
        tv_peralatan = (TextView)findViewById(R.id.tv_peralatan);
        tv_penulis = (TextView)findViewById(R.id.tv_penulis);
        tv_sumber = (TextView)findViewById(R.id.tv_sumber);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        getSupportActionBar().setTitle("NEWS");

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_action_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        RencanaPresenter rencanaPresenter = new RencanaPresenter(this, getApplicationContext());
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        rencanaPresenter.getDataById(id);
    }

    public void setText(){
        for(RencanaModel rencanaModel : dataDetail){
            tv_keteranganDetail.setText(rencanaModel.getSubketerangandetail());
            tv_tujuanUtama.setText(rencanaModel.getTujuanutama());
            tv_tingkatPelatihan.setText(rencanaModel.getTingkatpelatihan());
            tv_waktuLatihan.setText(rencanaModel.getWaktuperlatihan());
            tv_peralatan.setText(rencanaModel.getPeralatan());
            tv_penulis.setText(rencanaModel.getPenulis());
            tv_sumber.setText(rencanaModel.getSumber());
        }
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

    }

    @Override
    public void resultDataDetail(List<RencanaModel> data) {
        dataDetail = data;
        setText();
    }

    @Override
    public void resultDataDay(List<LatihanModel> data) {

    }
}
