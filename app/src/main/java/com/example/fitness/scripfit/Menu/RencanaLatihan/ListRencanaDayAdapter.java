package com.example.fitness.scripfit.Menu.RencanaLatihan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.Latihan.View.LatihanDetailSub;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaDayModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.Menu.RencanaLatihan.View.RencanaLatihanSub;
import com.example.fitness.scripfit.R;

import java.util.List;

public class ListRencanaDayAdapter extends RecyclerView.Adapter<ListRencanaDayAdapter.ViewHolder> {
    List<LatihanModel> mData;
    private LayoutInflater mInflater;
    Context context;

    public ListRencanaDayAdapter(Context context, List<LatihanModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v;
        v = mInflater.inflate(R.layout.item_rencana_day, parent, false);

        final ViewHolder vHolder = new ViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final int data = mData.get(i).getId();
        viewHolder.tv_dayJudul.setText(mData.get(i).getJudul());
        viewHolder.tv_daySet.setText(": "+mData.get(i).getSetNumber().toString());
        viewHolder.tv_dayRepetisi.setText(": "+mData.get(i).getRepetisi());
        Glide.with(context)
                .load(mData.get(i).getLinkImage())
                .into(viewHolder.iv_day);
        viewHolder.cv_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LatihanDetailSub.class);
                intent.putExtra("id", data);
                intent.putExtra("jenis", "rencana");
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //ViewHolder class
    //TextView and ImageView holders are binded with relevant views in item of recyclerview.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_dayJudul;
        public TextView tv_daySet;
        public TextView tv_dayRepetisi;
        public ImageView iv_day;
        public  CardView cv_day;

        public ViewHolder(View v) {
            super(v);
            tv_dayJudul = (TextView) v.findViewById(R.id.tv_dayJudul);
            tv_daySet= (TextView) v.findViewById(R.id.tv_daySet);
            tv_dayRepetisi= (TextView) v.findViewById(R.id.tv_dayRepetisi);
            iv_day = (ImageView) v.findViewById(R.id.iv_day);
            cv_day = (CardView) v.findViewById(R.id.cv_day);
        }
    }
}
