package Recursion;

public class Linear_Search {
    public static boolean search(int [] arr, int target, int starting_index){
        //Base condition
        if(starting_index== arr.length-1 && arr[starting_index]!=target){
            return false;
        }
        return arr[starting_index]==target ? true : search(arr, target, starting_index+1);
    }

    public static void main(String[] args) {
        int[] arr={4,2,3,5,8,7,1};
        System.out.println(search(arr,1,0));
    }
}
