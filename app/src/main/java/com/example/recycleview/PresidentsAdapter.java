package com.example.recycleview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import model.President;

public class PresidentsAdapter extends RecyclerView.Adapter<PresidentsAdapter.ViewHolder>{

    List<President> presidentList  ;
    Context context;

    public PresidentsAdapter(List<President> presidentList, Context context) {
        this.presidentList = presidentList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.president_item, parent, false);
    ViewHolder viewHolder = new ViewHolder(view);

    return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull PresidentsAdapter.ViewHolder holder, int position) {
        holder.pr_name.setText(presidentList.get(position).getName());
        holder.pr_country.setText(presidentList.get(position).getCountry());
        Glide.with(this.context).load(presidentList.get(position).getImageUrl()).into(holder.pr_img);
        holder.pr_dateElected.setText(presidentList.get(position).getDateElection());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( context, President_Form.class );
                intent.putExtra("id", presidentList.get(position).getId());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return presidentList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {

        ImageView pr_img;
        TextView pr_name;
        TextView pr_country;
        TextView pr_dateElected;
        ConstraintLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pr_img = itemView.findViewById(R.id.item_image);
            pr_name = itemView.findViewById(R.id.item_name);
            pr_country = itemView.findViewById(R.id.item_country);
            parentLayout = itemView.findViewById(R.id.item_layout);
            pr_dateElected = itemView.findViewById(R.id.dateElected);
        }
    }
}
