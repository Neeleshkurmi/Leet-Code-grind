package tcsnqt;

import java.util.Scanner;

public class Bands2 {

    private static int S;
    private static int[][] gridState; // 0: unvisited, 1: band1, 2: band2, 3: both
    private static int[][] firstBandToVisit; // 0: none, 1: band1, 2: band2

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        S = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        scanner.nextLine();
        String seq1 = scanner.nextLine();

        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        scanner.nextLine();
        String seq2 = scanner.nextLine();

        gridState = new int[S][S];
        firstBandToVisit = new int[S][S];

        // Simulate Band 1
        simulateBand(x1, y1, seq1, 1);

        // Simulate Band 2
        simulateBand(x2, y2, seq2, 2);

        int band1FirstCount = 0;
        int band2FirstCount = 0;
        int overlapCount = 0;

        for (int i = 0; i < S; i++) {
            for (int j = 0; j < S; j++) {
                if (gridState[i][j] == 3) {
                    overlapCount++;
                    if (firstBandToVisit[i][j] == 1) {
                        band1FirstCount++;
                    } else {
                        band2FirstCount++;
                    }
                }
            }
        }

        if (band1FirstCount > 0 && band2FirstCount > 0) {
            System.out.println("Impossible");
        } else {
            System.out.println(overlapCount);
        }
        
        scanner.close();
    }

    private static void simulateBand(int startX, int startY, String sequence, int bandNumber) {
        int x = startX;
        int y = startY;

        // The problem states the band occupies cells sequentially from its starting position.
        // The start position itself is part of the path.
        // Mark the starting position.
        if (gridState[x][y] == 0) {
            gridState[x][y] = bandNumber;
            firstBandToVisit[x][y] = bandNumber;
        } else if (gridState[x][y] != bandNumber) {
            gridState[x][y] = 3; // Overlap
            if (firstBandToVisit[x][y] == 0) { // Should not happen with this logic, but good practice
                firstBandToVisit[x][y] = bandNumber;
            }
        }
        
        for (char move : sequence.toCharArray()) {
            if (move == 'u') y--;
            else if (move == 'd') y++;
            else if (move == 'l') x--;
            else if (move == 'r') x++;
            
            if (gridState[x][y] == 0) {
                gridState[x][y] = bandNumber;
                firstBandToVisit[x][y] = bandNumber;
            } else if (gridState[x][y] != bandNumber) {
                gridState[x][y] = 3; // Overlap
                if (firstBandToVisit[x][y] == 0) {
                    firstBandToVisit[x][y] = bandNumber;
                }
            }
        }
    }
}