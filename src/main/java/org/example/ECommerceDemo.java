package org.example;

import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ECommerceDemo {
    private static final ECommercePlatform platform = new ECommercePlatform();

    // Функція для відображення відсортованого за назвою списку товарів
    public static void displayProductsSortedByName() {
        List<Product> sortedProducts = new ArrayList<>(platform.getAvailableProducts().values());
        sortedProducts.sort(new Product.NameComparator());

        System.out.println("Список товарів, відсортований за назвою:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }

    // Функція для відображення відсортованого за ціною списку товарів
    public static void displayProductsSortedByPrice() {
        List<Product> sortedProducts = new ArrayList<>(platform.getAvailableProducts().values());
        Collections.sort(sortedProducts);

        System.out.println("Список товарів, відсортований за ціною:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }

    // Функція для відображення відсортованого за запасами списку товарів
    public static void displayProductsSortedByStock() {
        List<Product> sortedProducts = new ArrayList<>(platform.getAvailableProducts().values());
        sortedProducts.sort(new Product.StockComparator());

        System.out.println("Список товарів, відсортований за запасами:");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
    }

    // Функція для фільтрації товарів за наявністю на складі
    public static void filterProductsByStock(int minStock) {
        List<Product> filteredProducts = platform.getAvailableProducts().values().stream()
                .filter(product -> product.getStock() >= minStock)
                .toList();

        System.out.println("Список товарів, доступних на складі більше " + minStock + ":");
        for (Product product : filteredProducts) {
            System.out.println(product);
        }
    }

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

        displayProductsSortedByName();
        displayProductsSortedByPrice();
        displayProductsSortedByStock();
        filterProductsByStock(5);
    }
}
