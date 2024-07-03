package com.yagmursude.myapp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private static List<FoodItem> foodItems;
    private OnItemClickListener onItemClickListener;

    public MenuAdapter(List<FoodItem> foodItems, OnItemClickListener onItemClickListener) {
        this.foodItems = foodItems;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal, parent, false);
        return new MenuViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        FoodItem foodItem = foodItems.get(position);
        holder.mealName.setText(foodItem.getItemName());
        holder.mealPrice.setText(String.format("$%.2f", foodItem.getPrice()));

    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView mealName;
        TextView mealPrice;
        Button buttonAddToCart;

        public MenuViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mealName = itemView.findViewById(R.id.meal_name);
            mealPrice = itemView.findViewById(R.id.meal_price);
            buttonAddToCart = itemView.findViewById(R.id.buttonAddToCart);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(foodItems.get(position));
                    }
                }
            });

            buttonAddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onAddToCartClick(foodItems.get(position));
                        listener.onItemAddedToCart(foodItems.get(position));

                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(FoodItem foodItem);
        void onAddToCartClick(FoodItem foodItem);
        void onItemAddedToCart(FoodItem foodItem);

    }
}