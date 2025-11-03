package tcscodevita.gemini;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Read Inputs
        int N = Integer.parseInt(sc.nextLine());
        String[] items = sc.nextLine().split(" ");
        char[] original = new char[N];
        Map<Character, Integer> counts = new HashMap<>();
        counts.put('A', 0);
        counts.put('B', 0);
        counts.put('C', 0);
        for (int i = 0; i < N; i++) {
            original[i] = items[i].charAt(0);
            counts.put(original[i], counts.get(original[i]) + 1);
        }

        List<Integer> fixedPosList = new ArrayList<>();
        Set<Integer> fixedPosSet = new HashSet<>();
        if (sc.hasNextLine()) {
            String[] fixedInput = sc.nextLine().split(" ");
            for (String s : fixedInput) {
                if (!s.isEmpty()) {
                    int pos = Integer.parseInt(s) - 1; // Convert to 0-based
                    fixedPosList.add(pos);
                    fixedPosSet.add(pos);
                }
            }
        }

        // 2. Define all 6 permutations
        List<List<Character>> permutations = new ArrayList<>();
        permutations.add(Arrays.asList('A', 'B', 'C'));
        permutations.add(Arrays.asList('A', 'C', 'B'));
        permutations.add(Arrays.asList('B', 'A', 'C'));
        permutations.add(Arrays.asList('B', 'C', 'A'));
        permutations.add(Arrays.asList('C', 'A', 'B'));
        permutations.add(Arrays.asList('C', 'B', 'A'));

        int minShifts = N; // Max possible shifts is N
        boolean isPossible = false;

        // 3. Iterate through each permutation
        for (List<Character> perm : permutations) {

            // 3a. Build target string and offsets
            char[] target = new char[N];
            Map<Character, Integer> offsets = new HashMap<>();
            int currentOffset = 0;
            for (char c : perm) {
                offsets.put(c, currentOffset);
                int count = counts.get(c);
                for (int i = 0; i < count; i++) {
                    target[currentOffset + i] = c;
                }
                currentOffset += count;
            }

            // 3b. Check 1: Fixed positions must match target owner
            boolean validPerm = true;
            for (int fixedPos : fixedPosList) {
                if (original[fixedPos] != target[fixedPos]) {
                    validPerm = false;
                    break;
                }
            }
            if (!validPerm) {
                continue; // Try next permutation
            }

            // 3c. Build the mapped sequence (for LIS)
            int[] seq = new int[N];
            Map<Character, Integer> currentCounts = new HashMap<>();
            currentCounts.put('A', 0);
            currentCounts.put('B', 0);
            currentCounts.put('C', 0);
            for (int i = 0; i < N; i++) {
                char c = original[i];
                seq[i] = offsets.get(c) + currentCounts.get(c);
                currentCounts.put(c, currentCounts.get(c) + 1);
            }

            // 3d. Check 2: Fixed positions must be increasing in the sequence
            for (int i = 0; i < fixedPosList.size() - 1; i++) {
                if (seq[fixedPosList.get(i)] >= seq[fixedPosList.get(i + 1)]) {
                    validPerm = false;
                    break;
                }
            }
            if (!validPerm) {
                continue; // Try next permutation
            }

            // 4. This is a valid, possible arrangement
            isPossible = true;

            // 5. Calculate Constrained LIS (O(N^2))
            int[] dp = new int[N];
            int maxLIS = 0;
            for (int i = 0; i < N; i++) {
                dp[i] = 1; // LIS of length 1 (itself)
                for (int j = 0; j < i; j++) {
                    // Basic LIS condition
                    if (seq[j] < seq[i]) {

                        // Constraint Check: No fixed pos k between j and
                        // must violate the sequence
                        boolean fixedViolation = false;
                        for (int k : fixedPosList) {
                            if (j < k && k < i) {
                                if (seq[j] >= seq[k] || seq[k] >= seq[i]) {
                                    fixedViolation = true;
                                    break;
                                }
                            }
                        }

                        if (!fixedViolation) {
                            dp[i] = Math.max(dp[i], 1 + dp[j]);
                        }
                    }
                }
                maxLIS = Math.max(maxLIS, dp[i]);
            }

            minShifts = Math.min(minShifts, N - maxLIS);
        }

        // 6. Print the result
        if (!isPossible) {
            System.out.println("Impossible");
        } else {
            System.out.println(minShifts);
        }

        sc.close();
    }
}