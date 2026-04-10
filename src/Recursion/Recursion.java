package Recursion;
import java.util.*;

public class Recursion{
    public static void main(String[] a){
        List<List<String>> list = new ArrayList<>();

        // permute("aabaa", 0, "", list);
        // solve("aabaa", 0, new ArrayList<>(), list);

        // System.out.println(list);

        System.out.println(isAnagram("abaaca", "caabaa"));

        // System.out.println((int)'b');
        // System.out.println((int)'c');
        //     "abca", "caba"
        // ));


    }

    public static void permute(String s, int index, String ans, List<String> res){
        if(s.length() == index){
            ans = ans.trim();
            if(!ans.isEmpty() && isPalindrome(ans)){
                res.add(ans);
                return;
            }
            return;
        }

        ans+= s.charAt(index);
        permute(s, index+1, ans, res);

        ans = ans.substring(0, ans.length()-1);
        permute(s, index+1, ans, res);
    }

    static boolean isPalindrome(String s){
        String temp = "";

        for(int i=s.length()-1; i>=0; i--){
            temp+= s.charAt(i);
        }
        return temp.equals(s);
    }


    /*

    solve(index):
    if index == n:
        store path
        return

    for end = index to n-1:
        if palindrome(index, end):
            add substring
            solve(end + 1)
            remove last



    [ [ "a", "a", "b", "a", "a"] , [ "a", "a", "b", "aa"] , [ "a", "aba", "a"] , [ "aa", "b", "a", "a"] , [ "aa", "b", "aa" ] , [ "aabaa" ] ]


    */

    static void solve(String s, int index, List<String> temp, List<List<String>> res){
        if(index == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i<s.length(); i++){
            String sub = s.substring(index, i+1);
            if(isPalindrome(sub)){
                temp.add(sub);
                solve(s, i+1, temp, res);
                temp.removeLast();
            }
        }
    }

    static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        int[] ch = new int[26];

        for(int i=0; i<s.length(); i++){
            ch[s.charAt(i) - 'a']++;
            ch[t.charAt(i) - 'a']--;
        }

        for(int num: ch){
            if(num!=0) return false;
        }
        return true;
    }


    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();

        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        dfs("", 0, digits, res, map);
        return res;
    }

    void dfs(String curr, int index, String digits, List<String> res, Map<Integer, String> map){
        
        if(digits.length() == index){
            res.add(curr);
            return;
        }

        String letters = map.get(digits.charAt(index) - '0');

        for(char ch : letters.toCharArray()){
            dfs(curr + ch, index + 1, digits, res, map);
        }
    }
}