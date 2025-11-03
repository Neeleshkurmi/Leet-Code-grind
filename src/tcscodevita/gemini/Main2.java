package tcscodevita.gemini;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        char[] s = new char[n];
        for (int i = 0; i < n; i++) {
            String t = sc.next();
            s[i] = t.charAt(0);
        }
        ArrayList<Integer> fixed = new ArrayList<>();
        while (sc.hasNextInt()) {
            fixed.add(sc.nextInt()); // 1-based indices
        }
        sc.close();

        // counts
        int countA = 0, countB = 0, countC = 0;
        for (char ch : s) {
            if (ch == 'A') countA++;
            else if (ch == 'B') countB++;
            else if (ch == 'C') countC++;
        }

        char[] labels = {'A', 'B', 'C'};
        List<char[]> perms = new ArrayList<>();
        perms.add(new char[]{'A','B','C'});
        perms.add(new char[]{'A','C','B'});
        perms.add(new char[]{'B','A','C'});
        perms.add(new char[]{'B','C','A'});
        perms.add(new char[]{'C','A','B'});
        perms.add(new char[]{'C','B','A'});

        int best = Integer.MAX_VALUE;
        for (char[] perm : perms) {
            // compute block sizes according to perm ordering
            int[] sizes = new int[3];
            for (int i = 0; i < 3; i++) {
                if (perm[i] == 'A') sizes[i] = countA;
                else if (perm[i] == 'B') sizes[i] = countB;
                else sizes[i] = countC;
            }
            // build target string
            char[] target = new char[n];
            int idx = 0;
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < sizes[i]; k++) {
                    target[idx++] = perm[i];
                }
            }
            // check fixed positions compatibility
            boolean ok = true;
            for (int pos : fixed) {
                if (pos < 1 || pos > n) { ok = false; break; }
                if (target[pos-1] != s[pos-1]) { ok = false; break; }
            }
            if (!ok) continue;

            // compute LCS length between s and target
            int[][] dp = new int[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s[i-1] == target[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
            int lcs = dp[n][n];
            int moves = n - lcs;
            if (moves < best) best = moves;
        }

        if (best == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(best);
        }
    }
}
