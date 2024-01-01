package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProductFetcher {

    private static final String API_ENDPOINT = "https://api.escuelajs.co/api/v1/products";
    private static final String API_KEY = "43a0cef4dd3b4c818a5328154582ef5d";

    public List<Product> fetchProducts() throws IOException {
        URL url = new URL(API_ENDPOINT);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);

        try (var reader = connection.getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode jsonNode = objectMapper.readTree(reader);

            List<Product> products = new ArrayList<>();

            for (JsonNode productNode : jsonNode) {
                Product product = objectMapper.treeToValue(productNode, Product.class);
                products.add(product);
            }
            return products;
        }
    }

    public static void main(String[] args) {
        try {
            ProductFetcher productFetcher = new ProductFetcher();
            List<Product> products = productFetcher.fetchProducts();

            for (Product product : products) {
                System.out.println(product);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
