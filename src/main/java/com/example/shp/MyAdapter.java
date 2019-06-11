package com.example.shp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Context context;
    List<Upload> uploads;

    public MyAdapter(Context context, List<Upload> uploads) {
        this.uploads = uploads;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Upload upload = uploads.get(position);

        holder.textViewName.setText(upload.getName());
        holder.textViewAddress.setText(upload.getAddress());
        holder.textViewAge.setText(upload.getAge());

        holder.textViewMobileno.setText(upload.getMobileno());
        holder.textViewBloodgroup.setText(upload.getBloodgroup());
        holder.textViewTime.setText(upload.getTime());


    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewBloodgroup;
        public TextView textViewAge;
        public TextView textViewAddress;
        public TextView textViewTime;
        public TextView textViewMobileno;
        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            textViewBloodgroup = (TextView) itemView.findViewById(R.id.textViewBloodgroup);
            textViewAge = (TextView) itemView.findViewById(R.id.textViewAge);
            textViewAddress = (TextView) itemView.findViewById(R.id.textViewAddress);
            textViewMobileno = (TextView) itemView.findViewById(R.id.textViewMobileno);
            textViewTime = (TextView) itemView.findViewById(R.id.textViewTime);

        }
    }
}