package com.example.fitness.scripfit.Menu.RencanaLatihan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitness.scripfit.Menu.Blog.BlogAdapter;
import com.example.fitness.scripfit.Menu.Blog.BlogModel;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RencanaLatihanFragment extends Fragment {
    RecyclerView rv_listRencana;
    RecyclerView rv_recentOpen;
    ListRencanaAdapter adapter;

    public RencanaLatihanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rencana_latihan, container, false);
        rv_listRencana = (RecyclerView) rootView.findViewById(R.id.rv_listRencana);
        rv_recentOpen = (RecyclerView) rootView.findViewById(R.id.rv_recentOpen);
        dataRecent();
        data();

        return rootView;
    }

    public void onResume() {
        super.onResume();
        data();
        dataRecent();
    }

    public void data(){
        List<RencanaModel> menu;
        menu = new ArrayList<>();
        menu.add(new RencanaModel("Pembentukan Otot", "Program Pembentukan Masa Otot", "Pemula || 10 minggu", "https://www.t-nation.com/system/publishing/articles/10005529/original/6-Reasons-You-Should-Never-Open-a-Gym.png?1509471214", false));
        menu.add(new RencanaModel("Pembentukan Otot", "Program Pembentukan Masa Otot", "Pemula || 10 minggu", "https://www.t-nation.com/system/publishing/articles/10005529/original/6-Reasons-You-Should-Never-Open-a-Gym.png?1509471214", false));
        menu.add(new RencanaModel("Pembentukan Otot", "Program Pembentukan Masa Otot", "Pemula || 10 minggu", "https://www.t-nation.com/system/publishing/articles/10005529/original/6-Reasons-You-Should-Never-Open-a-Gym.png?1509471214", false));
        adapter = new ListRencanaAdapter(getContext(), menu);

        rv_listRencana.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv_listRencana.setAdapter(adapter);
    }

    public void dataRecent(){
        List<RencanaModel> menu;
        menu = new ArrayList<>();
        menu.add(new RencanaModel("Pembentukan Otot1", "Program Pembentukan Masa Otot", "Pemula || 10 minggu", "https://www.t-nation.com/system/publishing/articles/10005529/original/6-Reasons-You-Should-Never-Open-a-Gym.png?1509471214", true));
        menu.add(new RencanaModel("Pembentukan Otot2", "Program Pembentukan Masa Otot", "Pemula || 10 minggu", "https://www.t-nation.com/system/publishing/articles/10005529/original/6-Reasons-You-Should-Never-Open-a-Gym.png?1509471214", true));
        menu.add(new RencanaModel("Pembentukan Otot3", "Program Pembentukan Masa Otot", "Pemula || 10 minggu", "https://www.t-nation.com/system/publishing/articles/10005529/original/6-Reasons-You-Should-Never-Open-a-Gym.png?1509471214", true));
        adapter = new ListRencanaAdapter(getContext(), menu);

        rv_recentOpen.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rv_recentOpen.setAdapter(adapter);
    }

}
