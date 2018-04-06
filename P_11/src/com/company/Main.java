package com.company;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Storage storage = new Storage();
        storage.getAllProducts();
storage.sortByPrice();
    }

    static void printProducts(List<Product> list) {
        System.out.println("id| name       |price|count");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).id + " | " + list.get(i).name + " | " + list.get(i).price + " | " + list.get(i).count);
        }
    }
}
