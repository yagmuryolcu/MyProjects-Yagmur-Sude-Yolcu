package com.yagmursude.myapp1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


    public class Foods extends AppCompatActivity {    private ListView listView;
    private Button btnContinue;

    String nmeals[] = {"Meals", "Salads", "Beverages", "Desserts"};
    String nmealsDescription[] = {"\"TOMATO SOUP\"\n" +
            "\"CHICKEN WRAP\" \n" +
            " \"HAMBURGER\"\n" +
            "\"MEAT FAJITA\"\n" +
            "\"GRILLED SALMON\"\n" +
            " \"BEEF MEAT BALLS\"\n" +
            "\"CHICKEN WITH CURRY SAUCE\"\n" +
            "\"RICE\" \n" +
            "\"FETTUCINI ALFREDO\"\n" +
            "\"MANTI\"\n"  , "\"CAESAR SALAD\"\n" +
            "\"GREEK SALAD\"\n" +
            "\"WALDORF SALAD\"\n", "\"COCA-COLA\" \n" +
            "\"PEPSI\" \n" +
            "\"ICED TEA\" \n" +
            "\"FRUIT JUICE\"\n" +
            "\"MILKSHAKE\" \n" +
            "\"FRAPPE\"\n" + "\"HOT CHOCOLATE\"\n" +
            "\"HERBAL TEAS\"\n" +
            "\"LATTE\" \n", "\"CHOCOLATE CAKE\"\n" +
            "\"CHEESECAKE RASPBERY\"\n" +
            "\"TIRAMISU\",\n" +
            "\"TRES LECHES\"\n" +
            "\"WAFFLE\"\n"};
    int nfoodPictures[] = {R.drawable.soup, R.drawable.salad, R.drawable.soda, R.drawable.cupcake};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        listView = findViewById(R.id.ListView);

        myAdapter adapter = new myAdapter(this, nmeals, nmealsDescription, nfoodPictures);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(Foods.this, "Ready in 20 minutes", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Toast.makeText(Foods.this, "Ready in 10 minutes", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Toast.makeText(Foods.this, "Ready in 5 minutes", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    Toast.makeText(Foods.this, "Ready in 5 minutes", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    class myAdapter extends ArrayAdapter<String> {

        Context context;
        String nmeals[];
        String nmealsDescription[];
        int nfoodPictures[];

        myAdapter(Context c, String meals[], String mealsDescription[], int foodPictures[]) {
            super(c, R.layout.custom_foods, R.id.textView, meals);
            this.context = c;
            this.nmeals = meals;
            this.nmealsDescription = mealsDescription;
            this.nfoodPictures = foodPictures;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View satir = layoutInflater.inflate(R.layout.custom_foods, parent, false);

            ImageView picture = satir.findViewById(R.id.foodPictures);
            TextView myFood = satir.findViewById(R.id.Meals);
            TextView myfoodDescription = satir.findViewById(R.id.MealsDetail);
            Button btnContinue = satir.findViewById(R.id.ContinueButton);

            picture.setImageResource(nfoodPictures[position]);
            myFood.setText(nmeals[position]);
            myfoodDescription.setText(nmealsDescription[position]);

            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Intent intent = new Intent(context, CartItem.class);
                  //  context.startActivity(intent);
                }
            });

            return satir;
        }
    }
}