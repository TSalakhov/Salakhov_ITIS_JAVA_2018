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
        Product product = getById(4);
        System.out.println("id : " + product.id + ", " + "название : " + product.name + ", " + "цена : " + product.price + ", " + "количество :" + product.count);
        Product product1 = getMostExpensiveProduct();
        System.out.println("id : " + product1.id + ", " + "название : " + product1.name + ", " + "цена : " + product1.price + ", " + "количество :" + product1.count);
        sortByPrice(products);
        printProducts(products);

    }

    /**
     * Выводит на консоль информацию о содержимом массива продуктов
     *
     * @param products продукты, которые будут распечатаны
     */
    static void printProducts(Product[] products) throws FileNotFoundException {
        System.out.println("Информация о продуктах:");
        for (int i = 0; i < products.length; i++) {
            System.out.println("id : " + products[i].id + ", " + "название : " + products[i].name + ", " + "цена : " + products[i].price + ", " + "количество" + products[i].count);

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
        int i = 0;
        while (i <= 4) {
            if (products[i].id == id) {
                return products[i];
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
        int i = 0;
        int max = 0;
        while (i < products.length) {
            if (products[i].price > max) {
                max = products[i].price;
            }
            i++;

        }
        i = 0;
        int m = 0;
        while (i < products.length) {
            if (products[m].price == max) {
                System.out.println("Самый дорогой продукт:");
                return products[m];
            }
            m++;
            i++;
        }
        return null;
    }

    static void sortByPrice(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - 1; j++) {
                if (products[j].price > products[j + 1].price) {
                    //перестановка
                    Product[] products2 = new Product[products.length];
                    products2[j] = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = products2[j];


                }

            }
        }
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
