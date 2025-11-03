package Exeracise;

import java.util.Scanner;

public class SumOfDigit {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();
        int quotient = num/10;
        int remainder = num%10;
        int res = remainder+quotient;
        System.out.println(res);
        }
}

