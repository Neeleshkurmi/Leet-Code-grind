package Exeracise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.print("enter location from the data to be deleted:");
        Scanner sc = new Scanner(System.in);
        int loc =sc.nextInt();
//        int data= sc.nextInt();
        int [] arr = {10, 20, 30, 90, 40, 70};
        if(arr.length!=0) {
            int k= arr.length-1;
         while (k>loc-1){
             arr[k]=arr[k-1];
             --k;
         }
         arr[loc]= 0;
        }

//
//
//        int k= arr.length-1;
//         while (k>loc-1){
//             arr[k]=arr[k-1];
//             --k;
//         }
//         arr[loc]= data;
//         Scanner sc = new Scanner(System.in);
//        System.out.print("Enter any number to be inserted at beginning:");

        System.out.println(Arrays.toString(arr));
    }
}
