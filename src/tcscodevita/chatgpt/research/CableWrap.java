package tcscodevita.chatgpt.research;

import java.util.*;

public class CableWrap {
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+");
            if (parts.length == 1 && parts[0].length() == M) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = parts[0].charAt(j);
                }
            } else {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = parts[j].charAt(0);
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        int totalFlips = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && (grid[i][j] == 'C' || grid[i][j] == 'R')) {
                    boolean hasCable = false;
                    boolean hasRod = false;

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];

                        if (grid[x][y] == 'C') hasCable = true;
                        if (grid[x][y] == 'R') hasRod = true;

                        for (int d = 0; d < 4; d++) {
                            int ni = x + di[d];
                            int nj = y + dj[d];
                            if (ni >= 0 && ni < N && nj >= 0 && nj < M
                                    && !visited[ni][nj]
                                    && (grid[ni][nj] == 'C' || grid[ni][nj] == 'R')) {
                                visited[ni][nj] = true;
                                q.add(new int[]{ni, nj});
                            }
                        }
                    }

                    if (hasCable && hasRod) totalFlips++;
                }
            }
        }

        System.out.println(totalFlips);
    }
}
