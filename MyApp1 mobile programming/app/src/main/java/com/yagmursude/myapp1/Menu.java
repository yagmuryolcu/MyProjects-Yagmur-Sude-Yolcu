package com.yagmursude.myapp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements View.OnClickListener {


    private String[] mainDishMenu = { "TOMATO SOUP , 7$  ", "CHICKEN WRAP, 10$  ", "HAMBURGER, 9$ ",
            "MEAT FAJITA,    11$ ", "GRILLED SALMON,   15$  ", "BEEF MEAT BALLS,    13$ ",
            "CHICKEN WITH CURRY SAUCE,    11$ ","RICE,    7$ ", "FETTUCINI ALFREDO,   12$ ",
            "MANTI   13.$ "
    };
    private String[] saladMenu = {"CAESAR SALAD , 8$ ", "GREEK SALAD,  9$ ","WALDORF SALAD, 10$"
    };
    private String[] drinkMenu = {"COCA-COLA, 2$", "PEPSI,  2$", "ICED TEA, 3$ ","FRUIT JUICE, 2.5$",
            "MILKSHAKE, 4$" , "FRAPPE, 3$", "LATTE, 4$"
    };
    private String[] dessertMenu = {"CHOCOLATE CAKE, 5$", "CHEESECAKE RASPBERRY, 4$", "TIRAMISU, 6$", "TRES LECHES, 6.$"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        Button buttonMainDish = findViewById(R.id.buttonMainDish);
        Button buttonSalad = findViewById(R.id.buttonSalad);
        Button buttonDrink = findViewById(R.id.buttonDrink);
        Button buttonDessert = findViewById(R.id.buttonDessert);
        Button btnGoToMealsDetail = findViewById(R.id.btnGoToMealsDetail);


        // Menü kategorilerine tıklama olayları
        buttonMainDish.setOnClickListener(this);
        buttonSalad.setOnClickListener(this);
        buttonDrink.setOnClickListener(this);
        buttonDessert.setOnClickListener(this);
        btnGoToMealsDetail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonMainDish) {
            showMenu(mainDishMenu);
            Toast.makeText(Menu.this, "Ready in 20 minutes", Toast.LENGTH_LONG).show();

        } else if (v.getId() == R.id.buttonSalad) {
            showMenu(saladMenu);
            Toast.makeText(Menu.this, "Ready in 10 minutes", Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.buttonDrink) {
            showMenu(drinkMenu);
            Toast.makeText(Menu.this, "Ready in 10 minutes", Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.buttonDessert) {
            showMenu(dessertMenu);
            Toast.makeText(Menu.this, "Ready in 10 minutes", Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.btnGoToMealsDetail) {
        Intent mealsDetailIntent = new Intent(Menu.this, CartActivity.class);
        startActivity(mealsDetailIntent);
    }

    }

    // Menü gösterilmesi için AlertDialog oluşturan metod
    private void showMenu(String[] menuItems) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Menu");
        builder.setItems(menuItems, null);
        builder.show();
    }
}