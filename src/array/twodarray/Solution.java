package array.twodarray;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {

        int [][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}

                // [1, 4, 7],
                // [2, 5, 8],
                // [3, 6, 9],
        };

        int [][] transpose= transpose(arr);
        System.out.println(Arrays.deepToString(transpose));

        System.out.println(Arrays.deepToString(transpose));
    }


    static int[][] transpose(int[][] arr){
        for(int row=0; row<arr.length; row++){
            for(int col=row+1; col<arr[0].length; col++){
                swap(arr,row,col);
            }
        }
        return arr;
    }

    static void swap(int [][] arr, int i,int j){
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
}
