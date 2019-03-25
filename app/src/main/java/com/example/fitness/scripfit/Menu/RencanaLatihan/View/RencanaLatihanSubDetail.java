package com.example.fitness.scripfit.Menu.RencanaLatihan.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Presenter.RencanaPresenter;
import com.example.fitness.scripfit.R;

import java.util.List;

public class RencanaLatihanSubDetail extends AppCompatActivity implements RencanaPresenter.View {
    TextView tv_keteranganDetail;
    TextView tv_tujuanUtama;
    TextView tv_tingkatPelatihan;
    TextView tv_waktuLatihan;
    TextView tv_peralatan;
    TextView tv_penulis;
    TextView tv_sumber;

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
    public void resultList3(List<RencanaModel> data) {

    }

    @Override
    public void resultList4(List<RencanaModel> data) {

    }

    @Override
    public void resultList5(List<RencanaModel> data) {

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    public void resultDataDetail(List<RencanaModel> data) {

    }
}
