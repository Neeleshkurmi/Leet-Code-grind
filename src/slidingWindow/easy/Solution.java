package slidingWindow.easy;

import java.io.IOException;
import java.util.*;
class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]) && Math.abs(map.get(nums[i])-i)<=k){
               return true;
            }
            else{
                map.put(nums[i],i );
            }
        }
        return false;
    }

    public static double findMaxAverage(int[] nums, int k) {
        double sum =0;

        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        double max = sum/k;
        for(int i=k; i<nums.length; i++){
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(sum/k, max);
        }
        return max;
    }

    public static int subarraySum(int[] a, int k) {
        int n = a.length, count=0, sum =0;
        Set<Integer> set = new HashSet<>();
        set.add(0);

        for(int i=0; i<n; i++){
            sum += a[i];
            if(set.contains(sum-k)){
                count++;
            }
            else{
                set.add(sum);
            }
        }
        return count;
    }

    public static int minimumSwitchesToUntangle(int N, int M, char[][] grid) {
        // Initialize variables
        boolean[][] visited = new boolean[N][M];

        // Use LinkedList as a Queue for BFS. Storing coordinates as an array [row, col].
        Queue<int[]> queue = new LinkedList<>();
        int switches = 0;

        // Find all edge cable starting points
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // Check if on the edge AND if it's a cable 'C'
                if ((i == 0 || i == N - 1 || j == 0 || j == M - 1) && grid[i][j] == 'C') {
                    queue.offer(new int[]{i, j}); // Add coordinates to the queue
                    visited[i][j] = true;
                }
            }
        }

        // BFS traversal: Up, Down, Left, Right directions (dr, dc)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int dr = dir[0];
                int dc = dir[1];
                int nr = r + dr;
                int nc = c + dc;

                // Check bounds
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {

                    if (grid[nr][nc] == 'C') { // Cable cell
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    } else if (grid[nr][nc] == 'R') { // Overlapping rod (switch)
                        switches++;
                        visited[nr][nc] = true; // Mark as visited after 'switch'
                    }
                    // Any other character (e.g., empty space) is just ignored because it's not a 'C' or 'R'.
                }
            }
        }

        return switches;
    }

    // --- Example Usage ---
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        // Grid dimensions
        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] grid = new char[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                grid[i][j] = (char) System.in.read();
            }
            sc.nextLine();
        }

        // Example grid: 'C' - Cable, 'R' - Switch, '.' - Empty

        int result = minimumSwitchesToUntangle(N, M, grid);
        System.out.println("Minimum switches required: " + result); // Output depends on the logic and grid
    }

//    public static void main(String[] args) {
//
////        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1},3));
////        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
////        System.out.println(findMaxAverage(new int[] {-1},1));
//        System.out.println(subarraySum(new int[]{1,2,3},3));
//        System.out.println(subarraySum(new int[]{1,2,3,4,-1,6},6));
//        System.out.println(subarraySum(new  int[]{1,1,1},1));
//        System.out.println(subarraySum(new  int[]{1,1,1},2));
//        System.out.println(subarraySum(new int[]{100,1,2,3,4},3));
//    }
}