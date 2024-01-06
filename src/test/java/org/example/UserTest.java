package org.example;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void addToCart() {
        User user = new User(1, "john_doe");
        Product product = new Product(1, "Laptop", 999.99, 10);

        // Додавання товару в кошик
        user.addToCart(product, 2);

        // Перевірка, чи товар дійсно доданий
        Map<Product, Integer> cart = user.getCart();
        assertTrue(cart.containsKey(product));
        assertEquals(2, cart.get(product));

        // Додавання додаткової кількості товару
        user.addToCart(product, 3);

        // Перевірка, чи кількість оновилася
        assertEquals(5, cart.get(product));
    }

    @Test
    void removeFromCart() {
        User user = new User(1, "john_doe");
        Product product = new Product(1, "Laptop", 999.99, 10);

        // Додавання товару в кошик
        user.addToCart(product, 5);

        // Видалення частини товару з кошика
        user.removeFromCart(product, 2);

        // Перевірка, чи кількість оновилася
        Map<Product, Integer> cart = user.getCart();
        assertEquals(3, cart.get(product));

        // Видалення залишку товару з кошика
        user.removeFromCart(product, 3);

        // Перевірка, чи товар видалено з кошика
        assertFalse(cart.containsKey(product));
    }

    @Test
    void modifyCart() {
        User user = new User(1, "john_doe");
        Product product = new Product(1, "Laptop", 999.99, 10);

        // Додавання товару в кошик
        user.addToCart(product, 3);

        // Зміна кількості товару в кошику
        user.modifyCart(product, 5);

        // Перевірка, чи кількість оновилася
        Map<Product, Integer> cart = user.getCart();
        assertEquals(5, cart.get(product));

        // Видалення товару з кошика (кількість 0)
        user.modifyCart(product, 0);

        // Перевірка, чи товар видалено з кошика
        assertFalse(cart.containsKey(product));
        assertEquals(0, cart.size());

    }
}