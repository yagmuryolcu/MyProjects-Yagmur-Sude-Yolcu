package com.yagmursude.myapp1;

public class CartItem {

    private FoodItem foodItem;
    private int quantity;

    public CartItem(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Bu öğenin toplam fiyatını hesaplayan metot
    public double getTotalPrice() {
        return foodItem.getPrice() * quantity;
    }
}