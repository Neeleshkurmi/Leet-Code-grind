package Math_Searching;

public class ArrangeCoins {
    public static int arrangeCoins(int n) {
        int i=1;
        while(n>=i){
            n-=i;
            i++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        int n= 8;
        System.out.println(arrangeCoins(n));
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(15));
    }
}
