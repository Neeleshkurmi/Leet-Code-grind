package Exeracise;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter a number:");
        int x=sc.nextInt();

        if(x%2==0||x%3==0){
            System.out.println(x+" is not a Prime number");
            if(x==2||x==3){
                System.out.println(x+" is a Prime number");
            }
        }
        else{
            System.out.println(x+" is a Prime number");
        }
    }
}
