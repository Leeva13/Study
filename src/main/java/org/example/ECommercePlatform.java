package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ECommercePlatform {
    private final Map<Integer, User> users;
    private final Map<Integer, Product> products;
    private final Map<Integer, Order> orders;


    private static final ECommercePlatform platform = new ECommercePlatform();

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    // Метод для створення замовлення
    public void createOrder(Integer userId, Map<Product, Integer> orderDetails) {
        User user = users.get(userId);
        if (user != null) {
            Order order = new Order(generateOrderId(), userId, orderDetails);
            orders.put(order.getId(), order);
            updateProductStocks(orderDetails);
        } else {
            System.out.println("Користувача з ID " + userId + " не знайдено.");
        }
    }

    public Map<Integer, Product> getAvailableProducts() {
        return products;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    // Метод для оновлення запасів товарів
    private void updateProductStocks(Map<Product, Integer> orderDetails) {
        for (Map.Entry<Product, Integer> entry : orderDetails.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            int currentStock = product.getStock();
            if (currentStock >= quantity) {
                product.setStock(currentStock - quantity);
            } else {
                System.out.println("Недостатньо товару \"" + product.getName() + "\" на складі.");
            }
        }
    }

    public void recommendProductsBasedOnCart(User user) {
        System.out.println("\nРекомендовані товари для користувача " + user.getUsername() + ":");
        List<Product> recommendedProducts = new ArrayList<>(platform.getAvailableProducts().values());
        recommendedProducts.removeAll(user.getProductsInCart());
        recommendedProducts.forEach(System.out::println);
    }

    // Метод для генерації унікального ID для замовлення
    private int generateOrderId() {
        return orders.size() + 1;
    }
}
