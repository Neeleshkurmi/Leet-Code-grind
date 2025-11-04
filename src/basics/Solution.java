package basics;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(replaceZeros(120014));
    }

    static int replaceZeros(int n){
        int ans=0;
        while(n>0){
            int rem = n%10;
            n /=10;
            if(rem ==0){
                ans = ans * 10 + 1;
            }
            else {
                ans = ans * 10 + rem;
            }
        }
        return reverseNum(ans);
    }


    static double[] rootsOfEq(int a, int bx, int c){
        double dicriminent = Math.pow(bx, 2) - 4 * a * c;
        double ans1 = -bx + Math.sqrt(dicriminent);
        double ans2 = -bx - Math.sqrt(dicriminent);
        return ans1==ans2 ? new double[] {ans1} : new double[] {ans2,ans1};
    }


    static int hexaDecimalToDecimal(String s){
        s.toLowerCase();
        int a = 10, A=10, b=11, B=11, c=12, C=12,d=13, e=14, E=14, f=15, F=15;
        int ans =0, i=0;
        for(int j=s.length()-1; j>=0; j--){
            char ch = s.charAt(j);
            if(ch=='a' || ch=='b' || ch =='c' || ch =='d' || ch=='e' || ch =='f') {
                switch (ch) {
                    case 'a':
                        ans += (int) (a * Math.pow(16, i));
                        break;
                    case 'b':
                        ans += (int) (b * Math.pow(16, i));
                        break;
                    case 'c':
                        ans += (int) (c * Math.pow(16, i));
                        break;
                    case 'd':
                        ans += (int) (d * Math.pow(16, i));
                        break;
                    case 'e':
                        ans += (int) (e * Math.pow(16, i));
                        break;
                    case 'f':
                        ans += (int) (f * Math.pow(16, i));
                }
            }
            else {
                ans += (int) ((ch-'0') * Math.pow(16, i));
            }
            i++;
        }
        return ans;
    }

    static int ocatalToDecimal(int n){
        int ans =0, i=0;
        while (n>0){
            int rem = n%10;
            ans += (int)(rem*Math.pow(8,i++));
            n/=10;
        }
        return ans;
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
