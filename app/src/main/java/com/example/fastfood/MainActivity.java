package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recycleView;
    private Button btView;

    private ArrayList<Food> foods = new ArrayList<>();
    private FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleView = findViewById(R.id.recyclerView);
        btView = findViewById(R.id.bt_view);
        btView.setOnClickListener(this);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        initData();
        adapter = new FoodAdapter(this,foods);
        recycleView.setAdapter(adapter);
        adapter.setOnItemClickListener(new FoodAdapter.ItemClickListener() {
            @Override
            public void setOnItemClickListener(int position) {
                Food food = foods.get(position);
                Intent intent = new Intent(MainActivity.this,FoodDetailActivity.class);
                intent.putExtra("food",food);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        foods.add(new Food("BBQ",R.drawable.food1,12.6));
        foods.add(new Food("PORK",R.drawable.food2,19.9));
        foods.add(new Food("CHICKEN",R.drawable.food3,12.2));
        foods.add(new Food("TOFU",R.drawable.food4,24.8));
        foods.add(new Food("WONTON",R.drawable.food5,13.5));
        foods.add(new Food("DUMPLING",R.drawable.food6,20.6));
        foods.add(new Food("NOODLE",R.drawable.food7,13.2));
        foods.add(new Food("DUCK",R.drawable.food8,16.2));
        foods.add(new Food("ROLLS",R.drawable.food9,12.4));
        foods.add(new Food("MEI",R.drawable.food10,23.4));
        foods.add(new Food("SOUP",R.drawable.food11,22.4));
        foods.add(new Food("OYSTER",R.drawable.food12,26.8));
        foods.add(new Food("CUCUMBER",R.drawable.food13,21.2));
        foods.add(new Food("CRAB",R.drawable.food14,13.5));
        foods.add(new Food("HOTPOT",R.drawable.food15,16.7));


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_view:

                startActivity(new Intent(this, CartActivity.class));
                break;
        }
    }
}
