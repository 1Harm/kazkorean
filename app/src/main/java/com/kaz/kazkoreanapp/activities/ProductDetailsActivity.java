package com.kaz.kazkoreanapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kaz.kazkoreanapp.MainActivity;
import com.kaz.kazkoreanapp.R;

public class ProductDetailsActivity extends AppCompatActivity {

    ImageView img, back;
    int total, quantity;
    TextView proName, proPrice, proDesc, proQty, proUnit;
    Button add;
    String name, price, desc, qty, unit;
    int image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detailed);
        Intent i = getIntent();

        name = i.getStringExtra("name");
        image = i.getIntExtra("image", R.drawable.b1);
        price = i.getStringExtra("price");
        desc = i.getStringExtra("desc");
        qty = i.getStringExtra("qty");
        unit = i.getStringExtra("unit");
        add = findViewById(R.id.addCart);

        proName = findViewById(R.id.productName);
        proDesc = findViewById(R.id.prodDesc);
        proPrice = findViewById(R.id.prodPrice);
        img = findViewById(R.id.big_image);
        back = findViewById(R.id.back2);
        proQty = findViewById(R.id.qty);
        proUnit = findViewById(R.id.unit);
        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        proQty.setText(qty);
        proUnit.setText(unit);

        img.setImageResource(image);
        add = findViewById(R.id.addCart);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetailsActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
//    public void cartView(View view) {
//        Intent i = new Intent(ProductDetailsActivity.this, MyCartActivity.class);
//        startActivity(i);
//    }
}
