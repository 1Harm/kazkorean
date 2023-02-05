package com.kaz.kazkoreanapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kaz.kazkoreanapp.activities.ProfileActivity;
import com.kaz.kazkoreanapp.activities.SettingsActivity;
import com.kaz.kazkoreanapp.adapter.DetailedAdapter;
import com.kaz.kazkoreanapp.model.DetailedModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CardView perfume, cream, lip, topUp;
    RecyclerView detailedRecyclerView;
    DetailedAdapter detailedAdapter;
    List<DetailedModel> detailedModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detailedRecyclerView = findViewById(R.id.shampoo_item);
        perfume = findViewById(R.id.drinks_menu);
        cream = findViewById(R.id.snacks_menu);
        lip = findViewById(R.id.foods_menu);
        topUp = findViewById(R.id.topUp_menu);
        LinearLayout myOrder = findViewById(R.id.my_order);

        myOrder.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MyOrderActivity.class);
            startActivity(intent);
        });

        perfume.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ItemListActivity.class);
            String value = "perfume";
            intent.putExtra("choice", value);
            startActivity(intent);
        });

        cream.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ItemListActivity.class);
            String value = "cream";
            intent.putExtra("choice", value);
            startActivity(intent);
        });

        lip.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ItemListActivity.class);
            String value = "lipsticks";
            intent.putExtra("choice", value);
            startActivity(intent);
        });
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        detailedModels = new ArrayList<>();
        detailedModels.add(new DetailedModel("Shampoo","For head and shoulders the best shampoo.","$ 100", "1","per unit",R.drawable.sham,R.drawable.sham));
        detailedModels.add(new DetailedModel("Shampoo","For head and shoulders the best shampoo.","$ 40", "1","per unit",R.drawable.sham,R.drawable.sham));
        detailedModels.add(new DetailedModel("Shampoo","For head and shoulders the best shampoo","$ 30", "1","per unit",R.drawable.sham2,R.drawable.sham2));
        detailedModels.add(new DetailedModel("Shampoo","For head and shoulders the best shampoo","$ 20", "1","per unit",R.drawable.sham2,R.drawable.sham2));
        setDetailedRecycler(detailedModels);
        topUp.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "top up successfully", Toast.LENGTH_SHORT).show());
    }

    private void setDetailedRecycler(List<DetailedModel> detailedModels) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        detailedRecyclerView.setLayoutManager(layoutManager);
        detailedAdapter = new DetailedAdapter(this,detailedModels);
        detailedRecyclerView.setAdapter(detailedAdapter);
    }
}