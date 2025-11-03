package Math_Searching;

public class Peak_Index {

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[] {3,4,5,1})+"=2");
        System.out.println(peakIndexInMountainArray(new int[] {0,2,1,0})+"=1");
        System.out.println(peakIndexInMountainArray(new int []{0,1,0})+"=1");
        System.out.println(peakIndexInMountainArray(new int[] {0,2,3,5,3,2,1,0})+"=3");
        System.out.println(peakIndexInMountainArray(new int[]{3,5,5,2,0})+"=-1");
        System.out.println(peakIndexInMountainArray(new int[]{2,1,3})+"=-1");
    }


    public static int peakIndexInMountainArray(int[] arr) {
        int start =0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;
            if (arr[mid]==arr[end]&& arr[mid]==arr[start]){
                return mid;
            }
           else if (arr[mid]>arr[mid +1]){
                end = mid;
           }
            else if(arr[mid] < arr[mid +1]){
                start = mid + 1;
            }
        }
        return -1;
    }

}
