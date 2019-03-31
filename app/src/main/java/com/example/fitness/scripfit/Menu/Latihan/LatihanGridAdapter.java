package com.example.fitness.scripfit.Menu.Latihan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.Latihan.View.LatihanDetail;
import com.example.fitness.scripfit.Menu.Latihan.View.LatihanDetailSub;
import com.example.fitness.scripfit.R;

import java.util.List;

public class LatihanGridAdapter extends RecyclerView.Adapter<LatihanGridAdapter.ViewHolder> {
    Context context;
    List<LatihanModel> mData;

    public LatihanGridAdapter(Context context, List<LatihanModel> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v;
        final int data = mData.get(i).getId();
        v= LayoutInflater.from(context).inflate(R.layout.latihan_item_grid, parent, false);
        final ViewHolder vHolder = new ViewHolder(v);
        vHolder.cv_latihanGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LatihanDetailSub.class);
                intent.putExtra("id", data);
                context.startActivity(intent);
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.tv_latihanGrid.setText(mData.get(i).getJudul());
        Glide.with(context)
                .load(mData.get(i).getLinkImage())
                .into(viewHolder.iv_latihanGrid);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_latihanGrid;
        ImageView iv_latihanGrid;
        CardView cv_latihanGrid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv_latihanGrid = (CardView) itemView.findViewById(R.id.cv_latihanGrid);
            tv_latihanGrid = (TextView) itemView.findViewById(R.id.tv_latihanGrid);
            iv_latihanGrid = (ImageView) itemView.findViewById(R.id.iv_latihanGrid);
        }
    }
}
