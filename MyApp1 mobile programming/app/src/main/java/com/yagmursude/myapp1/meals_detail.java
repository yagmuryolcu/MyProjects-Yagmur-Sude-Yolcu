package com.yagmursude.myapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class meals_detail extends AppCompatActivity {

    private List<String> mainDishMenu;
    private List<String> saladMenu;
    private List<String> drinkMenu;
    private List<String> dessertMenu;
    private List<String> cartItems;

    private RecyclerView recyclerViewMenu;
    private RecyclerView recyclerViewCart;
    private Button buttonOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meals_detail);

        mainDishMenu = new ArrayList<>();
        saladMenu = new ArrayList<>();
        drinkMenu = new ArrayList<>();
        dessertMenu = new ArrayList<>();
        cartItems = new ArrayList<>();

 // findwiev by ıd layout dosyasında tanımlı olan bileşenleri Java koduna bağlamak için kullanılır.
        recyclerViewMenu = findViewById(R.id.recyclerViewMenu);
        recyclerViewCart = findViewById(R.id.recyclerViewCart);
        buttonOrder = findViewById(R.id.buttonOrder);

        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(this));


        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cartItems.isEmpty()) {
                    Toast.makeText(meals_detail.this, "Cart is empty", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(meals_detail.this, "Your order has been taken", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}