package tcscodevita.gemini.research;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Represents a horizontal line segment in a canonical format.
 * The coordinates are stored such that x1 is always less than or equal to x2.
 */

class HorizontalLine {
    int y, x1, x2;

    public HorizontalLine(int y, int x1, int x2) {
        this.y = y;
        this.x1 = Math.min(x1, x2);
        this.x2 = Math.max(x1, x2);
    }
}

/**
 * Represents a vertical line segment in a canonical format.
 * The coordinates are stored such that y1 is always less than or equal to y2.
 */
class VerticalLine {
    int x, y1, y2;

    public VerticalLine(int x, int y1, int y2) {
        this.x = x;
        this.y1 = Math.min(y1, y2);
        this.y2 = Math.max(y1, y2);
    }
}

public class Main {

    public static void main(String args) throws IOException {
        // Set up fast input reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the total number of lines
        int n = Integer.parseInt(reader.readLine());

        ArrayList<HorizontalLine> horizontalLines = new ArrayList<>();
        ArrayList<VerticalLine> verticalLines = new ArrayList<>();

        // Read and segregate lines into horizontal and vertical lists
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (y1 == y2) { // This is a horizontal line
                horizontalLines.add(new HorizontalLine(y1, x1, x2));
            } else { // This is a vertical line
                verticalLines.add(new VerticalLine(x1, y1, y2));
            }
        }

        // Sort horizontal lines by their y-coordinate. This makes it easy to
        // iterate through pairs, treating one as the bottom and one as the top.
        Collections.sort(horizontalLines, Comparator.comparingInt(h -> h.y));

        long totalRectangles = 0;
        int hCount = horizontalLines.size();

        // This is the core "Horizontal-Pair Sweeping" algorithm.
        // We iterate through every possible pair of horizontal lines.
        for (int i = 0; i < hCount; i++) {
            for (int j = i + 1; j < hCount; j++) {
                HorizontalLine h_bottom = horizontalLines.get(i);
                HorizontalLine h_top = horizontalLines.get(j);

                ArrayList<VerticalLine> candidateVerticals = new ArrayList<>();
                
                // For the chosen horizontal pair, find all vertical lines that can
                // act as valid sides for a rectangle.
                for (VerticalLine v_line : verticalLines) {
                    // Condition 1: The vertical line must span the distance between the two horizontal lines.
                    boolean spansVertically = (v_line.y1 <= h_bottom.y && v_line.y2 >= h_top.y);
                    
                    // Condition 2: The vertical line must intersect both horizontal lines.
                    boolean intersectsBottom = (v_line.x >= h_bottom.x1 && v_line.x <= h_bottom.x2);
                    boolean intersectsTop = (v_line.x >= h_top.x1 && v_line.x <= h_top.x2);

                    if (spansVertically && intersectsBottom && intersectsTop) {
                        candidateVerticals.add(v_line);
                    }
                }

                // If we found 'k' valid vertical lines, any pair of them can form a
                // rectangle with the current horizontal pair. The number of ways to
                // choose 2 lines from k is C(k, 2) = k * (k - 1) / 2.
                int k = candidateVerticals.size();
                if (k >= 2) {
                    totalRectangles += (long) k * (k - 1) / 2;
                }
            }
        }

        System.out.println(totalRectangles);
    }
}
