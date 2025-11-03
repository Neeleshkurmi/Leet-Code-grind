package tcscodevita.chatgpt.research;

import java.util.*;

public class SmallestRegion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> allInts = new ArrayList<>();

        // Read all integers from input
        int n = scanner.nextInt();

        for (int i = 0; i <n ; i++) {
            allInts.add(scanner.nextInt());
        }
        if (allInts.size() < 5) {
            // Not enough data
            return;
        }

        // Determine N and parsing order based on total count
        int total = allInts.size();
        // total = 5 + 4*N  => N = (total - 5) / 4
        int N = (total - 5) / 4;
        if (N < 0) N = 0;  // safety
        // Now decide format:
        // Pattern A: [sheetX1, sheetY1, sheetX2, sheetY2, N, rects...]
        // Pattern B: [N, sheetX1, sheetY1, sheetX2, sheetY2, rects...]
        // Pattern C: [N, rects..., sheetX1, sheetY1, sheetX2, sheetY2]
        int idx = 0;
        long sheetX1, sheetY1, sheetX2, sheetY2;
        List<long[]> rects = new ArrayList<>();

        if (total == 5 + 4*N) {
            // Try Pattern A: first 4 are sheet, then N, then rectangles
            sheetX1 = allInts.get(0);
            sheetY1 = allInts.get(1);
            sheetX2 = allInts.get(2);
            sheetY2 = allInts.get(3);
            long possibleN = allInts.get(4);
            if (possibleN == N && sheetX1 < sheetX2 && sheetY1 < sheetY2) {
                // Pattern A confirmed
                idx = 5;
                for (int i = 0; i < N; i++) {
                    long x1 = allInts.get(idx++);
                    long y1 = allInts.get(idx++);
                    long x2 = allInts.get(idx++);
                    long y2 = allInts.get(idx++);
                    rects.add(new long[]{x1, y1, x2, y2});
                }
            } else {
                // Try Pattern B: first is N
                // Reset and read differently
                N = (int) allInts.get(0);
                sheetX1 = allInts.get(1);
                sheetY1 = allInts.get(2);
                sheetX2 = allInts.get(3);
                sheetY2 = allInts.get(4);
                idx = 5;
                for (int i = 0; i < N; i++) {
                    long x1 = allInts.get(idx++);
                    long y1 = allInts.get(idx++);
                    long x2 = allInts.get(idx++);
                    long y2 = allInts.get(idx++);
                    rects.add(new long[]{x1, y1, x2, y2});
                }
            }
        } else {
            // As fallback, assume Pattern B or C
            if (allInts.get(0) == N) {
                // Pattern B: N, sheet, then rects
                sheetX1 = allInts.get(1);
                sheetY1 = allInts.get(2);
                sheetX2 = allInts.get(3);
                sheetY2 = allInts.get(4);
                idx = 5;
                for (int i = 0; i < N; i++) {
                    long x1 = allInts.get(idx++);
                    long y1 = allInts.get(idx++);
                    long x2 = allInts.get(idx++);
                    long y2 = allInts.get(idx++);
                    rects.add(new long[]{x1, y1, x2, y2});
                }
            } else {
                // Pattern C: N, rects, sheet last
                idx = 1;
                for (int i = 0; i < N; i++) {
                    long x1 = allInts.get(idx++);
                    long y1 = allInts.get(idx++);
                    long x2 = allInts.get(idx++);
                    long y2 = allInts.get(idx++);
                    rects.add(new long[]{x1, y1, x2, y2});
                }
                sheetX1 = allInts.get(idx++);
                sheetY1 = allInts.get(idx++);
                sheetX2 = allInts.get(idx++);
                sheetY2 = allInts.get(idx++);
            }
        }

        // Function to compute min gap given sheet limits and rectangles
        // disallowing any line that cuts through a rectangle.
        class Helper {
            // Merge overlapping intervals (in-place)
            void mergeIntervals(List<long[]> intervals) {
                if (intervals.isEmpty()) return;
                intervals.sort(Comparator.comparingLong(a -> a[0]));
                List<long[]> merged = new ArrayList<>();
                long[] current = intervals.get(0);
                for (int i = 1; i < intervals.size(); i++) {
                    long[] next = intervals.get(i);
                    if (next[0] <= current[1]) {
                        // Overlap or contiguous: extend
                        current[1] = Math.max(current[1], next[1]);
                    } else {
                        merged.add(current);
                        current = next;
                    }
                }
                merged.add(current);
                intervals.clear();
                intervals.addAll(merged);
            }

            long minGap(long start, long end, List<long[]> forbidden) {
                // If no forbidden intervals, gap = full span
                if (forbidden.isEmpty()) {
                    return end - start;
                }
                // Merge forbidden intervals
                mergeIntervals(forbidden);
                long allowedStart = start;
                long minGap = Long.MAX_VALUE;
                // Check gaps before, between, and after forbidden intervals
                for (long[] iv : forbidden) {
                    if (allowedStart < iv[0]) {
                        long gap = iv[0] - allowedStart;
                        if (gap < minGap) minGap = gap;
                    }
                    // next allowed starts after this forbidden interval
                    allowedStart = Math.max(allowedStart, iv[1]);
                }
                if (allowedStart < end) {
                    long gap = end - allowedStart;
                    if (gap < minGap) minGap = gap;
                }
                return minGap;
            }
        }
        Helper helper = new Helper();

        // Build forbidden intervals for X (vertical folds) and Y (horizontal folds)
        List<long[]> forbidX = new ArrayList<>();
        List<long[]> forbidY = new ArrayList<>();
        for (long[] r : rects) {
            long rx1 = r[0], ry1 = r[1], rx2 = r[2], ry2 = r[3];
            if (rx2 > rx1 + 1) {
                forbidX.add(new long[]{rx1 + 1, rx2});  // use [start, end) for gap logic
            }
            if (ry2 > ry1 + 1) {
                forbidY.add(new long[]{ry1 + 1, ry2});
            }
        }
        // Compute min horizontal gap (along X) and min vertical gap (along Y)
        // We consider folds between X1 and X2, Y1 and Y2:
        long minGapX = helper.minGap(sheetX1, sheetX2, forbidX);
        long minGapY = helper.minGap(sheetY1, sheetY2, forbidY);

        // The smallest region area is minGapX * minGapY
        long result = minGapX * minGapY;
        System.out.println(result);
    }
}
