package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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
        printProducts(products);
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
        System.out.println("Информация о продуктах:");
        int i = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            i++;
            System.out.println(products[i - 1].id + ", " + products[i - 1].name + ", " + products[i - 1].price + ", " + products[i - 1].count);
        }
    }

    /**
     * Возвращает Product по его id
     *
     * @param id идентификатор нужного продукта
     */
    static Product getById(int id) throws FileNotFoundException {
        Product[] products = load(FILENAME);
        System.out.println("Нужный вам продукт:");
        Scanner sc = new Scanner(new FileInputStream("products.txt"));
        int i = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (products[i].id == id) {
                System.out.println(products[i].id + ", " + products[i].name + ", " + products[i].price + ", " + products[i].count);
            }
            i++;
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
        int i = 0;
        int max = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (products[i].price > max  ) {
                 max = products[i].price;
            }
            i++;

        }
        int m = 0;
        while(sc2.hasNextLine()){
            String s2 = sc2.nextLine();
            if (products[m].price == max) {
                System.out.println("Самый дорогой продукт:");
                System.out.println(products[m].id + ", " + products[m].name + ", " + products[m].price + ", " + products[m].count);
            }
            m++;
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
