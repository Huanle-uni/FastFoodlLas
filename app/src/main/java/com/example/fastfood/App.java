package com.example.fastfood;

import android.app.Application;
import java.util.HashMap;
public class App extends Application {
    private HashMap<String, Food> shoppingCartList = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();

        }

        public HashMap<String, Food> getShoppingCartList (){
        return shoppingCartList;


    }
}

