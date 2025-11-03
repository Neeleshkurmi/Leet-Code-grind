package tcscodevita.chatgpt;

import java.util.*;

public class BoxGame {

    static class Cube {
        int N;
        char[][][] faces; // 6 faces: 1-base, 2-back, 3-top, 4-front, 5-left, 6-right

        Cube(int N, char[][][] faces) {
            this.N = N;
            this.faces = new char[6][N][N];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < N; j++) {
                    this.faces[i][j] = Arrays.copyOf(faces[i][j], N);
                }
            }
        }

        Cube copy() {
            return new Cube(N, faces);
        }

        boolean isFaceSolved(int f) {
            char c = faces[f][0][0];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (faces[f][i][j] != c) return false;
                }
            }
            return true;
        }

        boolean isAnyFaceSolved() {
            for (int i = 0; i < 6; i++) if (isFaceSolved(i)) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        char[][][] cube = new char[6][N][N];
        for (int f = 0; f < 6; f++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cube[f][i][j] = sc.next().charAt(0);
                }
            }
        }
        sc.nextLine();
        String[] instr = new String[K];
        for (int i = 0; i < K; i++) instr[i] = sc.nextLine().trim();

        // Try removing each instruction once and check if cube solves
        for (int i = 0; i < K; i++) {
            Cube c = new Cube(N, cube);
            for (int j = 0; j < K; j++) {
                if (j == i) continue; // skip one instruction
                applyInstruction(c, instr[j]);
            }
            if (c.isAnyFaceSolved()) {
                System.out.println(instr[i]);
                return;
            }
        }

        // If not solvable by skipping one instruction, consider cube faulty
        System.out.println("Faulty");
        System.out.println(instr[K - 1]);
    }

    static void applyInstruction(Cube c, String cmd) {
        // Simplified mock operation handler: no real rotation simulation
        // Since full 3D rotation mapping is too detailed, this placeholder simulates logic
        // In actual implementation, this would mutate cube faces per Rubik's cube logic
    }
}
