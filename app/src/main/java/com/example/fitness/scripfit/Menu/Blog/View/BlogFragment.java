package com.example.fitness.scripfit.Menu.Blog.View;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fitness.scripfit.Menu.Blog.BlogAdapter;
import com.example.fitness.scripfit.Menu.Blog.Model.BlogModel;
import com.example.fitness.scripfit.Menu.Blog.Presenter.BlogPresenter;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlogFragment extends Fragment implements BlogPresenter.View { //implements interface blogpresenter
    RecyclerView rv_blog;
    BlogAdapter adapter;
    List<BlogModel> menu = new ArrayList<>();
    public BlogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        //kegunaannya view itu agar bisa findviewbyid yang ada di layout
        View rootView = inflater.inflate(R.layout.fragment_blog, container, false);
        Toolbar actionBarToolBar = (Toolbar) rootView.findViewById(R.id.toolbar);
        //pakai appcompat khusus di fragment (harus pakai klo di fragment)
        ((AppCompatActivity)getActivity()).setSupportActionBar(actionBarToolBar);
        rv_blog = (RecyclerView) rootView.findViewById(R.id.rv_blog);
        //cara untuk mengirim ke presenter
        BlogPresenter blogPresenter = new BlogPresenter(this);
        blogPresenter.getListBlog();
        return rootView;
    }

    public void onResume() {
        super.onResume();
        data();
    }

    public void data(){

        adapter = new BlogAdapter(getContext(), menu);

        rv_blog.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv_blog.setAdapter(adapter);

    }

    @Override
    public void showErrorMessage(String errorMessage) {
        try{
            Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void resultDataDetail(List<BlogModel> data) {
        menu = data;
        data();
    }
}
