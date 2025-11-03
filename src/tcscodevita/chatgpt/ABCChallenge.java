package tcscodevita.chatgpt;

import java.util.*;

public class ABCChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] items = new char[n];
        for (int i = 0; i < n; i++) {
            items[i] = sc.next().charAt(0);
        }
        sc.nextLine();
        String fixedLine = sc.hasNextLine() ? sc.nextLine().trim() : "";
        Set<Integer> fixedPositions = new HashSet<>();
        if (!fixedLine.isEmpty()) {
            for (String s : fixedLine.split(" ")) {
                fixedPositions.add(Integer.parseInt(s) - 1); // 0-based index
            }
        }

        int result = findMinimumShifts(items, fixedPositions);
        if (result == -1) System.out.println("Impossible");
        else System.out.println(result);
    }

    static int findMinimumShifts(char[] items, Set<Integer> fixedPositions) {
        int n = items.length;
        int countA = 0, countB = 0, countC = 0;
        for (char c : items) {
            if (c == 'A') countA++;
            else if (c == 'B') countB++;
            else countC++;
        }

        // Generate all permutations of owner orderings
        char[][] orders = {
            {'A', 'B', 'C'},
            {'A', 'C', 'B'},
            {'B', 'A', 'C'},
            {'B', 'C', 'A'},
            {'C', 'A', 'B'},
            {'C', 'B', 'A'}
        };

        int minShifts = Integer.MAX_VALUE;

        for (char[] order : orders) {
            char[] target = new char[n];
            int idx = 0;
            for (char owner : order) {
                int len = (owner == 'A') ? countA : (owner == 'B' ? countB : countC);
                for (int k = 0; k < len; k++) target[idx++] = owner;
            }

            // Check if fixed positions are valid
            boolean valid = true;
            for (int pos : fixedPositions) {
                if (items[pos] != target[pos]) {
                    valid = false;
                    break;
                }
            }
            if (!valid) continue;

            // Compute number of shifts = number of misplaced elements
            int shifts = 0;
            boolean[] used = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (items[i] != target[i]) shifts++;
            }
            minShifts = Math.min(minShifts, shifts);
        }

        return minShifts == Integer.MAX_VALUE ? -1 : minShifts;
    }
}
