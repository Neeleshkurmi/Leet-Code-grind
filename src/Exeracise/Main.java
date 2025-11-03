package Exeracise;

import java.util.Scanner;
class Main {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number");
        int number= sc.nextInt();
        int OriginalNumber= number;
        int ReversedNumber=0;


        while (number>0){
            int Remainder=number%10;
            ReversedNumber=ReversedNumber*10+Remainder;
            number= number/10;
        }
        if(ReversedNumber== OriginalNumber){
            System.out.println(OriginalNumber+"is a Palindrome");
        }
        else{
            System.out.println(OriginalNumber+"is not a Palindrome");
        }


    }
}