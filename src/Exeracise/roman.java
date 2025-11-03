package Exeracise;

import java.util.Scanner;

public class roman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");

        int num = sc.nextInt();

        // Process each symbol in descending order of value
        while (num >= 1000) {
            System.out.print("M");
            num -= 1000;
        }

        if (num >= 900) {
            System.out.print("CM");
            num -= 900;
        }

        if (num >= 500) {
            System.out.print("D");
            num -= 500;
        }

        if (num >= 400) {
            System.out.print("CD");
            num -= 400;
        }

        while (num >= 100) {
            System.out.print("C");
            num -= 100;
        }

        if (num >= 90) {
            System.out.print("XC");
            num -= 90;
        }

        if (num >= 50) {
            System.out.print("L");
            num -= 50;
        }

        if (num >= 40) {
            System.out.print("XL");
            num -= 40;
        }

        while (num >= 10) {
            System.out.print("X");
            num -= 10;
        }

        if (num >= 9) {
            System.out.print("IX");
            num -= 9;
        }

        if (num >= 5) {
            System.out.print("V");
            num -= 5;
        }

        if (num >= 4) {
            System.out.print("IV");
            num -= 4;
        }

        while (num >= 1) {
            System.out.print("I");
            num -= 1;
        }

        sc.close();
    }
}


