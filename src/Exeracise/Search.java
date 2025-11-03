package Exeracise;

public class Search {
    public static void main(String[] args) {
        //initialisation of matrix
        int[][] arr={{23,45,67},{89,90,34}};
        //largest no og matrix
        int x=90;
        System.out.println("the original matrix is:");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("the largest no from your matrix is:");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==x){
                    System.out.println(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
