package Exeracise;

public class TwoDArray2 {
    public static void main(String[] args) {
        boolean[][] arr={{true,false,true},
        {false,true,false}};
        int rows= arr.length;
        int cols= arr[0].length;
       for(int i=0; i<=rows; i++){
           for(int j=0; j<=cols; j++){
               if(arr[i][j]== true){
                   System.out.println("T");
               }
               else{
                   System.out.println("F");
               }

           }
       }
    }
}
