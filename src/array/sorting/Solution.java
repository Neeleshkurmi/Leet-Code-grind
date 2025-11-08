package array.sorting;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {-1,1,1};
        System.out.println(freq(arr));

    }

    static void sort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    static List<List<Integer>> freq(int[] arr){
        List<List<Integer>> list = new ArrayList<>();

        for(int num : arr){
            boolean found = false;
            for(List<Integer> temp : list){
                if(temp.get(0)==num){
                    found = true;
                    temp.set(1, temp.get(1)+1);
                }
            }
            if(!found) {
                list.add(Arrays.asList(num,1));
            }
        }
        return list;
    }

    static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int partionIndex = partion(arr, low, high);
            quickSort(arr, low, partionIndex-1);
            quickSort(arr, partionIndex+1, high);
        }
    }

    public static int longestSubarray(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int sum =0;

        for(int i=0; i<arr.length; i++){
            sum +=arr[i];
            if(map.containsKey(sum-k)){
                max = Math.max(max, map.get(sum-k) +i);
            }

            map.put(sum,i);
        }
        return max;
    }

    static int partion(int[] arr, int low, int high){
        int pivot = arr[low], i=low, j= high;

        while(i<j){
            while(arr[i] <= pivot && i<=high){
                i++;
            }
            while(arr[j] > pivot && j>=low){
                j--;
            }
            if(i<j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
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

    static List<List<Integer>> freqe(int[] arr){
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

//    static void insertionSort(int[] arr){
//
//    }


    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
