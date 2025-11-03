package tcscodevita.copilot;
import java.util.*;

public class Solution {
    static class State {
        String arrangement;
        int shifts;

        State(String arrangement, int shifts) {
            this.arrangement = arrangement;
            this.shifts = shifts;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Read the arrangement
        String[] items = sc.nextLine().split(" ");
        StringBuilder original = new StringBuilder();
        for(String item : items) {
            original.append(item);
        }

        // Read fixed positions
        String[] fixedPosStr = sc.nextLine().split(" ");
        Set<Integer> fixedPos = new HashSet<>();
        for(String pos : fixedPosStr) {
            fixedPos.add(Integer.parseInt(pos) - 1); // Convert to 0-based index
        }

        int result = solve(original.toString(), fixedPos);
        if(result == -1) {
            System.out.println("Impossible");
        } else {
            System.out.println(result);
        }
    }

    private static int solve(String original, Set<Integer> fixedPos) {
        int n = original.length();

        // Count characters for verification
        int[] charCount = new int[3];
        for(char c : original.toCharArray()) {
            charCount[c - 'A']++;
        }

        // Generate all possible valid sequences
        List<String> validSequences = new ArrayList<>();
        String[] blocks = {"A", "B", "C"};
        generateValidSequences(n, "", blocks, charCount, validSequences);

        int minShifts = Integer.MAX_VALUE;

        // Check each valid sequence
        for(String sequence : validSequences) {
            boolean isValid = true;

            // Check fixed positions
            for(int pos : fixedPos) {
                if(sequence.charAt(pos) != original.charAt(pos)) {
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                int shifts = calculateShifts(original, sequence);
                minShifts = Math.min(minShifts, shifts);
            }
        }

        return minShifts == Integer.MAX_VALUE ? -1 : minShifts;
    }

    private static void generateValidSequences(int n, String current, String[] blocks, int[] charCount, List<String> result) {
        if(current.length() == n) {
            result.add(current);
            return;
        }

        for(String block : blocks) {
            char c = block.charAt(0);
            if(charCount[c - 'A'] > 0) {
                charCount[c - 'A']--;
                generateValidSequences(n, current + c, blocks, charCount, result);
                charCount[c - 'A']++;
            }
        }
    }

    private static int calculateShifts(String original, String target) {
        int shifts = 0;
        char[] curr = original.toCharArray();
        char[] targ = target.toCharArray();
        int n = curr.length;

        for(int i = 0; i < n; i++) {
            if(curr[i] != targ[i]) {
                // Find the position of target character
                int j;
                for(j = i + 1; j < n; j++) {
                    if(curr[j] == targ[i]) {
                        break;
                    }
                }

                // Shift elements
                char temp = curr[j];
                for(int k = j; k > i; k--) {
                    curr[k] = curr[k-1];
                    shifts++;
                }
                curr[i] = temp;
            }
        }

        return shifts;
    }
}