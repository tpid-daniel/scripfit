package com.example.fitness.scripfit.Menu.RencanaLatihan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fitness.scripfit.Menu.Latihan.LatihanModel;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;

public class ListRencanaAdapter extends RecyclerView.Adapter<ListRencanaAdapter.ViewHolder> {
    List<RencanaModel> mData;
    private LayoutInflater mInflater;
    Context context;

    public ListRencanaAdapter(Context context, List<RencanaModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v;
        v= mInflater.inflate(R.layout.rencana_item, parent, false);
        final ViewHolder vHolder = new ViewHolder(v);
        if(mData.get(i).getStatus() == true){
            vHolder.tvSelengkapnya.setVisibility(View.GONE);
        }
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtJudul.setText(mData.get(i).getJudul());
        viewHolder.txtJudulKeterangan.setText(mData.get(i).getJudulKeterangan());
        viewHolder.txtKeterangan.setText(mData.get(i).getKeterangan());
        Glide.with(context)
                .load(mData.get(i).getLinkImage())
                .into(viewHolder.iv_gambar);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //ViewHolder class
    //TextView and ImageView holders are binded with relevant views in item of recyclerview.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtJudul;
        public TextView txtJudulKeterangan;
        public TextView txtKeterangan;
        public TextView tvSelengkapnya;
        public ImageView iv_gambar;

        public ViewHolder(View v) {
            super(v);

            txtJudul = (TextView) v.findViewById(R.id.tv_judul);
            txtJudulKeterangan = (TextView) v.findViewById(R.id.tv_judulKeterangan);
            txtKeterangan = (TextView) v.findViewById(R.id.tv_keterangan);
            iv_gambar = (ImageView) v.findViewById(R.id.iv_gambarRencana);
            tvSelengkapnya = (TextView) v.findViewById(R.id.tv_selengkapnya);

        }
    }
}
