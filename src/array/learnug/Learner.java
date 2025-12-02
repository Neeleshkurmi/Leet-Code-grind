package array.learnug;

public class Learner {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7},8));
    }
    
    public static int binarySearch(int [] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
             int mid = start+(end-start)/2;

             if(arr[mid] == target) return mid;

             else if(arr[mid]<target){
                 start = mid+1;
             }

             else if(arr[mid]>target){
                 end = mid-1;
             }
        }
        return -1;
    }
    public static int sum(int[] nums){
        int sum =0;
        for (int a: nums){
            sum = sum + a;
        }
        return sum;
    }
    public static int search(int[] nums, int target){

        for (int i=0; i< nums.length; i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}