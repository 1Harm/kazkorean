package com.kaz.kazkoreanapp;

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

import com.kaz.kazkoreanapp.model.Item;

import java.util.ArrayList;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder> {
    private ArrayList<Item> listItem;
    private ListItemAdapter.Listener listener;

    public ListItemAdapter(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }

    public void setListener(ListItemAdapter.Listener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    @NonNull
    @Override
    public ListItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ListItemAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Item item = listItem.get(position);

        CardView cardView = holder.cardView;
        ImageView image_view = (ImageView) cardView.findViewById(R.id.image_item);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), item.getImg());
        image_view.setImageDrawable(drawable);
        TextView text_title = (TextView) cardView.findViewById(R.id.item_title);
        TextView text_price = (TextView) cardView.findViewById(R.id.item_price);

        text_title.setText(item.getName());
        text_price.setText(String.format("$ %s", String.valueOf(item.getPrice())));

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(listItem.get(position));
            }
        });
    }

    interface Listener {
        void onClick(Item data);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(@NonNull CardView v) {
            super(v);
            cardView = v;
        }
    }
}
