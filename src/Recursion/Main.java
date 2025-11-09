package Recursion;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        generateSubsequences(arr, 0, new ArrayList<>(), result);
        result.sort((a, b) -> {
            if (a.size() != b.size()) return a.size() - b.size();
            int n = Math.min(a.size(), b.size());
            for (int i = 0; i < n; i++) {
                if (!a.get(i).equals(b.get(i)))
                    return a.get(i) - b.get(i);
            }
            return 0;
        });
/**/
        // print all subsequences
        for (List<Integer> seq : result) {
            System.out.println(seq);
        }
    }

    static void generateSubsequences(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        if(index== arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(arr[index]);
        generateSubsequences(arr,index+1, current, result);

        current.removeLast();
        generateSubsequences(arr, index+1, current,result);
    }
}