package Exeracise;

import java.util.Scanner;

public class TableOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        int m=10;
        for(int i=1;i<=m;i++){
            System.out.println(i+"x"+n+"="+(i*n));
        }
    }
}
