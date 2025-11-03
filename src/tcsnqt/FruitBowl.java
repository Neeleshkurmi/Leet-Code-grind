package tcsnqt;

import java.util.*;

public class FruitBowl {

    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            }
            return Integer.compare(this.y, other.y);
        }
    }

    // Function to calculate the cross product of three points (o, a, b)
    // Positive if a, b turn left from o
    // Negative if a, b turn right from o
    // Zero if they are collinear
    private static int crossProduct(Point o, Point a, Point b) {
        return (a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        scanner.close();

        // Sort points by x-coordinate, then by y-coordinate
        Arrays.sort(points);

        // Build the lower convex hull using Monotone Chain
        List<Point> lowerHull = new ArrayList<>();
        for (Point p : points) {
            while (lowerHull.size() >= 2 && crossProduct(lowerHull.get(lowerHull.size() - 2), lowerHull.get(lowerHull.size() - 1), p) >= 0) {
                lowerHull.remove(lowerHull.size() - 1);
            }
            lowerHull.add(p);
        }

        double perimeter = 0.0;
        for (int i = 0; i < lowerHull.size() - 1; i++) {
            Point p1 = lowerHull.get(i);
            Point p2 = lowerHull.get(i + 1);
            perimeter += Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
        }

        System.out.println(Math.round(perimeter));
    }
}