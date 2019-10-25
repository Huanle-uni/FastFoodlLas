package com.example.fastfood;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;


public class FoodDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private Food food;
    private TextView tvName;
    private TextView tvPrice;
    private ImageView ivImg;
    private TextView tvNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddetail);
        food = (Food) getIntent().getSerializableExtra("food");
        tvName = findViewById(R.id.tv_name);
        tvPrice = findViewById(R.id.tv_price);
        ivImg = findViewById(R.id.iv_img);
         findViewById(R.id.tv_sub).setOnClickListener(this);
        tvNum = findViewById(R.id.tv_num);
        findViewById(R.id.tv_add).setOnClickListener(this);
        findViewById(R.id.bt_add).setOnClickListener(this);
        tvName.setText(food.name);
        tvPrice.setText("$"+food.price);
        ivImg.setImageResource(food.img);
    }

    @Override
    public void onClick(View view) {
        String numStr= tvNum.getText().toString().trim();
        int num = Integer.parseInt(numStr);
        switch (view.getId()){
            case R.id.tv_sub:
                if (num-1>=1){
                    tvNum.setText((num-1)+"");
                }
                break;
            case R.id.tv_add:
                tvNum.setText((num+1)+"");
                break;
            case R.id.bt_add:
                App app = (App) getApplication();
                HashMap<String, Food> map = app.getShoppingCartList();
                Food data = map.get(food.name);
                if (data==null){
                    food.count = num;
                    map.put(food.name,food);
                }else{
                    data.count = data.count+num;
                 }
                Toast.makeText(FoodDetailActivity.this,"success",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
