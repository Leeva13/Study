package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ECommerceDemo {
    private static final ECommercePlatform platform = new ECommercePlatform();
    private static final ECommercePlatform ePlatform = new ECommercePlatform();

    // Функція для відображення відсортованого за назвою списку товарів
    public static void displayProductsSortedByName() {
        List<Product> sortedProducts = new ArrayList<>(platform.getAvailableProducts().values());
        sortedProducts.sort(new Product.NameComparator());

        System.out.println("Список товарів, відсортований за назвою:");
        sortedProducts.forEach(System.out::println);
    }

    // Функція для відображення відсортованого за ціною списку товарів
    public static void displayProductsSortedByPrice() {
        System.out.println("Список товарів, відсортований за ціною:");
        platform.getAvailableProducts().values().stream()
                .sorted()
                .forEach(System.out::println);
    }

    // Функція для відображення відсортованого за запасами списку товарів
    public static void displayProductsSortedByStock() {
        System.out.println("Список товарів, відсортований за запасами:");
        platform.getAvailableProducts().values().stream()
                .sorted(new Product.StockComparator())
                .forEach(System.out::println);
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

    private static void addUserAndProducts() {
        User user1 = new User(1, "rock_star");
        User user2 = new User(2, "john_Snow");
        platform.addUser(user1);
        platform.addUser(user2);

        Product product1 = new Product(1, "Laptop", 999.99, 10);
        Product product2 = new Product(2, "Smartphone", 499.99, 20);
        platform.addProduct(product1);
        platform.addProduct(product2);
    }

    private static void displayFinalState() {
        // Виведення кінцевого стану користувачів
        System.out.println("\nКінцевий стан користувачів:");
        for (User user : platform.getUsers().values()) {
            System.out.println(user);
        }

        // Виведення кінцевого стану товарів
        System.out.println("\nКінцевий стан товарів:");
        for (Product product : platform.getAvailableProducts().values()) {
            System.out.println(product);
        }

        // Виведення кінцевого стану замовлень
        System.out.println("\nКінцевий стан замовлень:");
        for (Order order : platform.getOrders().values()) {
            System.out.println(order);
        }
    }

    public static void displayRecommendationsForUser(User user) {
        System.out.println("\nРекомендації для користувача " + user.getUsername() + ":");
        ePlatform.recommendProductsBasedOnCart(user);
    }

    private static void simulateUserInteractions() {
        // Симуляція взаємодії користувачів з кошиком
        User user1 = platform.getUsers().get(1);
        user1.addToCart(platform.getAvailableProducts().get(1), 2);
        user1.addToCart(platform.getAvailableProducts().get(2), 1);

        User user2 = platform.getUsers().get(2);
        user2.addToCart(platform.getAvailableProducts().get(1), 1);
        user2.addToCart(platform.getAvailableProducts().get(2), 3);

        // Симуляція створення та обробки замовлень
        platform.createOrder(user1.getId(), user1.getCart());
        platform.createOrder(user2.getId(), user2.getCart());

        // Додаткові демонстрації

        // Додавання нових товарів і користувачів
        User user3 = new User(3, "Mary-Van");
        platform.addUser(user3);

        Product product3 = new Product(3, "Headphones", 79.99, 15);
        platform.addProduct(product3);

        // Оновлення кошика користувача
        User user4 = platform.getUsers().get(1);
        user1.modifyCart(platform.getAvailableProducts().get(1), 3);

        // Створення нового замовлення
        platform.createOrder(user3.getId(), user3.getCart());

        // Рекомендації товарів на основі кошика користувача
        ePlatform.recommendProductsBasedOnCart(user4);
    }

    public static void main(String[] args) {
        addUserAndProducts();
        simulateUserInteractions();
        displayFinalState();

        displayProductsSortedByName();
        displayProductsSortedByPrice();
        displayProductsSortedByStock();
        filterProductsByStock(15);

        displayFinalState();
    }
}
