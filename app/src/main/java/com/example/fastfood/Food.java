package com.example.fastfood;

import java.io.Serializable;

public class Food implements Serializable {
    public String name;
    public int img;
    public double price;
    public int count;



    public Food(String name, int img, double price) {
        this.name = name;
        this.img = img;
        this.price = price;
    }
}
