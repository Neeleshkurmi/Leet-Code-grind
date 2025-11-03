package Math_Searching;

import java.util.Arrays;

public class Negative_Numbers {
    public static void main(String[] args) {
        int[][] arr1 = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        int[][] arr = {
                {3, 2},
                {1, 0}
        };
        System.out.println(countNegatives(arr1));
    }
    public static int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count =0;
        int row = 0;
        int column = grid[0].length-1;

        while(row< grid.length && column >=0){
            if(grid[row][column] >= 0){
                row++;
            }
            else{
                count+=(grid[0].length-row);
                column--;
            }
        }
        return count;
    }

}
