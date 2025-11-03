package Exeracise;

public class posetiveOrnegative {
    public static void main(String[] args) {
        int[]arr= {-1,2,-6,5,6,8,-9,-3};
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                System.out.print(arr[i]+",");
            }
        }
        System.out.print("][");
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                System.out.print(arr[i]+",");
            }
        }
        System.out.println("]");
    }
}
