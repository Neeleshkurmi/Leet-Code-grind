package tcscodevita.chatgpt;

import java.util.*;

public class UnwrapCable {

    static int N, M;
    static char[][] grid;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class State {
        char[][] g;
        int cost;
        State(char[][] g, int cost) {
            this.g = g;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine().replaceAll(" ", "");
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        // Compute and print the minimum switches required
        System.out.println(minSwitches());
    }

    static int minSwitches() {
        List<int[]> intersections = new ArrayList<>();

        // Find possible rod-cable overlaps (R cells with adjacent cables)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'R') {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d], ny = j + dy[d];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && grid[nx][ny] == 'C') {
                            intersections.add(new int[]{i, j});
                            break;
                        }
                    }
                }
            }
        }

        int k = intersections.size();
        int min = Integer.MAX_VALUE;

        // Try all possible subsets of switches (2^k, feasible since small grid)
        for (int mask = 0; mask < (1 << k); mask++) {
            char[][] copy = copyGrid(grid);
            for (int b = 0; b < k; b++) {
                if (((mask >> b) & 1) == 1) {
                    int[] pos = intersections.get(b);
                    copy[pos[0]][pos[1]] = 'C'; // flip R→C
                }
            }
            if (isFree(copy)) {
                min = Math.min(min, Integer.bitCount(mask));
            }
        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

    // BFS to check if cable is freely connected between edges
    static boolean isFree(char[][] g) {
        boolean[][] vis = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        // Enqueue all edge C cells
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isEdge(i, j) && g[i][j] == 'C') {
                    q.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M &&
                        !vis[nx][ny] && g[nx][ny] == 'C') {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // Ensure all cable cells are reachable from edges (no trapped cable)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (g[i][j] == 'C' && !vis[i][j]) {
                    return false; // trapped cable remains
                }
            }
        }
        return true;
    }

    static boolean isEdge(int x, int y) {
        return x == 0 || y == 0 || x == N - 1 || y == M - 1;
    }

    static char[][] copyGrid(char[][] src) {
        char[][] res = new char[N][M];
        for (int i = 0; i < N; i++) res[i] = src[i].clone();
        return res;
    }
}
