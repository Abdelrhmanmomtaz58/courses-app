package com.momtaz.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    ArrayList<CourseDomain> items;
    DecimalFormat formatter;
    Context context;

    public CourseAdapter(ArrayList<CourseDomain> items) {
        this.items = items;
        formatter = new DecimalFormat("###,###,###,###,##");
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder,parent,false);
        context =parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.ownerTxt.setText(items.get(position).getOwner());
        holder.priceTxt.setText("$"+formatter.format(items.get(position).getPrice()));

        int drawableResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());
    Glide.with(holder.itemView.getContext()).load(drawableResourceId) .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTxt,ownerTxt,priceTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.titletxt);
            ownerTxt = itemView.findViewById(R.id.ownertxt);
            priceTxt = itemView.findViewById(R.id.pricetxt);
            pic =itemView.findViewById(R.id.pic);
        }
    }
}
