package com.example.fitness.scripfit.Menu.Blog;


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

import com.example.fitness.scripfit.Menu.Latihan.LatihanAdapter;
import com.example.fitness.scripfit.Menu.Latihan.LatihanModel;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlogFragment extends Fragment {
    RecyclerView rv_blog;
    BlogAdapter adapter;

    public BlogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_blog, container, false);
        Toolbar actionBarToolBar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(actionBarToolBar);
        rv_blog = (RecyclerView) rootView.findViewById(R.id.rv_blog);
        data();
        return rootView;
    }

    public void onResume() {
        super.onResume();
        data();
    }

    public void data(){
        List<BlogModel> menu;
        menu = new ArrayList<>();
        menu.add(new BlogModel("5 makanan yang membuat anda sehat", "berikut ini merupakan makanan yang membuat anda sehat", "https://cbsnews1.cbsistatic.com/hub/i/2015/08/24/7b3027e3-6c06-4d2f-ba65-8c179c66f50e/istock000039803170medium.jpg"));
        menu.add(new BlogModel("5 makanan yang membuat anda sehat", "berikut ini merupakan makanan yang membuat anda sehat", "https://cbsnews1.cbsistatic.com/hub/i/2015/08/24/7b3027e3-6c06-4d2f-ba65-8c179c66f50e/istock000039803170medium.jpg"));
        menu.add(new BlogModel("5 makanan yang membuat anda sehat", "berikut ini merupakan makanan yang membuat anda sehat", "https://cbsnews1.cbsistatic.com/hub/i/2015/08/24/7b3027e3-6c06-4d2f-ba65-8c179c66f50e/istock000039803170medium.jpg"));

        adapter = new BlogAdapter(getContext(), menu);

        rv_blog.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv_blog.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.history_blog, menu);
        MenuItem historyBlog = menu.findItem(R.id.history_blog);

        historyBlog.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}
