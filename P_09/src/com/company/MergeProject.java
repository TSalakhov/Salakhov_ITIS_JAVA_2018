package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MergeProject {
    final static String FILENAME = "products.txt";

    public static void main(String[] args) throws FileNotFoundException {
//        int[] array1 = {-1, 0, 1, 3, 5, 9};
//        int[] array2 = {4, 6, 8, 10, 12, 13, 21};
//        int[] res;
//        res = merge(array1, array2);
//        System.out.println(Arrays.toString(res));

        Product[] products = load(FILENAME);
        products = mergeSort(products);

    }

    static Product[] mergeSort(Product[] products) {
        int n = products.length;
        if (n <= 2) {
            if (n == 2) {
                if (products[0].price > products[1].price) {
                    Product product = products[0];
                    products[1] = products[0];
                    product = products[1];


                }
            }
            return products;
        } else {
            int l1, l2;
            if (n % 2 == 0) {
                l1 = n / 2;
                l2 = n / 2;
            } else {
                l1 = (n + 1) / 2;
                l2 = n / 2;
            }
            int[] arr1 = new int[l1];
            int[] arr2 = new int[l2];
            Product[] products2 = new Product[l1];
            Product[] products3 = new Product[l2];
            for (int i = 0; i < l1; i++) {
                products2[i] = products [i];
            }
            for (int i = l1; i < n & i < l1; i++) {
                products3[i - l1].price = products[i].price
                 products3[i - l1]  = products[i];
            }
            products2 = mergeSort(products2);
            products3 = mergeSort(products3);
            return merge(products2,products3);
        }
    }


    static Product[] merge(Product[] products2, Product[] products3) {
        int l1 = products2.length;
        int l2 = products3.length;
        Product[] resultArr = new Product[l1 + l2];
        int i1 = 0, i2 = 0;
        while (i1 < l1 & i2 < l2) {
            if (products2[i1].price < products3[i2].price) {
                resultArr[i1 + i2] = products2[i1];
                i1++;
            } else {
                resultArr[i1 + i2] = products3[i2];
                i2++;
            }
        }
        while (i1 < l1) {
            resultArr[i1 + i2] = products2[i1];
            i1++;
        }
        while (i2 < l2) {
            resultArr[i1 + i2] = products3[i2];
            i2++;
        }
        return resultArr;
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

}
