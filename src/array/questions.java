package array;

import java.util.*;

public class questions {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{73,74,75,71,69,72,76,73})));
        System.out.println(largestRectangleArea(new int[] {2,4}));
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
        ListNode i = null;
        ListNode ans = helper(head, i, head);
        return ans==null?true:false;
    }

    private ListNode helper(ListNode head, ListNode i, ListNode j){
        if(j==null){
            return head;
        }
        i = helper(head, i, j.next);
        if(i.val!=j.val) return new ListNode(-1);
        return i.next;
    }

    //nov 19
    public static int largestRectangleArea(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] heights = Arrays.copyOf(nums, nums.length + 1);

        heights[nums.length] =0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <heights.length; i++) {

            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int height = heights[stack.pop()];

                int leftB =0;
                if(stack.isEmpty()){
                    leftB = -1;
                }
                else {
                    leftB = stack.peek();
                }

                int rightB = i;

                int width = rightB - leftB - 1;
                max = Math.max(max, width*height);
            }
            stack.push(i);
        }
        return max;
    }

//    public static int largestRectangleArea(int[] heights) {
//        // Step 1️⃣: Append a sentinel 0 height to flush the stack at the end
//        int n = heights.length;
//        int[] extended = Arrays.copyOf(heights, n + 1);
//        extended[n] = 0;  // sentinel
//
//        // Step 2️⃣: Stack stores indices of bars waiting for a smaller bar
//        Deque<Integer> stack = new ArrayDeque<>();
//        int maxArea = 0;
//
//        // Step 3️⃣: Traverse all bars
//        for (int i = 0; i < extended.length; i++) {
//            // While current bar is smaller than top of stack → resolve taller bars
//            while (!stack.isEmpty() && extended[i] < extended[stack.peek()]) {
//                int height = extended[stack.pop()]; // height of resolved bar
//
//                // Determine width boundaries
//                int leftBoundary;
//                if (stack.isEmpty()) {
//                    // If no smaller bar on the left, extend from index 0
//                    leftBoundary = -1;
//                } else {
//                    // Previous smaller bar defines left limit
//                    leftBoundary = stack.peek();
//                }
//
//                int rightBoundary = i; // Current smaller bar defines right limit
//
//                // Compute width and area
//                int width = rightBoundary - leftBoundary - 1;
//                int area = height * width;
//
//                // Track the largest area found
//                maxArea = Math.max(maxArea, area);
//            }
//
//            // Current bar now "waits" for a smaller one
//            stack.push(i);
//        }
//
//        return maxArea;
//    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int idx = stack.pop();
                result[idx] = i-idx;
            }
            stack.push(i);
        }
        return result;
    }
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        while(set.contains(original)){
            original *=2;
        }
        return original;
    }
    public boolean bs(int [] nums, int target){
        int start =0, end = nums.length-1;

        while(start<=end){
            int mid = start+ (end-start) /2;

            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return false;
    }
    //nov 18
    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = Arrays.copyOf(prices,n);
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && prices[i]>= prices[stack.peek()]){
                int idx = stack.pop();
                result[idx] = prices[i] - prices[idx];
            }
            stack.push(i);
        }
        return result;
    }
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while(i < n - 1)
            i += bits[i] + 1;
        return i == n - 1;
    }
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime =0;

        for(String log : logs){
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if(type.equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += (timestamp - prevTime);
                }
                stack.push(id);
                prevTime = timestamp;
            }

            else{
                int popId = stack.pop();
                result[popId] += (timestamp - prevTime + 1);
                prevTime = timestamp + 1;
            }
        }
        return result;
    }
    //nov 17
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String str: tokens){
            int a;
            int b;
            int c;
            if("+-*/".contains(str)){
                a = stack.pop();
                b = stack.pop();
                c = switch (str) {
                    case "+" -> a + b;
                    case "-" -> b - a;
                    case "*" -> a * b;
                    default -> b / a;
                };
                stack.push(c);
            }
            else
                stack.push(Integer.parseInt(str));
        }
        return stack.pop();
    }
    //nov 16
    public static void cycleSort(int[] nums){
        int j=0;
        while(j<nums.length){
            int correct= nums[j]-1;

            if(nums[j]!=nums[correct]){
                int temp = nums[j];
                nums[j] = nums[correct];
                nums[correct] = temp;
            }
            else{
                j++;
            }
        }
    }
    public static int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        int[] ans = new int[len];
        int j=1;
        ans[0] = nums[0];
        for(int i=1; i<n; i++){
            ans[j++] = nums[n+i-1];
            ans[j++] = nums[i];
        }

        ans[j] = nums[len-1];
        return ans;
    }
    static int countSubStrings(String s){
        long ans =0, count =0;
        for(char ch : s.toCharArray()){
            if(ch=='1'){
                count++;
            }
            else{
                ans+=count* (count+1) /2;
                count=0;
            }
        }
        ans+= count*(count+1) /2;
        return (int)(ans % Math.pow(10,7));

        /*
        char[] chars = s.toCharArray();
		long ans = 0, count = 0;
		for (char c : chars) {
			if (c == '1') {
				count++;
			} else {
				ans += count * (count + 1) / 2;
				count = 0;
			}
		}
		ans += count * (count + 1) / 2;
		return (int) (ans % 1000000007);
         */
    }
    //nov 15
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            // When current number is negative, swap max and min
            if (cur < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Calculate new max and min
            maxProd = Math.max(cur, maxProd * cur);
            minProd = Math.min(cur, minProd * cur);

            // Update global max
            globalMax = Math.max(globalMax, maxProd);
        }

        return globalMax;
    }
    //nov 14
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = 1;
        suf[n-1] =1;

        for (int i = 1; i <n; i++) {
            pre[i] = pre[i-1] * nums[i-1];
        }
        for (int i = n-2; i >=0; i--) {
            suf[i] = suf[i+1] * nums[i+1];
        }
        int[] ans = new int[n];
        for (int i = 0; i <n; i++) {
            ans[i] = pre[i] * suf[i];
        }
        return ans;
    }
    static List<Integer> spiralOrder(int[][] nums){
        List<Integer> result = new ArrayList<>();
        int m =nums.length;
        int n = nums[0].length;
        int top =0, left =0, right = n-1, bottom = m-1;

        while(left<=right && top<=bottom){

            for(int i=left; i<=right; i++){
                result.add(nums[top][i]);
            }
            top++;

            for(int i=top; i<=bottom; i++){
                result.add(nums[i][right]);
            }
            right--;

            if(top<=bottom){
                for (int i =right; i >=left ; i--) {
                    result.add(nums[bottom][i]);
                }
                bottom--;
            }

            if(left<=right){
                for (int i = bottom; i >=top ; i--) {
                    result.add(nums[i][left]);
                }
                left++;
            }
        }
        return result;
    }
    static void rotate(int[][] mat){
        int n= mat.length;
        for(int i=0; i<n; i++){
            for (int j =i+1; j <n; j++) {
                swap(mat,i,j);
            }
        }
        System.out.println(Arrays.deepToString(mat));
        for(int[] num : mat){
                reverse(num,0,n-1);
        }
    }
    public static void swap(int[][] arr, int i, int j){
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==0){
                    row[j] = true;
                    col[i] = true;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(col[i] || row[j]){
                    matrix[i][j] = 0;
                }

            }
        }

    }
    public static int[][] inc(int m, int[][]q){
        int[][] mat = new int[m][m];
        for (int[] query : q) {
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];

            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    mat[r][c]++;
                }
            }
        }
        return mat;
    }
    //problem solved nov 13
    static int operation(String s){
        int count =0;
        int temp =0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                temp++;
            }
	        /*👉 When you hit a '0' right after one or more '1's
              you cash out the apples → count += temp
              👉 If you hit '0' after another '0'
              do nothing (because there were no recent `'1's).*/

            else if (i> 0 && s.charAt(i - 1) == '1')
                count += temp;
        }
        return count;
    }

    static int subArraysSum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        int sum =0;

        for (int j : arr) {
            sum += j;
            if (sum == k) {
                count++;
            }
            count+=map.getOrDefault(sum-k,0);

            map.put(sum, map.getOrDefault(sum , 0) + 1);
        }
        return count;
    }
    static int maxLenXor(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        int xor =0;

        for (int j : arr) {
            xor ^= j;
            if (xor == k) {
                count++;
            }
            count+=map.getOrDefault(xor^k,0);

            map.put(xor, map.getOrDefault(xor , 0) + 1);
        }
        return count;
    }
    static int maxLength(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxL = 0;
        int sum =0;

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum==0){
                maxL = Math.max(maxL,i+1);
            }
            if(map.containsKey(sum)){
                maxL = Math.max(maxL, i-map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return maxL;
    }
    public static List<List<Integer>> pascals(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        if(numRows==1){
            return result;
        }
        result.add(Arrays.asList(1,1));
        if(numRows==2){
            return result;
        }
        numRows=numRows-2;
        int j=1;
        while(numRows>0){
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for(int i=1; i<result.size(); i++){
                current.add(result.get(j).get(i-1) + result.get(j).get(i));
            }
            current.add(1);
            j++;
            result.add(current);
            numRows--;
        }
        return result;
    }
    public static List<Integer> spiralOrder(int[][] matrix, int m, int n) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols-1, top = 0, bottom = rows-1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum =0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];

            if(sum>max){
                max = sum;
            }

            if(sum<0){
                sum =0;
            }
        }
        return max;
    }
    public static void nextPermutation(int[] nums) {
        int index =-1;

        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        if(index ==-1){
            reverse(nums, 0, nums.length-1);
            return;
        }
        int min =-1;
        for(int i=nums.length-1; i>index; i--){
            if(nums[i]>nums[index]){
                min = i;
                break;
            }
        }
        swap(nums, index, min);
        Arrays.sort(nums, index+1, nums.length);
    }
    static int romanToInteger(String s){
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1); map.put('v',5); map.put('X',10);
        map.put('L',50); map.put('M',1000); map.put('C',100); map.put('D',500);

        int ans = map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2; i>=0; i--){
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                ans-=map.get(s.charAt(i));
            }
            else{
                ans+=map.get(s.charAt(i));
            }
        }
        return ans;
    }
    static void rotate(int[] nums, int k){
        k= k%nums.length;

        reverse(nums,0,nums.length-1);
        reverse(nums,0, k-1);
        reverse(nums, k, nums.length-1);

    }
    static void reverse(int [] nums, int start, int end){
        while(start<=end){
            swap(nums, start, end);
            start++; end--;
        }
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static String[] divideString(String s, int k, char fill) {
        int temp =k;
        int size = (s.length()/k) + (s.length()%k);
        List<String> result = new ArrayList<>();

        int j=0;
        for(int i=0; i<size; i++){
            if(s.length()>=temp){
                result.add(s.substring(j,k));
                s = s.substring(k,s.length());
            }
            else {
                result.add(s);
                break;
            }
        }
        if(result.getLast().length()<temp){
            int rem = temp-result.getLast().length();
            for(int i=1; i<=rem; i++){
                result.set(result.getLast().length(),result.getLast()+fill);
            }
        }
        String[] ans = new String[result.size()];
        for(int i=0;i<result.size(); i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
    public static int minMaxDifference(int num) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String s = String.valueOf(num);
        for(int i=0; i<s.length(); i++){
            String temp1 = s;
            String temp2 = s;

            temp1 = temp1.replaceAll(String.valueOf(s.charAt(i)),"9");
//            System.out.println("temp1 = "+ temp1);
            max = Math.max(max,Integer.valueOf(temp1));

            temp2 = temp2.replaceAll(String.valueOf(s.charAt(i)), "0");
//            System.out.println("temp1 = "+ temp2);
            min = Math.min(min, Integer.valueOf(temp2));
        }
        return max - min;
    }
    //leet code contest question
    public static int minimumDistance(int[] nums){
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            // adds the list of indices  ---> if key is not present ? create new list : append new index in the list
            map.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
        }

        int minD =Integer.MAX_VALUE;
        boolean found =false;

        for(List<Integer> temp : map.values()){
            if(temp.size()<3) continue; // id triplets are more then 3
            found =true;

            //to compute more then 3 triplets to achieve min length
            for (int i = 0; i+2 <temp.size(); i++) {
                int a = temp.get(i);
                int c = temp.get(i+2);
                int distance = 2*(c-a);
                minD = Math.min(minD, distance);
            }
        }
        return found?minD : -1;
    }
}
