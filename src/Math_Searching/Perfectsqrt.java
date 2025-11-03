package Math_Searching;

public class Perfectsqrt {
    public static boolean isPerfectSquare(int num) {
        boolean isperfect= false;
       double ans = Math.pow(num,0.5);
       if(ans%1==0){
           isperfect= true;
           return isperfect;
       }
       return isperfect;
    }

    public static void main(String[] args) {
        int n= 16, n1 =14;
        System.out.println(isPerfectSquare(n));
        System.out.println(isPerfectSquare(n1));
    }
}
