package array.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        int[] arr = {4,6,-2,-3};
//        mergeSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = {1, 2, 2, 1, 3};
        List<List<Integer>> map = freq(arr);
        System.out.println(map);
    }

    public static void mergeSort(int[] arr){
        int low = 0, high = arr.length-1;
        mergeS(arr,low,high);
    }

    public static void mergeS(int[] arr, int low, int high){
        if(low>=high) return;
        int mid = (low + high) /2;

        mergeS(arr,low,mid);
        mergeS(arr,mid+1, high);

        merge(arr, low, mid, high);
    }

    static List<List<Integer>> freq(int[] arr){
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            boolean found =false;

                for(int j=0; j<list.size(); j++){
                    if (list.get(j).get(0).equals(arr[i])) {
                        found = true;
                        List<Integer> temp = list.get(j);
                        temp.set(1, temp.get(1) + 1);
                        break;
                    }
                }
            if(!found){
                list.add(Arrays.asList(arr[i],1));
            }
        }
        return list;
    }

    public static void merge(int [] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while(left<=mid && right<=high){
            if(arr[left]<arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }

        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        for(int i=low; i<=high; i++){
            arr[i] = temp.get(i-low);
        }
    }

    static void selectionSort(int[] arr){
        //4,6,2,3
        for(int i=0; i< arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                if(arr[j]<arr[i]){
                    swap(arr,i,j);
                }
            }
        }
    }

    static void insertionSort(int[] arr){

    }


    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
