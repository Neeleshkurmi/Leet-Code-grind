package Recursion;

public class Recursion_questions {
    public static void main(String[] args) {
        System.out.println(factorial(9));
//     PrintN_Numbers(10);
     PrintN_Numbers_decreasing(10);
    }
    public static int factorial(int n){
        //base condition
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void PrintN_Numbers(int n){
        //base condition
        if(n<1){
            return;
        }
        PrintN_Numbers(n-1);
        System.out.println(n);
    }
    public static void PrintN_Numbers_decreasing(int n){
        //base condition
        if(n<1){
            return;
        }
        System.out.println(n);
        PrintN_Numbers_decreasing(n-1);

    }
    public static int palindrome(int n, int rem){
        if(n/10==0){
            return n;
        }
        rem = n%10;
        return palindrome(n/10,n/10);

    }
}
