package com.example.fitness.scripfit.Menu.RencanaLatihan.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Presenter.RencanaPresenter;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;

public class RencanaLatihanSub extends AppCompatActivity implements RencanaPresenter.View {
    int id;
    TextView tv_penjelasan;
    TextView tv_durasi;
    TextView tv_hariPerMinggu;
    TextView tv_senin;
    TextView tv_selasa;
    TextView tv_rabu;
    TextView tv_kamis;
    TextView tv_jumat;
    TextView tv_sabtu;
    TextView tv_minggu;
    LinearLayout linear_penjelasan;
    RencanaPresenter rencanaPresenter;
    List<RencanaModel> dataDetail = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rencana_latihan_sub);

        tv_penjelasan = (TextView)findViewById(R.id.tv_penjelasan);
        tv_durasi = (TextView)findViewById(R.id.tv_durasi);
        tv_hariPerMinggu = (TextView)findViewById(R.id.tv_hariperminggu);
        tv_senin = (TextView)findViewById(R.id.tv_senin);
        tv_selasa = (TextView)findViewById(R.id.tv_selasa);
        tv_rabu = (TextView)findViewById(R.id.tv_rabu);
        tv_kamis = (TextView)findViewById(R.id.tv_kamis);
        tv_jumat = (TextView)findViewById(R.id.tv_jumat);
        tv_sabtu = (TextView)findViewById(R.id.tv_sabtu);
        tv_minggu = (TextView)findViewById(R.id.tv_minggu);
        linear_penjelasan = (LinearLayout)findViewById(R.id.linear_penjelasan);
        rencanaPresenter = new RencanaPresenter(this);
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

        rencanaPresenter.getDataById(id);

        linear_penjelasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(getApplicationContext(), RencanaLatihanSubDetail.class);
                data.putExtra("id", id);
                startActivity(data);
            }
        });
    }

    public void setText(){
        for(RencanaModel rencanaModel : dataDetail){
            tv_penjelasan.setText(rencanaModel.getSubketerangan());
            tv_durasi.setText(rencanaModel.getDurasi());
            tv_hariPerMinggu.setText(rencanaModel.getHari().toString());
            tv_senin.setText(rencanaModel.getSenin());
            tv_selasa.setText(rencanaModel.getSelasa());
            tv_rabu.setText(rencanaModel.getRabu());
            tv_kamis.setText(rencanaModel.getKamis());
            tv_jumat.setText(rencanaModel.getJumat());
            tv_sabtu.setText(rencanaModel.getSabtu());
            tv_minggu.setText(rencanaModel.getMinggu());
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
        Log.e("Error", errorMessage);
    }

    @Override
    public void resultDataDetail(List<RencanaModel> data) {
        dataDetail = data;
        setText();
    }
}
