package com.yagmursude.myapp1;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class CardManager {

    private List<CartItem> cartItems;

    public CardManager() {
        cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    // Yeni bir öğe ekleyen metot
    public void addItem(FoodItem foodItem, int quantity) {
        // Eğer öğe zaten sepette varsa miktarını arttır, yoksa yeni bir öğe olarak ekle
        for (CartItem cartItem : cartItems) {
            if (cartItem.getFoodItem().equals(foodItem)) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                return;
            }
        }
        // Sepette yoksa yeni bir öğe olarak ekle
        CartItem newItem = new CartItem(foodItem, quantity);
        cartItems.add(newItem);
    }

    // Belirli bir öğeyi kaldıran metot
    public void removeItem(CartItem item) {
        cartItems.remove(item);
    }

    // Sepeti temizleyen metot
    public void clearCart() {
        cartItems.clear();
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getTotalPrice();
        }
        return total;
    }
}