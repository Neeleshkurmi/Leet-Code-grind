package Methods;

import java.util.Arrays;

public class Palindrome_Using_BinarySeaarch {
    public static void main(String[] args) {
        for (int i = 0; i <1000; i++) {
            if(palindrome(i)==true){
                System.out.println(i);
            }
        }
   }

    public static boolean palindrome(int n){
        String New= Integer.toString(n);
        int start =0;
        int end = New.length()-1;
        while (start <= end) {
            if(end==start) return true;

            if(New.charAt(start)==New.charAt(end)){
                end--;start++;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
