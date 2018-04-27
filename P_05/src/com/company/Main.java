package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        getMostExpensiveProductId();
        System.out.println(getMostExpensiveProductId());
    }


    /**
     * Удаляет полностью запись о продукте
     *
     * @param id идентификатор продукта для удаления
     */
    static void delete(int id) throws FileNotFoundException {
        int Id = 2;
        Scanner sc = new Scanner(new FileInputStream("products.txt"));
        String str = sc.nextLine();
        String[] arr = str.split(", ");
        System.out.println("Введите идентификатор : ");
        Scanner sc2 = new Scanner(System.in);
        Id = sc2.nextInt();
        if (Integer.parseInt(arr[0]) == Id) {


        }

    }


    /**
     * Заменяет цену продукта
     *
     * @param id    идентификатор продукта
     * @param price новая цена продукта
     */
    static void changePrice(int id, int price) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("products.txt"));
        String str = sc.nextLine();
        String[] arr = str.split(", ");
        Scanner sc2 = new Scanner(System.in);
        id = sc2.nextInt();
        Scanner sc3 = new Scanner(System.in);
        price = sc3.nextInt();
    }

    /**
     * Возвращает id самого дорогого продукта, который присутствует на складе
     *
     * @return идентификатор такого продукта
     */
    static int getMostExpensiveProductId() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("products.txt"));
        int max = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] arr = str.split(", ");
            String str2 = sc.nextLine();
            String[] arr2 = str.split(", ");
          while (sc.hasNextLine()){

                int prev = Integer.parseInt(arr2[3]);
            }


            if (Integer.parseInt(arr[3]) > 0) {
                max = Integer.parseInt(arr[3]);
            }

        }
        return max;
    }
}


}
