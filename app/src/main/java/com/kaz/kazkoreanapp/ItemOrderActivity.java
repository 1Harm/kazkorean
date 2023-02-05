package com.kaz.kazkoreanapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.kaz.kazkoreanapp.model.Item;
import com.kaz.kazkoreanapp.model.ItemData;

public class ItemOrderActivity extends AppCompatActivity {

    public static final String ORDER_ITEM = "order_item";
    TextView titleTv, priceTv;
    ImageView imageVw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_order);

        ImageView back_btn = findViewById(R.id.back_button);
        back_btn.setOnClickListener(v -> {
            finish();
        });

        LinearLayout myOrder = findViewById(R.id.my_order);
        myOrder.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MyOrderActivity.class));
        });

        titleTv = (TextView) findViewById(R.id.item_title);
        priceTv = (TextView) findViewById(R.id.item_price);
        imageVw = (ImageView) findViewById(R.id.image_item);
        Button orderBtn = findViewById(R.id.orderBtn);

        Item item = getIntent().getParcelableExtra(ORDER_ITEM);

        if (item != null) {
            titleTv.setText(item.getName());
            priceTv.setText(String.format("$ %s", String.valueOf(item.getPrice())));
            imageVw.setImageDrawable(ContextCompat.getDrawable(this, item.getImg()));
            orderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ItemData.orders.add(new Item(item.getName(), item.getPrice(), item.getImg()));
                }
            });
        }
    }
}