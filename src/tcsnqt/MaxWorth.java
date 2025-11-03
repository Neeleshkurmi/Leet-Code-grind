package tcsnqt;

import java.util.*;

public class MaxWorth {

    private static int N, M, budget;
    private static String[] strings;
    private static int[] costs;
    private static Map<String, Integer> worthMap = new HashMap<>();
    private static Map<String, Set<String>> contradictoryMap = new HashMap<>();
    private static int[][] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        strings = scanner.nextLine().split(" ");
        
        costs = new int[N];
        for (int i = 0; i < N; i++) {
            costs[i] = scanner.nextInt();
        }
        scanner.nextLine();

        for (int i = 0; i < M; i++) {
            String[] pair = scanner.nextLine().split(" ");
            contradictoryMap.computeIfAbsent(pair[0], k -> new HashSet<>()).add(pair[1]);
            contradictoryMap.computeIfAbsent(pair[1], k -> new HashSet<>()).add(pair[0]);
        }

        budget = scanner.nextInt();
        scanner.close();

        // Pre-compute worth of each string
        for (String s : strings) {
            worthMap.put(s, calculateWorth(s));
        }

        // Initialize memoization table with -1
        memo = new int[N + 1][budget + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        System.out.println(solve(0, 0, new HashSet<>()));
    }

    private static int calculateWorth(String s) {
        int worth = 0;
        for (char c : s.toCharArray()) {
            worth += (c - 'a' + 1);
        }
        return worth;
    }

    private static int solve(int index, int currentCost, Set<String> selected) {
        if (index == N) {
            return 0; // Base case: no more strings to consider
        }

        if (memo[index][currentCost] != -1) {
            return memo[index][currentCost];
        }

        int maxWorth = 0;

        // Option 1: Don't include the current string
        maxWorth = Math.max(maxWorth, solve(index + 1, currentCost, selected));

        // Option 2: Include the current string, if possible
        String currentString = strings[index];
        int currentStringCost = costs[index];
        
        boolean canInclude = true;
        if (contradictoryMap.containsKey(currentString)) {
            for (String contradictoryString : contradictoryMap.get(currentString)) {
                if (selected.contains(contradictoryString)) {
                    canInclude = false;
                    break;
                }
            }
        }
        
        if (canInclude && currentCost + currentStringCost <= budget) {
            selected.add(currentString);
            int worth = worthMap.get(currentString) + solve(index + 1, currentCost + currentStringCost, selected);
            maxWorth = Math.max(maxWorth, worth);
            selected.remove(currentString); // Backtrack
        }

        return memo[index][currentCost] = maxWorth;
    }
}