package Methods;

import java.util.Scanner;
//table method
public class Methods {
    static int multiplication(int a) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "x" + a + "=" + i * a);
        }
        return 0;
    }


    //pattern
    //*
    //**
    //***
    //****

    static void pattern1(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    //sum of first n natural numbers
    static void sum(int n) {
        int sum = 0;

        for (int i = 0; i <= n; i++) {

            sum += i;

        }
        System.out.println(sum);

    }
    //****
    //***
    //**
    //*
    static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //fibonacci series 0,1,1,2,3,5,8,13.......
    static void fibonaci(int n) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        n = sc.nextInt();
        int b = 1;
        int sum = 0;
        System.out.print(a);
        for (int i = 1; i <= n; i++) {
            sum = a + b;
            b = a;
            a = sum;
            System.out.print("," + sum);
        }

    }

    //Reversed string
    static void ReversedString(String arg) {
        System.out.println("Original String :-" + arg);
        char[] ar = arg.toCharArray();
        System.out.print("Reversed String :");
        for (int i = ar.length - 1; i >= 0; i--) {
            System.out.print(ar[i]);
        }
    }

    //average of n numbers
    static int average(int... numbers) {

        if (numbers.length == 0) {
            throw new IllegalArgumentException("no numbers provided");
        }
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        return sum / numbers.length;

    }
    //middle character of string

    static void MiddleOfString(String a) {

        char[] chararray = a.toCharArray();
        int middle = a.length() / 2;
        if (a.length() % 2 == 0) {
            System.out.print(chararray[middle - 1]);
            System.out.println(chararray[middle]);
        } else {
            System.out.println(chararray[middle]);
        }
    }


    static int numberOfvowels(String mystring) {
        int length = mystring.length();
        int count = 0;
        for (int i = 0; i <= mystring.length() - 1; i++) {
            if (mystring.charAt(i) == 'a' || mystring.charAt(i) == 'e' || mystring.charAt(i) == 'i' || mystring.charAt(i) == 'o' || mystring.charAt(i) == 'u') {
                count++;
            }

        }
        System.out.println(count);
        return count;
    }

    static int sumofdigits(int a) {
        int res = 0;
        while (a > 0) {
            res += a % 10;
            a /= 10;
        }

        return res;
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }

        }
        return new int[]{};
    }
//pentagon numbers
    static void pentagon(int n){
        int count=0;
        for(int i=1; i<=n; i++){
            count=i*(3*i-1)/2;
            System.out.print("  "+count);
        }

    }

    public static void main(String[] args) {
       /* Scanner sc= new Scanner(System.in);
       // int a= sc.nextInt();
       // multiplication(a);
       //sum(8);

        pattern2(8);*/
              //fibonaci(0);
        //ReversedString("Hellow");
        // int j= average(23,45,67,89,55);
        // System.out.println("average of numbers:-"+j);
        // middle("Method");
        // middle("LeetCode");
        //middle("Null");
        //middle("Day");
        //middle("350");
        //middle("1234");
        //numberOfvowels("quality");
        // numberOfvowels("appearance");
//int r=sumofdigits(27895);
        //      System.out.println(r);
        //    System.out.println(sumofdigits(6425));
pentagon(56);
    }


}
