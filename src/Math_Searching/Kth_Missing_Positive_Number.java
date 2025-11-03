package Math_Searching;

import java.io.FilterOutputStream;

public class Kth_Missing_Positive_Number {
    public static void main(String[] args) {
        int[] arr ={2,3,4,7,11}; int k = 5;
        System.out.println(findKthPositive1(arr,k));
        int[] arr1=  {1,2,3,4};
        System.out.println(findKthPositive1(arr1,2));
        System.out.println(findKthPositive1(new int[] {1,10,21,22,25},12));
        System.out.println(5>5);
    }
    public static int findKthPositive(int[] arr, int k) {
        int j=0;

        int [] ans = new int[arr.length*2];

        for (int i = 1; i <= arr.length * 2; i++) {
            // Check if `i` is not in `arr`
            boolean isPresent = false;
            for (int num : arr) {
                if (num == i) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {
                ans[j++] = i;
            }

            if (j == k) {
                return i;
            }
        }
        return -1;
    }
    public static int findKthPositive1(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left + k;
    }
}
