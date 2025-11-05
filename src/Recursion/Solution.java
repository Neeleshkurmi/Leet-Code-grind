package Recursion;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
//        printNumAsc(8);
//        printNumDesc(8);
//        int n=8;
//        System.out.println((n*(n+1))/2 ==sumOfN(n));
//        System.out.println(fibo(5));  // 0,1,1,2,3,5 expected output -- 5

//        System.out.println(pow(2,3));
//        System.out.println(isPrime(191,2));
        System.out.println(min(new int[]{6,7,4,3,-1},0));

        int[] arr = {1,2,3,4};
        reverse(arr,3,0);
        System.out.println(Arrays.toString(arr));
    }



    static void reverse(int[] arr, int i,int j){
        if(j>=i) return;
        swap(arr,i,j);
        reverse(arr,i-1,j+1);
    }

    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int min(int[] arr, int i){
        if(i== arr.length-1) return arr[i];
        int min = min(arr,i+1);
        return Math.min(min,arr[i]);
    }

    //largest element in the array
    //[7,8,5,2,4]

    static int max(int[] arr, int i){
        if(i==arr.length-1) return arr[i];
        int max = max(arr,i+1);
        return Math.max(max,arr[i]);
    }

    //prime using recursion
    static boolean isPrime(int num,int i){
        if(num<2) return false;
        else if(num%i==0) return false;
        else if(i>=Math.sqrt(num)) return true;
        return isPrime(num,i+1);
    }


    //num 2*f(2)
    // num 2*f(2)
     // num 2*f(2^1) --return 2

    static int pow(int num,int pow){
        if(pow==1) return num;
        return num*pow(num,pow-1);
    }

    public static void printNumAsc(int num){
        if(num==0){
            return;
        }
        printNumAsc(num-1);
        System.out.println(num);
    }



    public static void printNumDesc(int num){
        if(num==0){
            return;
        }
        System.out.println(num);
        printNumDesc(num-1);
    }

    public static int fibo(int num){
        if(num==1 || num==0) return num==0 ?0:1;

        return fibo(num-1) + fibo(num-2);
    }

    public static int sumOfN(int num){
        if(num==0) return 0;
        return num+= sumOfN(num-1);
    }







    /*
    n =8

        num(8)
        -num(7)
          -num(6)
             -num(5)
               -num(4)
                -num(3)  -print(3) -return
                  -num(2)  --print(2) -return
                    -num(1) --print(1) -return
                     -num(0)- return
     */
}
