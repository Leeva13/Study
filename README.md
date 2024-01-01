Product API Integration and Excel Export
This Java project demonstrates the integration with a product API and the export of retrieved product data to an Excel file.

Features:
Product Data Retrieval:

Utilizes the Escuela API to fetch a list of 200 products.
Parses the JSON response using Jackson Databind library.
Excel Export:

Uses Apache POI library to create an Excel workbook.
Iterates through the list of products and populates rows in the Excel sheet.
Exports the data to an Excel file named products.xlsx.
