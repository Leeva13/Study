package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    private Integer id;
    private String username;
    private Map<Product, Integer> cart;


    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Кількість товару повинна бути більше 0.");
        }

        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + quantity);
        } else {
            cart.put(product, quantity);
        }
    }

    public void removeFromCart(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Кількість товару для видалення повинна бути більше 0.");
        }

        if (cart.containsKey(product)) {
            int currentQuantity = cart.get(product);
            if (quantity >= currentQuantity) {
                cart.remove(product);
            } else {
                cart.put(product, currentQuantity - quantity);
            }
        } else {
            throw new IllegalArgumentException("Товар відсутній в кошику.");
        }
    }

    public void modifyCart(Product product, int newQuantity) {
        if (newQuantity > 0) {
            cart.put(product, newQuantity);
        } else {
            removeFromCart(product, cart.getOrDefault(product, 0));
        }
    }

    public List<Product> getProductsInCart() {
        List<Product> productsInCart = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            productsInCart.add(entry.getKey());
        }
        return productsInCart;
    }

    public void clearCart() {
        cart.clear();
    }

}
