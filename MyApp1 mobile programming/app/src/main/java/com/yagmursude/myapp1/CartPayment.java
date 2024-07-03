package com.yagmursude.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CartPayment extends AppCompatActivity {
    private static double totalAmount = 0;

    public static double getTotalAmount() {
        return totalAmount;
    }

    public static void addToTotal(double amount) {
        totalAmount += amount;
    }

    public static void removeFromTotal(double amount) {
        totalAmount -= amount;
        if (totalAmount < 0) {
            totalAmount = 0;
        }
    }
    public static void clearTotal() {
        totalAmount = 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_payment);
    }
}