package com.example.sp1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sp1.Models.Jobs;
import com.example.sp1.R;

import java.util.ArrayList;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.MyViewHolder> {
    Context context;
    ArrayList<Jobs>jobsModel;
    public JobsAdapter(Context context, ArrayList<Jobs>jobsModel) {
        this.context=context;
        this.jobsModel=jobsModel;
    }

    @NonNull
    @Override
    public JobsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.jobs_row, parent, false);
        return new JobsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobsAdapter.MyViewHolder holder, int position) {
    holder.countyName.setText(jobsModel.get(position).getCounty());
    holder.personName.setText(jobsModel.get(position).getPostedBy());
    holder.locationName.setText(jobsModel.get(position).getLocation());
    holder.priceTag.setText(jobsModel.get(position).getPrice());
    holder.imageView.setImageResource(jobsModel.get(position).getImageName());



    }

    @Override
    public int getItemCount() {
        return jobsModel.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView countyName, personName, locationName, priceTag;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_location);
            countyName = itemView.findViewById(R.id.county_title);
            personName = itemView.findViewById(R.id.person_name);
            locationName = itemView.findViewById(R.id.location_name);
            priceTag = itemView.findViewById(R.id.job_price);

        }
    }
}