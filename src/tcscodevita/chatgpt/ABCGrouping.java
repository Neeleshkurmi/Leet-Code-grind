package tcscodevita.chatgpt;

import java.util.*;

public class ABCGrouping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());
        // Read the items (space-separated letters A, B, C)
        String[] parts = sc.nextLine().trim().split("\\s+");
        char[] orig = new char[N];
        for (int i = 0; i < N; i++) {
            orig[i] = parts[i].charAt(0);
        }
        // Read fixed positions (1-based indices in input, convert to 0-based)
        String fixedLine = sc.nextLine().trim();
        String[] fixedParts = fixedLine.isEmpty() ? new String[0] : fixedLine.split("\\s+");
        int[] fixedPos = new int[fixedParts.length];
        for (int i = 0; i < fixedParts.length; i++) {
            fixedPos[i] = Integer.parseInt(fixedParts[i]) - 1; // convert to 0-based
        }
        Arrays.sort(fixedPos);

        // Count how many A, B, C
        int countA = 0, countB = 0, countC = 0;
        for (char c : orig) {
            if (c == 'A') countA++;
            else if (c == 'B') countB++;
            else if (c == 'C') countC++;
        }

        // All 6 permutations of the letters A,B,C for block order
        char[][] orders = {
            {'A','B','C'}, {'A','C','B'},
            {'B','A','C'}, {'B','C','A'},
            {'C','A','B'}, {'C','B','A'}
        };

        int bestMoves = Integer.MAX_VALUE;
        // Try each block order
        for (char[] order : orders) {
            // Determine sizes of blocks in this order
            int size1 = (order[0] == 'A' ? countA : order[0] == 'B' ? countB : countC);
            int size2 = (order[1] == 'A' ? countA : order[1] == 'B' ? countB : countC);
            int size3 = N - size1 - size2; // remaining for the third letter

            // Build the target sequence
            char[] target = new char[N];
            for (int i = 0; i < size1; i++) target[i] = order[0];
            for (int i = size1; i < size1 + size2; i++) target[i] = order[1];
            for (int i = size1 + size2; i < N; i++) target[i] = order[2];

            // Check fixed positions
            boolean valid = true;
            for (int p : fixedPos) {
                if (target[p] != orig[p]) { 
                    valid = false;
                    break;
                }
            }
            if (!valid) continue; // this block order won't work

            // Compute LCS in each segment between fixed positions
            int totalMatch = fixedPos.length; // each fixed position contributes 1
            int segStart = 0;
            for (int p : fixedPos) {
                int segEnd = p - 1;
                if (segEnd >= segStart) {
                    totalMatch += lcsLength(orig, target, segStart, segEnd);
                }
                segStart = p + 1;
            }
            // Tail segment after last fixed
            if (segStart < N) {
                totalMatch += lcsLength(orig, target, segStart, N - 1);
            }

            // Moves needed = N - totalMatch
            int moves = N - totalMatch;
            bestMoves = Math.min(bestMoves, moves);
        }

        if (bestMoves == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(bestMoves);
        }
    }

    // Compute LCS length between orig[a..b] and target[a..b] (inclusive range)
    // Uses a simple DP; ranges are aligned (same indices in orig and target).
    private static int lcsLength(char[] orig, char[] target, int start, int end) {
        int len = end - start + 1;
        // If no elements, LCS is 0
        if (len <= 0) return 0;
        // dp[i][j] = LCS length for orig segment[i..end] and target segment[j..end],
        // but we can do bottom-up on a small array.
        int[][] dp = new int[len + 1][len + 1];
        // We consider origIndex = start+i, targetIndex = start+j
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                if (orig[start + i] == target[start + j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
