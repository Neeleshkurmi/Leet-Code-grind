package Exeracise;

import java.util.Scanner;

public class TwoSum {

        public static void main(String[] args) {
            Scanner sc =new Scanner(System.in);

            System.out.println("enter the size of array");
            int n=sc.nextInt();
            int[] array= new int [n];
            System.out.println("enter elements for array");
            for(int i=0; i<=n; i++){
                array [i]=sc.nextInt();

            }
            int target = sc.nextInt();


            for (int i = 0; i <= array.length; i++) {
                for (int j = 1; j <= array.length; j++) {
                    if (i * j == target) {
                        System.out.println("["+i+","+j+"]"+"="+target);

                    }
                }
            }


      }
    }


