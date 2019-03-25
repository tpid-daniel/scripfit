package com.example.fitness.scripfit.Menu.RencanaLatihan.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fitness.scripfit.Menu.RencanaLatihan.Model.RencanaModel;
import com.example.fitness.scripfit.R;

import java.util.List;

public class ListRencanaAdapter extends RecyclerView.Adapter<ListRencanaAdapter.ViewHolder> {
    List<RencanaModel> mData;
    private LayoutInflater mInflater;
    Context context;
    int status = 0;

    public ListRencanaAdapter(Context context, List<RencanaModel> data, int status) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
        this.status = status;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v;
        if(status == 0) {
            v = mInflater.inflate(R.layout.rencana_item, parent, false);
        }
        else{
            v = mInflater.inflate(R.layout.rencana_item_detail, parent, false);
        }
        final ViewHolder vHolder = new ViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtJudulKeterangan.setText(mData.get(i).getJudulketerangan());
        viewHolder.txtKeterangan.setText(mData.get(i).getKeterangan());
        Glide.with(context)
                .load(mData.get(i).getLinkimage())
                .into(viewHolder.iv_gambar);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //ViewHolder class
    //TextView and ImageView holders are binded with relevant views in item of recyclerview.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtJudulKeterangan;
        public TextView txtKeterangan;
        public ImageView iv_gambar;

        public ViewHolder(View v) {
            super(v);
            txtJudulKeterangan = (TextView) v.findViewById(R.id.tv_judulKeterangan);
            txtKeterangan = (TextView) v.findViewById(R.id.tv_keterangan);
            iv_gambar = (ImageView) v.findViewById(R.id.iv_gambarRencana);

        }
    }
}
