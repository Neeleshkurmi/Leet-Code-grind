package Recursion;

import java.util.Arrays;

public class Sum_triangle_from_array {
    public static void printTriangle(int[] A) {
        //return condition when the size of array is =s to 1
        //base condition
        if(A.length==1){
            return;
        }
        // temp array to store new values
        int [] temp = new int[A.length-1];
        //variable to get the size of A
        helper(temp,A,0);
        //giving the values of temp to function with recursive call
        printTriangle(temp);
        //prints String format of temp Array//
        System.out.println(Arrays.toString(temp));

    }

    private static int [] helper(int[] temp, int[] A, int index) {
        //base condition
        if(index==A.length-1){
            return temp;
        }
        //to store the consecutive sum of A
        temp [index]= A[index]+A[index+1];
        //recursive call
         return helper(temp, A, index+1);
    }

    public static void main(String[] args) {
        //input Array
        int[] x = { 1, 2, 3, 4, 5 };
        //Recursive function that will print answer
        printTriangle(x);
        System.out.println(Arrays.toString(x));
    }
}
