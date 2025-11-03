package Exeracise;

import java.util.Scanner;

public class EuclideanAlgo {
    public static int main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int remainder=0;



        for(int i=0;; i++){
            remainder=a%b;
            a=b;
            b=remainder;
            if(remainder==0){
                break;
            }
        }
        return Math.abs(a);
}
}