package com.kaz.kazkoreanapp.activities;

import  android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kaz.kazkoreanapp.MainActivity;
import com.kaz.kazkoreanapp.R;

public class DetailedActivity extends AppCompatActivity {
    ImageView img, back;
    TextView proName, proPrice, proDesc, proQty, proUnit;

    String name, price, desc, qty, unit;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        image = i.getIntExtra("image", R.drawable.l1);
        price = i.getStringExtra("price");
        desc = i.getStringExtra("desc");
        qty = i.getStringExtra("qty");
        unit = i.getStringExtra("unit");

        proName = findViewById(R.id.productNameV);
        proDesc = findViewById(R.id.prodDescV);
        proPrice = findViewById(R.id.prodPriceV);
        img = findViewById(R.id.big_imageV);
        back = findViewById(R.id.backV);
        proQty = findViewById(R.id.qtyV);
        proUnit = findViewById(R.id.unitV);

        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        proQty.setText(qty);
        proUnit.setText(unit);

        img.setImageResource(image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailedActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
