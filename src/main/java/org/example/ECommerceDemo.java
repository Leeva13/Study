package org.example;

import java.util.HashMap;
import java.util.Map;
public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform eCommercePlatform = new ECommercePlatform();

        User user1 = new User(1, "rock_star");
        User user2 = new User(2, "john_Snow");

        eCommercePlatform.addUser(user1);
        eCommercePlatform.addUser(user2);

        Product product1 = new Product(1, "Laptop", 999.99, 15);
        Product product2 = new Product(2, "Smartphone", 499.99, 20);

        eCommercePlatform.addProduct(product1);
        eCommercePlatform.addProduct(product2);

        user1.addToCart(product1, 2);
        user1.addToCart(product2, 1);

        user2.addToCart(product1, 1);
        user2.addToCart(product2, 3);

        // Вивід переліку доступних товарів
        System.out.println("Перелік доступних товарів:");
        Map<Integer, Product> availableProducts = eCommercePlatform.getAvailableProducts();
        for (Map.Entry<Integer, Product> entry : availableProducts.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("\nПерелік користувачів:");
        Map<Integer, User> users = eCommercePlatform.getUsers();
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            System.out.println(entry.getValue());
        }

        // Створення та обробка замовлень
        System.out.println("\nСтворення та обробка замовлень:");
        Map<Product, Integer> orderDetails1 = new HashMap<>();
        orderDetails1.put(product1, 2);
        orderDetails1.put(product2, 1);
        eCommercePlatform.createOrder(user1.getId(), orderDetails1);

        Map<Product, Integer> orderDetails2 = new HashMap<>();
        orderDetails2.put(product1, 1);
        orderDetails2.put(product2, 3);
        eCommercePlatform.createOrder(user2.getId(), orderDetails2);

        // Вивід переліку замовлень
        System.out.println("\nПерелік замовлень:");
        Map<Integer, Order> orders = eCommercePlatform.getOrders();
        for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
