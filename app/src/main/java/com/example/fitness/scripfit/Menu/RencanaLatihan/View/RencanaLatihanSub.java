package com.example.fitness.scripfit.Menu.RencanaLatihan.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaDayModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Presenter.RencanaPresenter;
import com.example.fitness.scripfit.Preferences;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;

public class RencanaLatihanSub extends AppCompatActivity implements RencanaPresenter.View {
    int id;
    TextView tv_judulRencanaSub;
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
    Button btn_start;
    LinearLayout linear_penjelasan;
    CardView ll_senin;
    CardView ll_selasa;
    CardView ll_rabu;
    CardView ll_kamis;
    CardView ll_jumat;
    CardView ll_sabtu;
    CardView ll_minggu;
    RencanaPresenter rencanaPresenter;
    List<RencanaModel> dataDetail = new ArrayList<>();
    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rencana_latihan_sub);

        tv_judulRencanaSub = (TextView)findViewById(R.id.tv_judulRencanaSub);
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
        btn_start = (Button) findViewById(R.id.btn_Start);
        linear_penjelasan = (LinearLayout)findViewById(R.id.linear_penjelasan);
        ll_senin = (CardView) findViewById(R.id.ll_senin);
        ll_selasa = (CardView) findViewById(R.id.ll_selasa);
        ll_rabu = (CardView) findViewById(R.id.ll_rabu);
        ll_kamis = (CardView) findViewById(R.id.ll_kamis);
        ll_jumat = (CardView) findViewById(R.id.ll_jumat);
        ll_sabtu = (CardView) findViewById(R.id.ll_sabtu);
        ll_minggu = (CardView) findViewById(R.id.ll_minggu);

        rencanaPresenter = new RencanaPresenter(this, getApplicationContext());
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
        preferences = new Preferences(getApplicationContext());

        linear_penjelasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(getApplicationContext(), RencanaLatihanSubDetail.class);
                data.putExtra("id", id);
                startActivity(data);
            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.savePref(String.valueOf(id));
                Toast.makeText(getApplicationContext(), "Memulai latihan", Toast.LENGTH_SHORT).show();
            }
        });

        ll_senin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tv_senin.getText().toString().contains("Istirahat")){
                    Intent data = new Intent(getApplicationContext(), RencanaLatihanSubDay.class);
                    data.putExtra("id", id);
                    data.putExtra("day", 1);
                    startActivity(data);
                }
            }
        });

        ll_selasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tv_selasa.getText().toString().contains("Istirahat")){
                    Intent data = new Intent(getApplicationContext(), RencanaLatihanSubDay.class);
                    data.putExtra("id", id);
                    data.putExtra("day", 2);
                    startActivity(data);
                }
            }
        });

        ll_rabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tv_rabu.getText().toString().contains("Istirahat")){
                    Intent data = new Intent(getApplicationContext(), RencanaLatihanSubDay.class);
                    data.putExtra("id", id);
                    data.putExtra("day", 3);
                    startActivity(data);
                }
            }
        });

        ll_kamis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tv_kamis.getText().toString().contains("Istirahat")){
                    Intent data = new Intent(getApplicationContext(), RencanaLatihanSubDay.class);
                    data.putExtra("id", id);
                    data.putExtra("day", 4);
                    startActivity(data);
                }

            }
        });

        ll_jumat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tv_jumat.getText().toString().contains("Istirahat")){
                    Intent data = new Intent(getApplicationContext(), RencanaLatihanSubDay.class);
                    data.putExtra("id", id);
                    data.putExtra("day", 5);
                    startActivity(data);
                }

            }
        });

        ll_sabtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tv_sabtu.getText().toString().contains("Istirahat")){
                    Intent data = new Intent(getApplicationContext(), RencanaLatihanSubDay.class);
                    data.putExtra("id", id);
                    data.putExtra("day", 6);
                    startActivity(data);
                }

            }
        });

        ll_minggu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tv_minggu.getText().toString().contains("Istirahat")){
                    Intent data = new Intent(getApplicationContext(), RencanaLatihanSubDay.class);
                    data.putExtra("id", id);
                    data.putExtra("day", 7);
                    startActivity(data);
                }

            }
        });
    }

    public void setText(){
        for(RencanaModel rencanaModel : dataDetail){
            tv_judulRencanaSub.setText(rencanaModel.getJudulketerangan());
            tv_penjelasan.setText(rencanaModel.getSubketerangan());
            tv_durasi.setText(rencanaModel.getDurasi());
            tv_hariPerMinggu.setText(rencanaModel.getHari().toString());
            if(rencanaModel.getSenin().isEmpty()){
                tv_senin.setText("Istirahat");
            }else{
                tv_senin.setText(rencanaModel.getSenin());
            }
            if(rencanaModel.getSelasa().isEmpty()){
                tv_selasa.setText("Istirahat");
            }else{
                tv_selasa.setText(rencanaModel.getSelasa());
            }
            if(rencanaModel.getRabu().isEmpty()){
                tv_rabu.setText("Istirahat");
            }else{
                tv_rabu.setText(rencanaModel.getRabu());
            }
            if(rencanaModel.getKamis().isEmpty()){
                tv_kamis.setText("Istirahat");
            }else {
                tv_kamis.setText(rencanaModel.getKamis());
            }
            if(rencanaModel.getJumat().isEmpty()){
                tv_jumat.setText("Istirahat");
            }else {
                tv_jumat.setText(rencanaModel.getJumat());
            }
            if(rencanaModel.getSabtu().isEmpty()){
                tv_sabtu.setText("Istirahat");
            }else {
                tv_sabtu.setText(rencanaModel.getSabtu());
            }
            if(rencanaModel.getMinggu().isEmpty()){
                tv_minggu.setText("Istirahat");
            }else {
                tv_minggu.setText(rencanaModel.getMinggu());
            }

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
        Log.e("Error", errorMessage);
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
