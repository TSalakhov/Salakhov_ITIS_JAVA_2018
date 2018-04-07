package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    Connection connection;

    public Storage() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/product_db",
                "postgres",
                "16012002");
    }

    List<Product> getAllProducts() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM products");
        List<Product> productList = new ArrayList<Product>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int count = rs.getInt("count");
            Product p = new Product(id, name, price, count);
            productList.add(p);
        }
        return productList;
    }

    Product getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * FROM products WHERE id = " + id;
        System.out.println(sqlQuery);
        ResultSet rs = statement.executeQuery(sqlQuery);
        rs.next();
        String name = rs.getString("name");
        int price = rs.getInt("price");
        int count = rs.getInt("count");
        Product product = new Product(id, name, price, count);
        return product;
    }

    void updateProductName(int id, String name) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlQuery = "UPDATE product SET name = '" + name +
                "' WHERE id = " + id;
        System.out.println(sqlQuery);
        statement.executeUpdate(sqlQuery);
    }

    ArrayList<Product> sortByPrice() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM products ORDER BY price");
        ArrayList<Product> list = new ArrayList<Product>();
        int i = 0;
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int count = rs.getInt("count");
            Product p = new Product(id, name, price, count);
            list.add(i, p);
            i++;
        }
        return list;
    }

    Product getMostExpensiveProduct() throws SQLException {
        ArrayList<Product> list = (ArrayList<Product>) getAllProducts();
        Product productWithMaxPrice = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).price > productWithMaxPrice.price) {
                productWithMaxPrice = list.get(i);
            }
        }
        return productWithMaxPrice;
    }
}

