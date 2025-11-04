package basics;

public class Solution {

    public static void main(String[] args) {
        primeNumbers(0,10);
    }

    static int max(int a, int b){
        return a>b ? a : b;
    }
    static int secondMax(int a, int b, int c){
        if(a>b && a<c) return a;
        else if(b>a && b<c) return b;
        else return c;
    }

    static void primeNumbers(int start, int end){
        for (int i = start; i < end; i++) {
           if(isPrime(i)) System.out.println(i);
        }
    }

    static boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }

    static
}
