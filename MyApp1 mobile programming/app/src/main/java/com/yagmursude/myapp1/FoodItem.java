package com.yagmursude.myapp1;

import androidx.appcompat.app.AppCompatActivity;

public class FoodItem extends AppCompatActivity {
    private String itemName;
    private String description;
    private double price;

    public FoodItem(String itemName, String description, double price) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}