package Recursion;

public class ReverseANumber {
    public static void main(String[] args) {
        int n= 9;
        System.out.print("the provided number is palindrome or not: ");
        System.out.println(palindrome(n,0)==n);

    }
    static void ReverseNum(int n) {
        if(n==0){
            return;
        }
        System.out.print(n%10);
        ReverseNum(n/10);
    }
    static int palindrome(int n, int ans){
        if(n==0){
            return ans;
        }
        ans = (ans*10)+(n%10);
        return palindrome(n/10,ans);
    }
}
