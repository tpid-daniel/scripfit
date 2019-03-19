package com.example.fitness.scripfit.Menu.Blog;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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
        View rootView = inflater.inflate(R.layout.fragment_blog, container, false);
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
        menu.add(new BlogModel("5 makanan yang membuat anda sehat", "berikut ini merupakan makanan yang membuat anda sehat"));
        menu.add(new BlogModel("5 makanan yang membuat anda sehat", "berikut ini merupakan makanan yang membuat anda sehat"));
        menu.add(new BlogModel("5 makanan yang membuat anda sehat", "berikut ini merupakan makanan yang membuat anda sehat"));
        adapter = new BlogAdapter(getContext(), menu);

        rv_blog.setLayoutManager(new LinearLayoutManager(getActivity()));

        rv_blog.setAdapter(adapter);
    }

}
