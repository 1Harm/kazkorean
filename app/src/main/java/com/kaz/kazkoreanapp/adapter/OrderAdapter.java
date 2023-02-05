package com.kaz.kazkoreanapp.adapter;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kaz.kazkoreanapp.R;
import com.kaz.kazkoreanapp.model.Item;
import com.kaz.kazkoreanapp.model.ItemData;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private ArrayList<Item> listItem;

    public OrderAdapter(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_order, parent, false);
        return new OrderAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Item item = listItem.get(position);

        CardView cardView = holder.cardView;
        ImageView image_view = (ImageView) cardView.findViewById(R.id.image_item);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), item.getImg());
        image_view.setImageDrawable(drawable);
        TextView text_title = (TextView) cardView.findViewById(R.id.item_title);
        TextView text_price = (TextView) cardView.findViewById(R.id.item_price);

        text_title.setText(item.getName());
        text_price.setText(String.format("$ %s", String.valueOf(item.getPrice())));

        cardView.findViewById(R.id.removeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItem.remove(position);
                notifyItemRemoved(position);
                notifyItemChanged(position, listItem.size());
                ItemData.orders.remove(position);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(@NonNull CardView v) {
            super(v);
            cardView = v;
        }
    }


}
