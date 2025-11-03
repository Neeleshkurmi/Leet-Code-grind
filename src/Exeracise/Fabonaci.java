package Exeracise;

import java.util.Scanner;

public class Fabonaci {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
        System.out.println("enter the value of n:");
int n=sc.nextInt();
        int a=0;
        int b=1;
        int sum;
        System.out.println("0");
        for(int i=1; i<=n; i++){
            sum=a+b;
            b=a;
            a=sum;

                System.out.println(sum);

        }




    }
}
