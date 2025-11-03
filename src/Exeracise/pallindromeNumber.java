package Exeracise;

import java.util.Scanner;

public class pallindromeNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = sc.nextInt();

        int OriginalNumber=number;
        int ReversedNumber=0;

        while (number>0){
            int Reminder=number%10;
            ReversedNumber=ReversedNumber*10+Reminder;
            number=number/10;

        }
        if(OriginalNumber==ReversedNumber){
            System.out.println(OriginalNumber+" is a pallindrome number");
        }else {
            System.out.println(OriginalNumber+" is not a pallindrome number");
        }
    }
}
