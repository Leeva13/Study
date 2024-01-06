package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriter {

    public static void writeProductsToExcel(List<Product> products, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Products");

            int rowNum = 0;
            Row headerRow = sheet.createRow(rowNum++);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Title");
            headerRow.createCell(2).setCellValue("Price");
            headerRow.createCell(3).setCellValue("Description");

            for (Product product : products) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(product.getId());
                row.createCell(1).setCellValue(product.getTitle());
                row.createCell(2).setCellValue(product.getPrice());
                row.createCell(3).setCellValue(product.getDescription());
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            ProductFetcher productFetcher = new ProductFetcher();
            List<Product> products = productFetcher.fetchProducts();

            // Тут вказуєте свій шлях до місця збереження файлу
            String filePath = "C:\\My PC\\products.xlsx";
            ExcelWriter.writeProductsToExcel(products, filePath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
