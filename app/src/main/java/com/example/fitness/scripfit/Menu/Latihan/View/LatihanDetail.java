package com.example.fitness.scripfit.Menu.Latihan.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.fitness.scripfit.Menu.Latihan.LatihanGridAdapter;
import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.Latihan.Presenter.LatihanPresenter;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class LatihanDetail extends AppCompatActivity implements LatihanPresenter.View {
    RecyclerView rv_latihanDetail;
    String jenis;
    List<LatihanModel> dataDetail = new ArrayList<>();
    LatihanGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_detail);

        rv_latihanDetail = (RecyclerView) findViewById(R.id.rv_latihanDetail);

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
        jenis = intent.getStringExtra("jenis");

        LatihanPresenter latihanPresenter = new LatihanPresenter(this);
        latihanPresenter.listLatihan(jenis);
    }

    public void getDataLatihan(){
        adapter = new LatihanGridAdapter(getApplicationContext(), dataDetail);

        rv_latihanDetail.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));

        rv_latihanDetail.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Inflater.inflate(R.menu.search_latihan, menu);
        MenuItem searchItem = menu.findItem(R.id.latihan_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
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