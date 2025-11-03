package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static boolean isPowerOfFour(int n) {

//        if(n==1 || n==4) return true;
//        if(n<12) return false;

        int x = (int) (Math.log(n)/Math.log(4));

        return Math.pow(4,x)==n;
    }
    public static boolean isPrime(int n){
        if(n<2){
            return false;
        } else if (n==2) {
            return true;
        }
        for(int i=2; i<Math.sqrt(n)+1; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static String  isPrime2(int n){
        for(int i=2; i<Math.sqrt(n)+1; i++){
            if(n%i==0){continue;}
            else {
                return String.valueOf(i);
            }
        }
        return "";
    }

    public static int fibo(int n){
        if (n==0) return 0;
        else if(n==1) return 1;
        return fibo(n-1) + fibo(n-2);
    }
    public static int prime(int n){
        List<Integer> list = new ArrayList<>();
        for(int i=2; i<=n+3; i++){
            if(isPrime(i)){
                list.add(i);
            }
        }
        int m = list.get(n-2);
        return m;
    }

    public static int fiboAndPrime(int n) {
        int result = 0;
        int nums = n / 2;
        if (n % 2 == 0) {
            return prime(nums);
        }
        return fibo(nums);
    }

    public static void main(String[] args) {
//        System.out.println(isPowerOfFour(13));
        System.out.println(fiboAndPrime(5));
    }
}
