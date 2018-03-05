package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Есть два файла с отсортированными последовательностями чисел
 * Необходимо слить числа из обоих файлов в третий так, чтобы
 * числа тоже были отсортированы
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new FileInputStream("file1.txt"));
        Scanner sc2 = new Scanner(new FileInputStream("file2.txt"));
        PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt"));
        int a1 = sc1.nextInt();
        int a2 = sc2.nextInt();
        while (sc1.hasNextInt() & sc2.hasNextInt()) {
            if (a1 < a2) {
                pw.println(a1);
                a1 = sc1.nextInt();
            } else {
                pw.println(a2);
                a2 = sc2.nextInt();
            }
        }
        if (!sc1.hasNextInt()) {
            pw.println(a1);
        }
        if (!sc2.hasNextInt()) {
            pw.println(a2);
        }
        //todo пока в file2 есть числа, выводить их в output
        //todo пока в file1 есть числа, выводить их в output
        while (sc2.hasNextInt()) {
            pw.println(a2);
            a2 = sc2.nextInt();
        }
        while (sc1.hasNextInt()) {
            pw.println(a1);
            a1 = sc1.nextInt();
        }
        pw.close();
    }

}