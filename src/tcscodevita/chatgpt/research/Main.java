package tcscodevita.chatgpt.research;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        // Read the sequence of owners
        char[] arr = new char[n];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            arr[i] = (s.length() > 0 ? s.charAt(0) : ' ');
        }
        // Read fixed positions line
        sc.nextLine(); // skip to next line
        String fixedLine = sc.hasNextLine() ? sc.nextLine().trim() : "";
        List<Integer> fixedPositions = new ArrayList<>();
        if(!fixedLine.isEmpty()) {
            for(String p : fixedLine.split("\\s+")) {
                if(p.length() > 0) {
                    fixedPositions.add(Integer.parseInt(p));
                }
            }
        }
        // Count A, B, C
        int countA = 0, countB = 0, countC = 0;
        for(char c : arr) {
            if (c == 'A') countA++;
            else if (c == 'B') countB++;
            else if (c == 'C') countC++;
        }
        // All permutations of A, B, C
        List<char[]> orders = Arrays.asList(
            new char[]{'A','B','C'},
            new char[]{'A','C','B'},
            new char[]{'B','A','C'},
            new char[]{'B','C','A'},
            new char[]{'C','A','B'},
            new char[]{'C','B','A'}
        );
        int best = Integer.MAX_VALUE;
        // Try each grouping order
        for(char[] order : orders) {
            // Determine block lengths for this order
            int len1 = (order[0]=='A' ? countA : order[0]=='B' ? countB : countC);
            int len2 = (order[1]=='A' ? countA : order[1]=='B' ? countB : countC);
            int len3 = (order[2]=='A' ? countA : order[2]=='B' ? countB : countC);
            // Build candidate final sequence
            if(len1 + len2 + len3 != n) continue;
            char[] fin = new char[n];
            int idx = 0;
            for(int k = 0; k < len1; k++) fin[idx++] = order[0];
            for(int k = 0; k < len2; k++) fin[idx++] = order[1];
            for(int k = 0; k < len3; k++) fin[idx++] = order[2];
            // Check fixed positions
            boolean ok = true;
            for(int fp : fixedPositions) {
                int p = fp - 1;
                if (p < 0 || p >= n || arr[p] != fin[p]) {
                    ok = false;
                    break;
                }
            }
            if(!ok) continue;
            // Compute LCS length between arr and fin
            int[][] dp = new int[n+1][n+1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(arr[i-1] == fin[j-1]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            int lcs = dp[n][n];
            int moves = n - lcs;
            best = Math.min(best, moves);
        }
        // Output result
        System.out.println(best == Integer.MAX_VALUE ? "Impossible" : best);
        sc.close();
    }
}
