package com.example.fitness.scripfit.Menu.Latihan;


import android.app.ActionBar;
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

import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LatihanFragment extends Fragment {
    RecyclerView rv_latihan;
    LatihanAdapter adapter;

    public LatihanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_latihan, container, false);
        rv_latihan = (RecyclerView) rootView.findViewById(R.id.rv_latihan);
        data();

        Toolbar actionBarToolBar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(actionBarToolBar);

        return rootView;
    }

    public void onResume() {
        super.onResume();
        data();
    }

    public void data(){
        List<LatihanModel> menu;
        menu = new ArrayList<>();
        menu.add(new LatihanModel("CARDIO"));
        menu.add(new LatihanModel("PUNGGUNG"));
        menu.add(new LatihanModel("BISEP"));
        menu.add(new LatihanModel("BETIS"));
        menu.add(new LatihanModel("DADA"));
        menu.add(new LatihanModel("LENGAN BAWAH"));
        menu.add(new LatihanModel("KAKI"));
        menu.add(new LatihanModel("BAHU"));

        adapter = new LatihanAdapter(getContext(), menu);

        rv_latihan.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv_latihan.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_latihan, menu);
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
//        return true;
        super.onCreateOptionsMenu(menu, inflater);
    }
}
