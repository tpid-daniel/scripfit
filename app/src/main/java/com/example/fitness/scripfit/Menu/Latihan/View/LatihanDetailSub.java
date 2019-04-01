package com.example.fitness.scripfit.Menu.Latihan.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.Latihan.Presenter.LatihanPresenter;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;

public class LatihanDetailSub extends AppCompatActivity implements LatihanPresenter.View {
    int id;
    TextView tv_judulLatihanSub;
    TextView tv_tingkatLatihanSub;
    TextView tv_peralatanLatihanSub;
    ImageView iv_bagianOtotLatihanSub;
    TextView tv_petunjukLatihanSub;
    List<LatihanModel> mData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_detail_sub);

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

        tv_judulLatihanSub = (TextView) findViewById(R.id.tv_judulLatihanSub);
        tv_tingkatLatihanSub = (TextView) findViewById(R.id.tv_tingkatLatihanSub);
        tv_peralatanLatihanSub = (TextView) findViewById(R.id.tv_peralatanLatihanSub);
        iv_bagianOtotLatihanSub = (ImageView) findViewById(R.id.iv_bagianOtotLatihanSub);
        tv_petunjukLatihanSub = (TextView) findViewById(R.id.tv_petunjukLatihanSub);

        LatihanPresenter latihanPresenter = new LatihanPresenter(this);
        latihanPresenter.listLatihanById(id);
    }

    public void getText(){
        for(LatihanModel latihanModel : mData){
            tv_judulLatihanSub.setText(latihanModel.getJudul());
            tv_tingkatLatihanSub.setText("Tingkat : "+latihanModel.getTingkat());
            tv_peralatanLatihanSub.setText("Peralatan : "+latihanModel.getPeralatan());
            tv_petunjukLatihanSub.setText(latihanModel.getPetunjuk());
            Glide.with(getApplicationContext())
                    .load(latihanModel.getBagianOtot())
                    .into(iv_bagianOtotLatihanSub);
        }

    }

    @Override
    public void showErrorMessage(String errorMessage) {

    }

    @Override
    public void resultDataDetail(List<LatihanModel> data) {
        mData = data;
        getText();
    }
}
