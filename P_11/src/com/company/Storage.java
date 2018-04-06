package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        String sqlQuery = "SELECT * FROM product WHERE id = " + id;
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
        ResultSet rs = statement.executeQuery("SELECT * FROM products");
        ArrayList<Product> list2 = new ArrayList<Product>();
        ArrayList<Product> list3 = new ArrayList<Product>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int count = rs.getInt("count");
            Product p = new Product(id, name, price, count);
            list2.add(p);
        }
        for (int i = 0; i < list2.size(); i++) {
            for (int j = 0; j < list2.size() - 1; j++) {
                if (list2.get(j + 1).price < list2.get(j).price) {
                    list3.add(list2.get(j));
                    list2.add(j, list2.get(j + 1));
                    list2.add(j + 1, list3.get(i));
                }
            }
        }
        return list2;
    }
}

