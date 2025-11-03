package tcscodevita.claude;

import java.util.*;

public class ABCChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] items = sc.nextLine().trim().split("\\s+");

        String fixedLine = sc.nextLine().trim();
        String[] fixedPosStr = fixedLine.split("\\s+");
        Set<Integer> fixedPositions = new HashSet<>();
        for (String pos : fixedPosStr) {
            fixedPositions.add(Integer.parseInt(pos));
        }

        // Count occurrences of each owner
        int[] count = new int[3]; // A=0, B=1, C=2
        for (String item : items) {
            count[item.charAt(0) - 'A']++;
        }

        // Try all 6 permutations of arranging A, B, C
        char[][] permutations = {
                {'A', 'B', 'C'},
                {'A', 'C', 'B'},
                {'B', 'A', 'C'},
                {'B', 'C', 'A'},
                {'C', 'A', 'B'},
                {'C', 'B', 'A'}
        };

        int minShifts = Integer.MAX_VALUE;

        for (char[] perm : permutations) {
            // Calculate ranges for each owner in this permutation
            int[][] ranges = new int[3][2]; // [owner][start, end] (1-based, inclusive)
            int pos = 1;
            for (int i = 0; i < 3; i++) {
                int owner = perm[i] - 'A';
                if (count[owner] > 0) {
                    ranges[owner][0] = pos;
                    ranges[owner][1] = pos + count[owner] - 1;
                    pos += count[owner];
                } else {
                    ranges[owner][0] = -1;
                    ranges[owner][1] = -1;
                }
            }

            // Check if fixed positions are compatible with this arrangement
            boolean valid = true;
            for (int fixedPos : fixedPositions) {
                char currentOwner = items[fixedPos - 1].charAt(0);
                int ownerIdx = currentOwner - 'A';

                // Check if this fixed position falls within the range for its owner
                if (ranges[ownerIdx][0] == -1 ||
                        fixedPos < ranges[ownerIdx][0] ||
                        fixedPos > ranges[ownerIdx][1]) {
                    valid = false;
                    break;
                }
            }

            if (!valid) continue;

            // Debug: print valid arrangement
            System.err.println("Valid arrangement: " + new String(perm));
            System.err.println("Ranges: A[" + ranges[0][0] + "-" + ranges[0][1] + "] " +
                    "B[" + ranges[1][0] + "-" + ranges[1][1] + "] " +
                    "C[" + ranges[2][0] + "-" + ranges[2][1] + "]");

            // Calculate minimum shifts for this arrangement
            int shifts = calculateShifts(items, ranges);
            System.err.println("Shifts needed: " + shifts + "\n");
            minShifts = Math.min(minShifts, shifts);
        }

        if (minShifts == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(minShifts);
        }

        sc.close();
    }

    private static int calculateShifts(String[] items, int[][] ranges) {
        int n = items.length;
        int totalInPlace = 0;

        // For each owner, count how many of their items are already in the correct range
        for (int owner = 0; owner < 3; owner++) {
            if (ranges[owner][0] == -1) continue; // No items for this owner

            int rangeStart = ranges[owner][0] - 1; // Convert to 0-based
            int rangeEnd = ranges[owner][1] - 1;   // Convert to 0-based

            // Count items of this owner already in their target range
            for (int i = rangeStart; i <= rangeEnd; i++) {
                if (items[i].charAt(0) == (char)('A' + owner)) {
                    totalInPlace++;
                }
            }
        }

        // Items that need to be shifted = total items - items already in correct place
        return n - totalInPlace;
    }
}