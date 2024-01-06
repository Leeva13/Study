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

    private static final String API_ENDPOINT = "https://fakestoreapi.com/products";

    public List<Product> fetchProducts() throws IOException {
        URL url = new URL(API_ENDPOINT);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            try (var reader = connection.getInputStream()) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                JsonNode jsonArray = objectMapper.readTree(reader);

                List<Product> products = new ArrayList<>();


                if (jsonArray.isArray()) {
                    for (JsonNode productNode : jsonArray) {
                        Product product = objectMapper.treeToValue(productNode, Product.class);
                        products.add(product);
                    }
                }

                return products;
            }
        } else {
            throw new IOException("Failed to fetch products. HTTP error code: " + connection.getResponseCode());
        }
    }
}
