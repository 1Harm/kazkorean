package com.kaz.kazkoreanapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kaz.kazkoreanapp.adapter.CompleteAdapter;
import com.kaz.kazkoreanapp.model.Item;
import com.kaz.kazkoreanapp.model.ItemData;

import java.util.ArrayList;

public class CompleteOrderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Item> orderItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_order);

        TextView totalPriceTv = findViewById(R.id.totalPriceTV);


        LinearLayout mainMenu = findViewById(R.id.main_menu);
        mainMenu.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        });
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        orderItems.addAll(ItemData.getListOrder());
        CompleteAdapter adapter = new CompleteAdapter(orderItems);
        recyclerView.setAdapter(adapter);

        int total = grandTotal(ItemData.getListOrder());
        totalPriceTv.setText("Total: $. " + String.valueOf(total));
    }

    private int grandTotal(ArrayList<Item> items){

        int totalPrice = 0;
        for(int i = 0 ; i < items.size(); i++) {
            totalPrice += items.get(i).getPrice();
        }

        return totalPrice;
    }
}