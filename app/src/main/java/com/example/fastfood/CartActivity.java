package com.example.fastfood;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CartActivity extends AppCompatActivity  {

    private RecyclerView recycleView;

    private ArrayList<Food> foods = new ArrayList<>();
    private CartAdapter adapter;
    private TextView mTvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        recycleView = findViewById(R.id.recyclerView);
        mTvCount = findViewById(R.id.mCount);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        initData();
        adapter = new CartAdapter(this,foods);
        recycleView.setAdapter(adapter);

    }
    double total = 0;
    private void initData() {
        List<Food> list = new ArrayList<>();
        App app = (App) getApplication();
        HashMap<String, Food> map = app.getShoppingCartList();
        Collection<Food> values = map.values();
        Iterator<Food> it2 = values.iterator();
        while(it2.hasNext()) {
            Food food = it2.next();
            list.add(food);
            total+=food.count*food.price;
        }
        foods.clear();
        foods.addAll(list);
        mTvCount.setText("Total: $"+total);
    }


}
