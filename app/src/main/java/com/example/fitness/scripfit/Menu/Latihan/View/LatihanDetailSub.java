package com.example.fitness.scripfit.Menu.Latihan.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fitness.scripfit.Menu.Latihan.Presenter.LatihanPresenter;
import com.example.fitness.scripfit.R;

public class LatihanDetailSub extends AppCompatActivity implements LatihanPresenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_detail_sub);


    }
}
