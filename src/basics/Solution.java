package basics;

public class Solution {

    public static void main(String[] args) {
        System.out.println(binaryToDecimal(110101));
        System.out.println(binaryToDecimal(100));
    }

    static int ocatalToDecimal(int n){

        return 0;
    }



    static int binaryToDecimal(int n){
        int ans=0, i=0;
        while (n>0){
            if(n%10!=0){
                ans += (int)(Math.pow(2,i));
            }
            i++;
            n/=10;
        }
        return  ans;
    }

    static int LCM(int a, int b){
        return a*b /HCF(a,b);
    }

    static int euclideanHCF(int a, int b){
        return a==0? b: euclideanHCF(b%a,a);
    }

    static boolean isArmStrong(int num){
        int temp = num;
        int ans =0;
        int length = String.valueOf(num).length();
        while(num>0){
            int rem = num%10;
            ans += (int) Math.pow(rem,length);
            num /=10;
        }
        return  ans == temp;
    }

    static int HCF(int a, int b){
        while(b!=0){
            int temp = b;
            b = b%a;
            a = temp;
        }
        return a;
    }

    static int isArmStrong(int num, int numberOfDigits){
        if(num<=0) return 0;

        return (int)(Math.pow(num%10,isArmStrong(num/10,numberOfDigits)));
    }


    static int sumOfDigits(int num){
        int ans =0;
        while (num>0){
            ans += num %10;
            num/=10;
        }
        return ans;
    }
    static int max(int a, int b){
        return a>b ? a : b;
    }
    static int secondMax(int a, int b, int c){
        if(a>b && a<c) return a;
        else if(b>a && b<c) return b;
        else return c;
    }

    static boolean isPalindrome(int num){
        int reverse = reverseNum(num);
        return num==reverse;
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

    static int reverseNum(int n){
        int ans=0;
        while(n>0){
            int rem = n%10;
            n /=10;
            ans = ans * 10 + rem;
        }
        return ans;
    }
}
