package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest {
    private Cart cart;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() {
        cart = new Cart();
        product1 = new Product(1, "Product 1", 15.0);
        product2 = new Product(2, "Product 2", 25.0);
    }

    @Test
    public void addToCart() {
        cart.addToCart(product1);
        cart.addToCart(product2);

        assertEquals(2, cart.getListOfProducts().size());
    }

    @Test
    public void removeFromCart() {
        cart.addToCart(product1);
        cart.addToCart(product2);

        cart.removeFromCart(product1);
        assertEquals(1, cart.getListOfProducts().size());

        cart.removeFromCart(product2);
        assertEquals(0, cart.getListOfProducts().size());
    }

    @Test
    public void checkout() {
        cart.addToCart(product1);
        cart.addToCart(product2);

        cart.checkout();

        assertEquals(0, cart.getListOfProducts().size());
        assertEquals(1, cart.getOrders().size());
    }

    @Test
    public void getOrderStatus() {
        cart.addToCart(product1);
        cart.addToCart(product2);

        cart.checkout();
        String status = cart.getOrderStatus(1);

        assertEquals("Pending", status);
    }
}