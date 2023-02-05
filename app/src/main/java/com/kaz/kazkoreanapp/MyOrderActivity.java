package com.kaz.kazkoreanapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kaz.kazkoreanapp.adapter.OrderAdapter;
import com.kaz.kazkoreanapp.model.Item;
import com.kaz.kazkoreanapp.model.ItemData;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        TextView totalPriceTv = findViewById(R.id.totalPriceTV);

        ImageView back_btn = findViewById(R.id.back_button);
        back_btn.setOnClickListener(v -> {
            finish();
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        items.clear();
        items.addAll(ItemData.getListOrder());
        OrderAdapter adapter = new OrderAdapter(items);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        int total = grandTotal(ItemData.getListOrder());
        totalPriceTv.setText("Total: $. " + String.valueOf(total));

        LinearLayout completeOrder = findViewById(R.id.order_complete);
        completeOrder.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), CompleteOrderActivity.class);
            startActivity(i);
        });
    }

    private int grandTotal(ArrayList<Item> items){

        int totalPrice = 0;
        for(int i = 0 ; i < items.size(); i++) {
            totalPrice += items.get(i).getPrice();
        }

        return totalPrice;
    }
}