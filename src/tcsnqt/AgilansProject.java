package tcsnqt;

import java.util.*;

public class AgilansProject {

    static class Instruction {
        String direction;
        int distance;

        Instruction(String direction, int distance) {
            this.direction = direction;
            this.distance = distance;
        }
    }

    // Directions: 0=N, 1=E, 2=S, 3=W
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        Instruction[] instructions = new Instruction[N];
        for (int i = 0; i < N; i++) {
            String[] parts = scanner.nextLine().split(" ");
            instructions[i] = new Instruction(parts[0], Integer.parseInt(parts[1]));
        }

        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        int rabinX = scanner.nextInt();
        int rabinY = scanner.nextInt();
        scanner.close();

        String[] possibleTurns = {"left", "right", "straight", "back"};

        for (int i = 0; i < N; i++) {
            for (String newTurn : possibleTurns) {
                if (newTurn.equals(instructions[i].direction)) {
                    continue; // No change
                }
                
                int currentX = startX;
                int currentY = startY;
                int currentDir = 0; // 0: N, 1: E, 2: S, 3: W
                
                // Simulate path up to the incorrect turn
                for (int j = 0; j < i; j++) {
                    currentDir = getNewDirection(currentDir, instructions[j].direction);
                    currentX += dx[currentDir] * instructions[j].distance;
                    currentY += dy[currentDir] * instructions[j].distance;
                }

                // Apply the new, correct turn
                int newDir = getNewDirection(currentDir, newTurn);
                int newX = currentX + dx[newDir] * instructions[i].distance;
                int newY = currentY + dy[newDir] * instructions[i].distance;

                // Simulate rest of the path
                currentX = newX;
                currentY = newY;
                currentDir = newDir;
                
                for (int j = i + 1; j < N; j++) {
                    currentDir = getNewDirection(currentDir, instructions[j].direction);
                    currentX += dx[currentDir] * instructions[j].distance;
                    currentY += dy[currentDir] * instructions[j].distance;
                }
                
                if (currentX == rabinX && currentY == rabinY) {
                    System.out.println("Yes");
                    System.out.println(instructions[i].direction + " " + instructions[i].distance);
                    System.out.println(newTurn + " " + instructions[i].distance);
                    return;
                }
            }
        }
        
        System.out.println("No");
    }

    private static int getNewDirection(int currentDir, String turn) {
        switch (turn) {
            case "left":
                return (currentDir + 3) % 4;
            case "right":
                return (currentDir + 1) % 4;
            case "back":
                return (currentDir + 2) % 4;
            case "straight":
            default:
                return currentDir;
        }
    }
}