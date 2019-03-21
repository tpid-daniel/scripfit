package com.example.fitness.scripfit.Menu.RencanaLatihan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Presenter.RencanaPresenter;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RencanaLatihanFragment extends Fragment implements RencanaPresenter.View {
    RecyclerView rv_list1;
    RecyclerView rv_list2;
    RecyclerView rv_list3;
    RecyclerView rv_list4;
    RecyclerView rv_list5;
    ListRencanaAdapter adapter;
    RencanaPresenter rencanaPresenter;
    List<RencanaModel> menu = new ArrayList<>();
    public RencanaLatihanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rencana_latihan, container, false);
        rv_list1 = (RecyclerView) rootView.findViewById(R.id.rv_list1);
        rv_list2 = (RecyclerView) rootView.findViewById(R.id.rv_list2);
        rv_list3 = (RecyclerView) rootView.findViewById(R.id.rv_list3);
        rv_list4 = (RecyclerView) rootView.findViewById(R.id.rv_list4);
        rv_list5 = (RecyclerView) rootView.findViewById(R.id.rv_list5);
        rencanaPresenter = new RencanaPresenter(this);
        rencanaPresenter.getListRencana();
        return rootView;
    }

    public void onResume() {
        super.onResume();
        list1();
        list2();
        list3();
        list4();
        list5();
    }

    public void list1(){
        adapter = new ListRencanaAdapter(getContext(), menu);

        rv_list1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rv_list1.setAdapter(adapter);
    }

    public void list2(){
        adapter = new ListRencanaAdapter(getContext(), menu);

        rv_list2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rv_list2.setAdapter(adapter);
    }

    public void list3(){
        adapter = new ListRencanaAdapter(getContext(), menu);

        rv_list3.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rv_list3.setAdapter(adapter);
    }

    public void list4(){
        adapter = new ListRencanaAdapter(getContext(), menu);

        rv_list4.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rv_list4.setAdapter(adapter);
    }

    public void list5(){
        adapter = new ListRencanaAdapter(getContext(), menu);

        rv_list5.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        rv_list5.setAdapter(adapter);
    }

    @Override
    public void resultListRencana(List<RencanaModel> data) {
        menu = data;
        list1();
        list2();
        list3();
        list4();
        list5();
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
        Log.i("errorRencana", errorMessage);
    }
}
