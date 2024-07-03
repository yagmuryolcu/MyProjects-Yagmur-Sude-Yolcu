package com.yagmursude.myapp1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    public interface OnItemClickListener {
        void onRemoveItemClick(CartItem cartItem);
        void onItemAddedToCart(FoodItem foodItem);
    }

    private List<FoodItem> foodItems;
    private CardManager cardManager;
    private CartAdapter cartAdapter;
    private double totalAmount = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        foodItems = createFoodItems();
        cardManager = new CardManager();
       // Sepet öğelerini yönetir (ekleme, çıkarma, toplam hesaplama).
        RecyclerView recyclerViewCart = findViewById(R.id.recyclerViewCart);
        RecyclerView recyclerViewMenu = findViewById(R.id.recyclerViewMenu);

        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
        //Sepet öğelerini görüntülemek için RecyclerView adaptörü
        cartAdapter = new CartAdapter(cardManager.getCartItems(), new OnItemClickListener() {
            @Override
            public void onRemoveItemClick(CartItem cartItem) {
                cardManager.removeItem(cartItem);
                cartAdapter.notifyDataSetChanged();
                updateTotalAmount();
            }

            @Override
            public void onItemAddedToCart(FoodItem foodItem) {
                Toast.makeText(CartActivity.this, foodItem.getItemName() + " added to cart", Toast.LENGTH_SHORT).show();
                updateTotalAmount();

            }
        });
        recyclerViewCart.setAdapter(cartAdapter);

        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMenu.setAdapter(new MenuAdapter(foodItems, new MenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FoodItem foodItem) {
                cardManager.addItem(foodItem, 1);
                cartAdapter.notifyDataSetChanged();
                //  değişiklik yapıldığında RecyclerView'a  bildirir
                updateTotalAmount();
            }

            @Override
            public void onAddToCartClick(FoodItem foodItem) {
                cardManager.addItem(foodItem, 1);
                cartAdapter.notifyDataSetChanged();
                updateTotalAmount();
            }

            @Override
            public void onItemAddedToCart(FoodItem foodItem) {
                Toast.makeText(CartActivity.this, foodItem.getItemName() + " added to cart",
                        Toast.LENGTH_SHORT).show();

            }
        }));
    }


    private List<FoodItem> createFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(new FoodItem("TOMATO SOUP", "Tomato", 7.0));
        foodItems.add(new FoodItem("CHICKEN WRAP", "Chicken", 10.0));
        foodItems.add(new FoodItem("HAMBURGER", "Beef, Bread, Lettuce, Tomato", 9.0));
        foodItems.add(new FoodItem("MEAT FAJITA", "Beef, Onion, Pepper", 11.0));
        foodItems.add(new FoodItem("GRILLED SALMON", "Salmon, Lemon, Butter", 15.0));
        foodItems.add(new FoodItem("BEEF MEAT BALLS", "Beef, Tomato Sauce", 13.0));
        foodItems.add(new FoodItem("CHICKEN WITH CURRY SAUCE", "Chicken, Curry Sauce", 11.0));
        foodItems.add(new FoodItem("FETTUCINI ALFREDO", "Fettucini, Cream, Parmesan", 12.0));
        foodItems.add(new FoodItem("MANTI", "Dough, Ground Meat, Yogurt, Garlic", 13.0));
        foodItems.add(new FoodItem("CAESAR SALAD", "Romaine Lettuce, Croutons, Parmesan, Caesar Dressing", 8.0));
        foodItems.add(new FoodItem("GREEK SALAD", "Cucumber, Tomato, Olive, Feta, Greek Dressing", 9.0));
        foodItems.add(new FoodItem("WALDORF SALAD", "Apple, Celery, Walnut, Mayonnaise", 10.0));
        foodItems.add(new FoodItem("COCA-COLA", "Coca-Cola", 2.0));
        foodItems.add(new FoodItem("PEPSI", "Pepsi", 2.0));
        foodItems.add(new FoodItem("ICED TEA", "Tea, Ice, Lemon", 3.0));
        foodItems.add(new FoodItem("FRUIT JUICE", "Mixed Fruits", 2.5));
        foodItems.add(new FoodItem("MILKSHAKE", "Milk, Ice Cream, Flavoring", 4.0));
        foodItems.add(new FoodItem("FRAPPE", "Iced Coffee, Milk, Sugar", 3.0));
        foodItems.add(new FoodItem("LATTE", "Espresso, Steamed Milk", 4.0));
        foodItems.add(new FoodItem("CHOCOLATE CAKE", "Chocolate, Flour, Sugar, Egg", 5.0));
        foodItems.add(new FoodItem("CHEESECAKE RASPBERY", "Cream Cheese, Graham Cracker, Raspberry", 4.0));
        foodItems.add(new FoodItem("TIRAMISU", "Coffee, Mascarpone, Cocoa, Ladyfinger", 6.0));
        foodItems.add(new FoodItem("TRES LECHES", "Milk, Egg, Flour, Sugar", 6.0));

        return foodItems;
    }

    private void updateTotalAmount() {
       // updateTotalAmounT metodu, sepetteki öğelerin toplam tutarını hesaplar ve  TextView'yi günceller.
        TextView totalAmountTextView = findViewById(R.id.totalAmountTextView);
        double totalAmount = cardManager.calculateTotal();
        totalAmountTextView.setText(String.format(Locale.getDefault(), "Total Amount: $%.2f", totalAmount));
    }

        private class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

            private List<CartItem> cartItems;
            private OnItemClickListener onItemClickListener;


            public CartAdapter(List<CartItem> cartItems, OnItemClickListener onItemClickListener) {
                this.cartItems = cartItems;
                this.onItemClickListener = onItemClickListener;
            }

        @Override
        public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
            return new CartViewHolder(view, onItemClickListener);
        }

        @Override
        public void onBindViewHolder(CartViewHolder holder, int position) {
            CartItem cartItem = cartItems.get(position);
            holder.cartItemName.setText(cartItem.getFoodItem().getItemName());
            holder.cartItemPrice.setText(String.format("$%.2f", cartItem.getTotalPrice()));
            holder.cartItemQuantity.setText(String.valueOf(cartItem.getQuantity()));
        }

        @Override
        public int getItemCount() {
            return cartItems.size();
        }

        class CartViewHolder extends RecyclerView.ViewHolder {

            TextView cartItemName;
            TextView cartItemPrice;
            TextView cartItemQuantity;
            ImageButton removeItemButton;

            public CartViewHolder(View itemView, final OnItemClickListener listener) {
                super(itemView);
                cartItemName = itemView.findViewById(R.id.cartItemName);
                cartItemPrice = itemView.findViewById(R.id.cartItemPrice);
                cartItemQuantity = itemView.findViewById(R.id.cartItemQuantity);
                removeItemButton = itemView.findViewById(R.id.removeItemButton);

                removeItemButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                        public void onClick(View v) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onRemoveItemClick(cartItems.get(position));
                           // pozisyonun geçerli bir pozisyon olup olmadığını kontrol eder
                        }
                    }
                });
            }
        }
    }
}