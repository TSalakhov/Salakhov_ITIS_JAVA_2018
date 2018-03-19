package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.ProxySelector;
import java.util.Scanner;

public class Main {
    final static String FILENAME = "products.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Product p = new Product(77, "Бублики", 21, 8);
        Product p1 = new Product(21, "dfgsdfg", 11, 8);
        Product[] prs = new Product[2];
        prs[0] = p;
        prs[1] = p1;

        Product[] products = load(FILENAME);
        printProducts(  );
        getById(3);
        getMostExpensiveProduct();
    }

    /**
     * Выводит на консоль информацию о содержимом массива продуктов
     *
     * @param products продукты, которые будут распечатаны
     */
    static void printProducts(Product[] products) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("products.txt"));
        Scanner sc2 = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc2.nextLine();
            String[] elements = s.split(", ");
            System.out.println(elements[0] + elements[1] + elements[2] + elements[3]);

        }
    }

    /**
     * Возвращает Product по его id
     *
     * @param id идентификатор нужного продукта
     */
    static Product getById(int id) throws FileNotFoundException {
        Product[] products = load(FILENAME);
        Scanner sc = new Scanner(new FileInputStream("products.txt"));
        Scanner sc2 = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] elements = s.split(", ");
            if (Integer.parseInt(elements[0]) == id) {
                System.out.println(elements[0] + ", " + elements[1] + ", " + elements[2] + ", " + elements[3]);
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
        Product[] products = load(FILENAME);
        Scanner sc = new Scanner(new FileInputStream("products.txt"));
        Scanner sc2 = new Scanner(new FileInputStream("products.txt"));
        int max = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] elements = s.split(", ");
            if (Integer.parseInt(elements[2]) > max) {
                max = Integer.parseInt(elements[2]);
            }
        }
            while (sc2.hasNextLine()) {
                String s2 = sc2.nextLine();
                String[] elements2 = s2.split(", ");
                if (Integer.parseInt(elements2[2]) == max){
                    System.out.println(elements2[0] +", " + elements2[1] + ", " + elements2[2] + ", " + elements2[3]);
                }
            }


        return null;
    }


    static Product[] load(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(fileName));
        Product[] products = new Product[countOfItems(fileName)];
        int count = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] elements = s.split(", ");
            Product product = new Product(Integer.parseInt(elements[0]),
                    elements[1],
                    Integer.parseInt(elements[2]),
                    Integer.parseInt(elements[3]));
            products[count] = product;
            count++;
        }
        return products;
    }

    static int countOfItems(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        int count = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            count++;
        }
        return count;
    }

    static void add(Product product) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("products.txt", true));
        pw.println(product.id + ", " + product.name + ", " + product.price + ", " + product.count);
        pw.close();
    }
}
