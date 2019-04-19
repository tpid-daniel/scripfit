package com.example.fitness.scripfit.Menu.Latihan.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitness.scripfit.Menu.Latihan.LatihanAdapter;
import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LatihanFragment extends Fragment {
    //definisikan global agar bisa di panggil di semua method

    RecyclerView rv_latihan;
    //Class latihan adapter dipanggil
    LatihanAdapter adapter;

    public LatihanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        //kegunaan View agar dapat mendefinisikan fungsi yang akan dipakai pada layout tersebut pada fragment ini
        View rootView = inflater.inflate(R.layout.fragment_latihan, container, false);
        //deklarasi fungsi rv di layout fragment_latihan pada fragment LatihanFragment
        rv_latihan = (RecyclerView) rootView.findViewById(R.id.rv_latihan);
        data(); //memanggil fungsi data dibawah

//        Toolbar actionBarToolBar = (Toolbar) rootView.findViewById(R.id.toolbar);
//        ((AppCompatActivity)getActivity()).setSupportActionBar(actionBarToolBar);

        //biar kepanggil di oncreate
        return rootView;
    }


    @Override
    public void onResume() { //ketika app pertama dibuka kan masuk oncreateView tapi setelah ke fragment atau halaman lain maka kalau balik ke LatihanFragment datanya akan hilang.
        super.onResume();
        //agar data tetap ada jika kembali ke fragrment latihan dari halaman lain
        data();
    }

    public void data(){
        //berisi menu2 awal berbentuk list yang akan ditampilkan di recycler view
        //membuat list dengan nama variabel menu
        List<LatihanModel> menu = new ArrayList<>();
        menu.add(new LatihanModel("DADA")); //parameter di dalam class latihan model constructor
        menu.add(new LatihanModel("PUNGGUNG"));
        menu.add(new LatihanModel("BAHU"));
        menu.add(new LatihanModel("TRAPEZIUS"));
        menu.add(new LatihanModel("BISEP"));
        menu.add(new LatihanModel("TRISEP"));
        menu.add(new LatihanModel("PERUT"));
        menu.add(new LatihanModel("BETIS"));
        menu.add(new LatihanModel("PAHA"));
        menu.add(new LatihanModel("CARDIO"));

        //bikin adapter untuk ditampilkan di recycler view
        //adapter untuk mengelola data yang akan ditampilkan di RV
        //getContext konteksnya si fragment untuk dikirimkan ke Latihanadapter agar bisa dikenali
        adapter = new LatihanAdapter(getContext(), menu);

        //mengatur layout mau grid atau linear. contoh yang grid ada di latihan detail
        rv_latihan.setLayoutManager(new LinearLayoutManager(getActivity()));

        //set adapter ke dalam rv (di apply ke dalam Recycler View)
        rv_latihan.setAdapter(adapter);
    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.search_latihan, menu);
//        MenuItem searchItem = menu.findItem(R.id.latihan_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                adapter.getFilter().filter(s);
//                return false;
//            }
//        });
////        return true;
//        super.onCreateOptionsMenu(menu, inflater);
//    }
}
