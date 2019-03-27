package com.example.fitness.scripfit.Menu.Blog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fitness.scripfit.Menu.Blog.Model.BlogModel;
import com.example.fitness.scripfit.R;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.ViewHolder>{
    List<BlogModel> mData;
    private LayoutInflater mInflater;
    Context context;

    public BlogAdapter(Context context, List<BlogModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v;
        v= mInflater.inflate(R.layout.blog_item, parent, false);
        final ViewHolder vHolder = new ViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtJudul.setText(mData.get(i).getJudul());
        viewHolder.txtKeterangan.setText(mData.get(i).getKeterangan());
        Glide.with(context)
                .load(mData.get(i).getLinkImage())
                .into(viewHolder.iv_blogItem);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //ViewHolder class
    //TextView and ImageView holders are binded with relevant views in item of recyclerview.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtJudul;
        public TextView txtKeterangan;
        public ImageView iv_blogItem;
        public ViewHolder(View v) {
            super(v);

            txtJudul = (TextView) v.findViewById(R.id.tv_judul);
            txtKeterangan = (TextView) v.findViewById(R.id.tv_keterangan);
            iv_blogItem = (ImageView) v.findViewById(R.id.iv_blogItem);
        }
    }
}
