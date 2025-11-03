package tcscodevita.gemini;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CableUntangler {

    /**
     * Calculates the minimum number of switches ('R' cells) needed to untangle cables ('C' cells) 
     * starting from the grid's edges.
     * * @param N The number of rows in the grid.
     * @param M The number of columns in the grid.
     * @param grid The grid represented as an array of strings/characters. 'C' for cable, 'R' for switch.
     * @return The minimum number of switches required.
     */
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
                    }
                    else if (grid[nr][nc] == 'R') { // Overlapping rod (switch)
                        switches++;
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc}); // Allow the cable path to CONTINUE THROUGH the switch
                    }
                    // Any other character (e.g., empty space) is just ignored because it's not a 'C' or 'R'.
                }
            }
        }

        return switches;
    }

    // --- Example Usage ---
    public static void main(String[] args) throws IOException {
        // Grid dimensions
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

        int result = minimumSwitchesToUntangle(N, M, grid);
        System.out.println("Minimum switches required: " + result); // Output depends on the logic and grid
    }
}