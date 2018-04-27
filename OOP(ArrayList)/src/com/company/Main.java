package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    final static String FILENAME = "products.txt";

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Product> list = load(FILENAME);
        printProducts(list);
        ArrayList<Product> list2 = new ArrayList<Product>();
        list2.add(getById(2));
        System.out.println(list2.get(0).id + ", " + list2.get(0).name + ", " + list2.get(0).price + ", " + list2.get(0).count);
        getMostExpensiveProduct();
        ArrayList<Product> list3 = new ArrayList<Product>();
        list3.add(getMostExpensiveProduct());
        System.out.println(list3.get(0).id + ", " + list3.get(0).name + ", " + list3.get(0).price + ", " + list3.get(0).count);

    }


    /**
     * Выводит на консоль информацию о содержимом массива продуктов
     */
    static void printProducts(ArrayList<Product> list) {
        System.out.println("id| name       |price|count");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).id + " | " + list.get(i).name + " | " + list.get(i).price + " | " + list.get(i).count);
        }
    }

    static void sortByPrice(ArrayList<Product> list) {

        for (int i = 0; i < list.size(); i++) {
            ArrayList<Product> list2 = new ArrayList<Product>();
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j + 1).price < list.get(j).price) {
                    list2.add(list.get(j));
                    list.add(j, list.get(j + 1));
                    list.add(j + 1, list2.get(i));
                }
            }
        }
    }

    static Product getById(int id) throws FileNotFoundException {
        ArrayList<Product> list = load(FILENAME);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                return list.get(i);
            }
        }
        return null;
    }

    /**
     * Возвращает самый дорогой Product, имеющийся на складе
     *
     * @return
     */
    static Product getMostExpensiveProduct() throws FileNotFoundException {
        ArrayList<Product> list = load(FILENAME);
        Product productWithMaxPrice = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).price > productWithMaxPrice.price) {
                productWithMaxPrice = list.get(i);
            }
        }
        return productWithMaxPrice;
    }


    static ArrayList<Product> load(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(fileName));
        ArrayList<Product> list = new ArrayList<Product>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] elements = s.split(", ");
            Product product = new Product(Integer.parseInt(elements[0]),
                    elements[1],
                    Integer.parseInt(elements[2]),
                    Integer.parseInt(elements[3]));
            list.add(product);
        }
        return list;
    }

}


