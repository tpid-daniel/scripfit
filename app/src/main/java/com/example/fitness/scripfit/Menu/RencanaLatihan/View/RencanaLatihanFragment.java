package com.example.fitness.scripfit.Menu.RencanaLatihan.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness.scripfit.Menu.RencanaLatihan.ListRencanaAdapter;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Presenter.RencanaPresenter;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RencanaLatihanFragment extends Fragment implements RencanaPresenter.View {
    RecyclerView rv_recentOpen;
    RecyclerView rv_list1;
    RecyclerView rv_list2;

    ListRencanaAdapter adapter;
    RencanaPresenter rencanaPresenter;
    List<RencanaModel> menuRecentOpen = new ArrayList<>();
    List<RencanaModel> menuList1 = new ArrayList<>();
    List<RencanaModel> menuList2 = new ArrayList<>();
    public RencanaLatihanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rencana_latihan, container, false);
        rv_recentOpen = (RecyclerView) rootView.findViewById(R.id.rv_recentOpen);
        rv_list1 = (RecyclerView) rootView.findViewById(R.id.rv_list1);
        rv_list2 = (RecyclerView) rootView.findViewById(R.id.rv_list2);

        TextView tv_selengkapnya1 = (TextView) rootView.findViewById(R.id.tv_selengkapnya1);
        TextView tv_selengkapnya2 = (TextView) rootView.findViewById(R.id.tv_selengkapnya2);

        rencanaPresenter = new RencanaPresenter(this);
        rencanaPresenter.getListRencana();

        tv_selengkapnya1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(getActivity(), RencanaLatihanDetail.class);
                data.putExtra("judul", "list1");
                getActivity().startActivity(data);
            }
        });

        tv_selengkapnya2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(getActivity(), RencanaLatihanDetail.class);
                data.putExtra("judul", "list2");
                getActivity().startActivity(data);
            }
        });


        return rootView;
    }

    public void onResume() {
        super.onResume();
        listRecentOpen();
        list1();
        list2();
    }

    public void listRecentOpen(){
        adapter = new ListRencanaAdapter(getContext(), menuRecentOpen, 1);

        rv_recentOpen.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rv_recentOpen.setAdapter(adapter);
    }

    public void list1(){
        adapter = new ListRencanaAdapter(getContext(), menuList1, 0);

        rv_list1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rv_list1.setAdapter(adapter);
    }

    public void list2(){
        adapter = new ListRencanaAdapter(getContext(), menuList2, 0);

        rv_list2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rv_list2.setAdapter(adapter);
    }



    @Override
    public void resultRecentOpen(List<RencanaModel> data) {
        menuRecentOpen = data;
        listRecentOpen();
    }

    @Override
    public void resultList1(List<RencanaModel> data) {
        menuList1 = data;
        list1();
    }

    @Override
    public void resultList2(List<RencanaModel> data) {
        menuList2 = data;
        list2();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
        Log.i("errorRencana", errorMessage);
    }

    @Override
    public void resultDataDetail(List<RencanaModel> data) {

    }
}
