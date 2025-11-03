package Exeracise;

import java.util.Scanner;

public class transposeOfmt {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the rows:");
        int rows = sc.nextInt();
        //no of rows
        System.out.println("enter the columns:");
        int cols = sc.nextInt();
        //nio of columns
        int[][] matrix = new int[rows][cols];
        System.out.print("enter the matrix:");
        //for getting matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("your matrix is:");
        for (int i = 0; i < rows; i++) {
            //for printing original matrix
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            //for moving into new line
            System.out.println();
        }
        //transpose of the matrix
        System.out.println("transpose of the matrix: ");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            //for moving into new line
            System.out.println();
        }
    }
}
