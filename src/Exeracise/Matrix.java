package Exeracise;

import java.util.Scanner;




public class Matrix {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of rows: ");
        int rows= sc.nextInt();
        System.out.println("enter number of colums: ");
        int cols= sc.nextInt();
        int [][] numbers = new int[rows][cols];

        for(int i=0; i<rows;i++){
            for(int j=0; j<cols; j++){

                numbers[i][j]= sc.nextInt();
            }
        }
         Scanner close;
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                System.out.print(numbers[i][j]+" ");
            }
            System.out.println();
        }



    }
}
