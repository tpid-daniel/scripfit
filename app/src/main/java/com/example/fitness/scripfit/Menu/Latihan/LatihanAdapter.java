package com.example.fitness.scripfit.Menu.Latihan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitness.scripfit.Menu.Latihan.Model.LatihanModel;
import com.example.fitness.scripfit.Menu.Latihan.View.LatihanDetail;
import com.example.fitness.scripfit.Menu.RencanaLatihan.View.RencanaLatihanSub;
import com.example.fitness.scripfit.R;

import java.util.ArrayList;
import java.util.List;

public class LatihanAdapter extends RecyclerView.Adapter<LatihanAdapter.ViewHolder> implements Filterable {
    List<LatihanModel> mData;
    List<LatihanModel> mDataFull;
    private LayoutInflater mInflater;
    Context context;

    public LatihanAdapter(Context context, List<LatihanModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
        mDataFull = new ArrayList<>(data);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v;
        v= mInflater.inflate(R.layout.latihan_item, parent, false);
        final ViewHolder vHolder = new ViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final String data = mData.get(i).getKeterangan();
        viewHolder.txtMessage.setText(mData.get(i).getKeterangan());
        viewHolder.latihanItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LatihanDetail.class);
                intent.putExtra("jenis", data);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    @Override
    public Filter getFilter() {

        return filterList;
    }

    private Filter filterList = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<LatihanModel> filterListData = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0){
                filterListData.addAll(mDataFull);
            }
            else{
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (LatihanModel item : mDataFull){
                    if(item.getKeterangan().toLowerCase().contains(filterPattern)){
                        filterListData.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterListData;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mData.clear();
            mData.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    //ViewHolder class
    //TextView and ImageView holders are binded with relevant views in item of recyclerview.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtMessage;
        public LinearLayout latihanItem;

        public ViewHolder(View v) {
            super(v);

            txtMessage = (TextView) v.findViewById(R.id.tv_latihanItem);
            latihanItem = (LinearLayout) v.findViewById(R.id.latihanItem);
        }
    }
}
