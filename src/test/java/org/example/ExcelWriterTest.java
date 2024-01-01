package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExcelWriterTest {

    @Test
    void writeProductsToExcel() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product1", 100, "Description1"),
                new Product(2, "Product2", 200, "Description2")
        );

        String filePath = "C:\\My PC\\products.xlsx";

        ExcelWriter.writeProductsToExcel(products,filePath);

        File file = new File(filePath);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }
}