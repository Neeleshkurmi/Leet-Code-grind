package Exeracise;




public class TwoDArrays {
        public static void main(String[] args) {
            boolean[][] array = {{true, false, true},
                    {false, true, false}};
            int rows = array.length;
            int cols = array[0].length;
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    if(array[i][j]==true){
                        System.out.print(" t");
                    } else{
                        System.out.print(" f");
                    }
                }
 

                System.out.println();
            }

            }
        }



