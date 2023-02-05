package com.kaz.kazkoreanapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.kaz.kazkoreanapp.activities.ProductDetailsActivity;
import com.kaz.kazkoreanapp.R;
import com.kaz.kazkoreanapp.model.DetailedModel;

import java.util.List;

public class DetailedAdapter extends RecyclerView.Adapter<DetailedAdapter.DetailedViewHolder> {

    Context context;
    List<DetailedModel> detailedModels;

    public DetailedAdapter(Context context, List<DetailedModel> detailedModels) {
        this.context = context;
        this.detailedModels = detailedModels;
    }

    @NonNull
    @Override
    public DetailedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_items, parent, false);

        return new DetailedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailedViewHolder holder, final int position) {

        holder.name.setText(detailedModels.get(position).getName());
        holder.description.setText(detailedModels.get(position).getDescription());
        holder.price.setText(detailedModels.get(position).getPrice());
        holder.qty.setText(detailedModels.get(position).getQuantity());
        holder.unit.setText(detailedModels.get(position).getUnit());
        holder.bg.setBackgroundResource(detailedModels.get(position).getImageUrl());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(context, ProductDetailsActivity.class);
                i.putExtra("name", detailedModels.get(position).getName());
                i.putExtra("image", detailedModels.get(position).getBigimageurl());
                i.putExtra("price",detailedModels.get(position).getPrice());
                i.putExtra("desc",detailedModels.get(position).getDescription());
                i.putExtra("qty",detailedModels.get(position).getQuantity());
                i.putExtra("unit",detailedModels.get(position).getUnit());

                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return detailedModels.size();
    }

    public  static class DetailedViewHolder extends RecyclerView.ViewHolder{

        TextView name, description, price, qty, unit;
        ConstraintLayout bg;
        public DetailedViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            qty = itemView.findViewById(R.id.qty);
            unit = itemView.findViewById(R.id.unit);
            bg = itemView.findViewById(R.id.recently_layout);

        }
    }

}
