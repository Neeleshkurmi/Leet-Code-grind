package Helpper;

import java.util.Arrays;

public class Binary_SearchIN2DArray {
    public static void main(String[] args) {
        int[] [] arr= {
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };
        System.out.println(Arrays.toString(Search(arr,4)));
    }
    public static int[] Search(int[][] matrix, int target){
        int row = 0;
        int column = matrix.length-1;

        while(row< matrix.length && column >=0){
            if(matrix[row][column] == target){
                return new int[] {row,column};
            }
            if(matrix[row][column]>target){
                column--;
            }
            else if (matrix[row][column]<target){
                row++;
            }
        }
        return new int[]{-1,-1};
    }
}
