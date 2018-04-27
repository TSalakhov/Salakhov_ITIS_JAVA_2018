package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = 0;
                System.out.println(arr[i][j]);
            }
        }

        for (int i = 5; i < 0; i--) {
            arr[i][i] = 1;
            System.out.println(arr[i][i] + "/t");
        }

    }
}