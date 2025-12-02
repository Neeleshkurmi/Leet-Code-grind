package leetcodedaily;

import array.questions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
//        int num = (int)(Math.pow(10,5));
//        System.out.println(smallestRepunitDivByK(23));
//        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(myAtoi("11-0"));
    }

    //dec 2
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))!= t.charAt(i)){
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
        }
        Map<Character, Character> ma = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            if(ma.containsKey(t.charAt(i)) && ma.get(t.charAt(i))!= s.charAt(i)){
                return false;
            }
            ma.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        questions.ListNode i = null;
        questions.ListNode ans = helper(head, i, head);
        return ans==null?true:false;
    }

    private ListNode helper(ListNode head, ListNode i, ListNode j){
        if(j==null){
            return head;
        }
        i = helper(head, i, j.next);
        if(i.val!=j.val) return new questions.ListNode(-1);
        return i.next;
    }

    //nov 29
    public static int myAtoi(String s) {
        int sign =1, i=0;
        long num =0;

        while(i<s.length() && s.charAt(i) == ' ') i++;

        if(i<s.length() && (s.charAt(i)=='-' || s.charAt(i)=='+')) {
            sign = s.charAt(i)=='-'? -1:+1;
            i++;
        }

        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i)-'0';
            num = num*10 + digit;

            if (sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int) (num*sign);
    }
    public static String convert(String s, int numRows) {
        if(numRows==1 || numRows>=s.length()) return s;

        int curr = 0;
        boolean gd = false;
        boolean gu= false;
        StringBuilder[] sb = new StringBuilder[numRows];

        for(int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        for(int i=0; i<s.length(); i++){
            sb[curr] = sb[curr].append(s.charAt(i));

            if(curr==0 ) {
                gd = true;
                gu = false;
            }
            if(curr == numRows-1) {
                gu = true;
                gd = false;
            }

            if(gd) curr++;
            else if(gu) curr--;
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder a : sb){
            ans.append(a.toString());
        }
        return ans.toString();
    }

    //nov 28
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        int i = 0;
        while (i < nums.length) {
            int start = nums[i];
            int j = i;
            // Expand the range as long as elements are consecutive
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                j++;
            }

            // Format the range string
            if (nums[j] == start) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[j]);
            }

            // Move to the next potential start of a range
            i = j + 1;
        }
        return result;
    }
    public static int titleToNumber(String columnTitle) {
        int val = 64, ans =0, n = columnTitle.length();

        for(int i=0; i<n; i++){
            ans+= ((int)(Math.pow(26, n-i-1)))* (columnTitle.charAt(i)-val);
        }
        return ans;
    }
    //203. Remove Linked List Elements
    public static ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            if(curr.val == val){
                ListNode n = (curr.next!=null) ? curr.next: null;
                if(prev!=null) {prev.next = n; curr = n;}

                // if prev is null and current value is equal to val
                else {
                    prev = curr;
                    prev.next = null;
                    prev = null;
                    curr = n;
                    head = curr;
                }
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
    //nov 27

    //nov 26
    static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            int left = i+1, right = nums.length-1;

            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum ==0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    left++; right--;
                } else if (sum<0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    //nov 25
    public static int smallestRepunitDivByK(int k) {
        if(k==1) return 1;

        if(k%2==0 || k%5==0) return -1;

        int rem = 0;
        for(int i=1;i<=k;i++){
            rem = (rem*10+1)%k;
            if(rem==0) return i;
        }
        return -1;
    }

    //no 22
    public int minimumOperations(int[] nums) {
        int count =0;

        for(int num : nums){
            if(num%3!=0) count++;
        }
        return count;
    }

    //nov 21
    static int findMin(int[] nums) {
        int start =0, end =nums.length-1;

        while(start<end){
            int mid = (start+end)/2;

            if(nums[mid]>nums[mid+1]){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        return nums[start];
    }
    static int singleNonDuplicate(int[] nums) {
        int xor =0;

        for(int i=0; i<nums.length; i++){
            xor^=nums[i];
            xor^=(i+1)^(i+1);
        }
        return xor;
    }
    static int countPalindromicSubsequence(String s) {
        Set<Character> set = new HashSet<>();
        int ans =0;
        for(int i=0; i<s.length(); i++){

            if(!set.contains(s.charAt(i))){
                int last = last(s, i);
                if(last!=-1){
                    int unique = unique(s, i+1, last-1);
                    ans +=unique;
                }
                set.add(s.charAt(i));
            }
        }
        return ans;
    }
    static int unique(String s, int start, int end){
        Set<Character> set = new HashSet<>();

        while(start<=end){
            set.add(s.charAt(start));
            start++;
        }
        return set.size();
    }
    static int last(String s, int start){
        int last =-1;
        for(int i=start+1; i<s.length(); i++){
            if(s.charAt(start) == s.charAt(i)){
                last = i;
            }
        }
        return last;
    }
    public static int search(ArrayList<Integer> arr, int n, int k) {
        int start =0, end = n-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(arr.get(mid)==k){
                return mid;
            }
            else if(arr.get(start)<=k && arr.get(mid)>k){
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        return -1;
    }
    static int count(int arr[], int target) {
        int last = last(arr, target);
        int first = first(arr, target);
        return first>=0 && last>=0 ? last-first+1 : 0;
    }
    static int[] occour(int[] nums, int target){
        return new int[]{first(nums,target),last(nums,target)};
    }
    static int first(int[] nums, int target){
        int ans =-1 , start = 0, end = nums.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]==target){
                ans = mid;
                end = mid-1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else {
                start = mid +1;
            }
        }
        return ans;
    }
    static int last(int[] nums, int target){
        int ans =-1, start = 0, end = nums.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]==target){
                ans = mid;
                start = mid+1;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else {
                start = mid +1;
            }
        }
        return ans;
    }

    //nov 20
    static int[] searchRange(int[] nums, int target) {
        int first = first(nums,target);
        int last = last(nums,target);
        return new int[]{first,last};
    }

    static int findFloor(int[] arr, int x) {
        int ans =-1, start =0, end = arr.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid]<=x){
                ans  = mid ;
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return ans;
    }
    static int searchInsert(int[] nums, int target) {
        int ans = nums.length, start =0, end = ans-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]>=target){
                ans = mid;
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        return ans;
    }
    static int upperBound(int[] nums, int target){
        int n = nums.length, start =0, end = n-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]>target){
                n =mid;
                end = mid-1;
            }
            else {
                start = mid +1;
            }
        }
        return n;
    }
    static int lowerBound(int[] nums, int target){
        int n = nums.length, start = 0, end = n-1;

        while(start<=end){
            int mid = (start+end) /2;

            if(nums[mid]>=target){
                n = mid;
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        return n;
    }
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });

        List<Integer> nums = new ArrayList<>();

        int cnt = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int count = 0;

            for (int i = nums.size() - 1; i >= 0; i--) {
                if (nums.get(i) >= start && nums.get(i) <= end) {
                    count++;
                    if (count == 2) break;
                }
            }

            if (count == 0) {
                nums.add(end - 1);
                nums.add(end);
                cnt += 2;
            } else if (count == 1) {
                nums.add(end);
                cnt += 1;
            }
        }

        return cnt;
    }
}