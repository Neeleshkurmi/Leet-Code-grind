package Recursion;

public class Binary_search {
    public static int search(int[] arr, int target, int start, int end){

        //base condition
        if(start>end){
            return -1;
        }
        int mid = start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }
        return arr[mid]>target ? search(arr,target,start,mid-1) : search(arr,target,mid+1,end);
    }

    public static void main(String[] args) {
        int[] arr ={2,3,5,7,9,11,15};
        System.out.println(search(arr,7,0,6));
    }
}
