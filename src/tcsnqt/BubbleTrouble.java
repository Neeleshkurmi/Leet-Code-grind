package tcsnqt;

import java.util.*;

class Point {
    double x, y;
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Building {
    double x, y, r;
    int id;
    Building(double x, double y, double r, int id) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.id = id;
    }
}

class TaxLine {
    Point p1, p2;
    TaxLine(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}

class State {
    Point currentPoint;
    int taxLinesCrossed;
    State(Point p, int tax) {
        this.currentPoint = p;
        this.taxLinesCrossed = tax;
    }
}

public class BubbleTrouble {

    private static double vehicleRadius;
    private static List<Building> buildings;
    private static List<TaxLine> taxLines;
    private static int S;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        S = scanner.nextInt();
        double startX = scanner.nextDouble();
        double startY = scanner.nextDouble();
        vehicleRadius = scanner.nextDouble();
        Point startPoint = new Point(startX, startY);

        double destX = scanner.nextDouble();
        double destY = scanner.nextDouble();
        Point destPoint = new Point(destX, destY);

        int N = scanner.nextInt();
        buildings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            buildings.add(new Building(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), i + 1));
        }

        int T = scanner.nextInt();
        taxLines = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int b1 = scanner.nextInt();
            int b2 = scanner.nextInt();
            taxLines.add(new TaxLine(new Point(buildings.get(b1 - 1).x, buildings.get(b1 - 1).y),
                                     new Point(buildings.get(b2 - 1).x, buildings.get(b2 - 1).y)));
        }
        scanner.close();

        // Check if start or end points are inside a building
        if (isInsideBuilding(startPoint) || isInsideBuilding(destPoint)) {
            System.out.println("Impossible");
            return;
        }

        // BFS to find the minimum tax lines crossed
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Starting state: 0 tax lines crossed, start point
        queue.add(new State(startPoint, 0));
        visited.add(startPoint.x + "," + startPoint.y);

        int minTaxLines = Integer.MAX_VALUE;

        // The "nodes" for our BFS will be the start, destination, and building centers.
        List<Point> allPoints = new ArrayList<>();
        allPoints.add(startPoint);
        allPoints.add(destPoint);
        for (Building b : buildings) {
            allPoints.add(new Point(b.x, b.y));
        }

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            Point current = currentState.currentPoint;
            int currentCost = currentState.taxLinesCrossed;

            if (current.x == destPoint.x && current.y == destPoint.y) {
                minTaxLines = Math.min(minTaxLines, currentCost);
                continue;
            }

            // Explore all possible next steps
            for (Point next : allPoints) {
                if (current.x == next.x && current.y == next.y) continue;

                // Check for obstacles on the straight path
                if (!pathIntersectsBuilding(current, next)) {
                    int linesCrossed = countTaxLineCrossings(current, next);
                    int newCost = currentCost + linesCrossed;

                    String nextKey = next.x + "," + next.y;
                    if (!visited.contains(nextKey) || newCost < minTaxLines) { // Heuristic: If we found a better path to a point, explore it
                         // For a simple BFS, we only visit each node once, but since edge weights
                         // are not uniform (number of tax lines), we must allow re-visiting
                         // if we find a path with fewer tax lines.
                        queue.add(new State(next, newCost));
                        visited.add(nextKey);
                    }
                }
            }
        }
        
        if (minTaxLines == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(minTaxLines);
        }
    }

    private static boolean isInsideBuilding(Point p) {
        for (Building b : buildings) {
            double distance = Math.sqrt(Math.pow(p.x - b.x, 2) + Math.pow(p.y - b.y, 2));
            if (distance < b.r + vehicleRadius) {
                return true;
            }
        }
        return false;
    }

    private static boolean pathIntersectsBuilding(Point p1, Point p2) {
        for (Building b : buildings) {
            // Check if the line segment intersects the circle
            double distSq = distPointSegmentSquared(b, p1, p2);
            if (distSq < Math.pow(b.r + vehicleRadius, 2)) {
                return true;
            }
        }
        return false;
    }

    private static double distPointSegmentSquared(Building b, Point p1, Point p2) {
        double l2 = Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2);
        if (l2 == 0) return Math.pow(b.x - p1.x, 2) + Math.pow(b.y - p1.y, 2);

        double t = ((b.x - p1.x) * (p2.x - p1.x) + (b.y - p1.y) * (p2.y - p1.y)) / l2;
        t = Math.max(0, Math.min(1, t));

        double projectedX = p1.x + t * (p2.x - p1.x);
        double projectedY = p1.y + t * (p2.y - p1.y);

        return Math.pow(b.x - projectedX, 2) + Math.pow(b.y - projectedY, 2);
    }

    private static int countTaxLineCrossings(Point p1, Point p2) {
        int count = 0;
        for (TaxLine tax : taxLines) {
            if (lineSegmentsIntersect(p1, p2, tax.p1, tax.p2)) {
                count++;
            }
        }
        return count;
    }

    // A slightly more robust line segment intersection check
    private static boolean lineSegmentsIntersect(Point a, Point b, Point c, Point d) {
        double o1 = orientation(a, b, c);
        double o2 = orientation(a, b, d);
        double o3 = orientation(c, d, a);
        double o4 = orientation(c, d, b);

        if (o1 != o2 && o3 != o4) {
            return true;
        }

        // Special cases for collinear points (not needed as problem states no intersecting tax lines)
        return false;
    }

    // Orientation of ordered triplet (p, q, r)
    // 0 --> Collinear
    // 1 --> Clockwise
    // 2 --> Counterclockwise
    private static double orientation(Point p, Point q, Point r) {
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0;  // collinear
        return (val > 0) ? 1 : 2; // clockwise or counterclockwise
    }
}