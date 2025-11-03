package Exeracise;

public class Transpose {
    public static void main(String[] args) {
        int[][] arr={
                {1,2,3},
                {4,5,6}
        };
        System.out.println("the original matrix:");
        for (int i=0; i<= arr.length; i++){
            for(int j=0; j<= arr[1].length;j++) {
                System.out.println(arr[i][j]);
            }
        }
        System.out.println("transpose of matrix");
        for (int i=0; i<=arr[0].length;i++){
            for(int j=0; j<= arr.length; j++){
                System.out.println(arr[1][j]);
            }
        }
    }
}
