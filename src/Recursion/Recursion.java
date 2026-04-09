package Recursion;
import java.util.*;

public class Recursion{
    public static void main(String[] a){
        List<List<String>> list = new ArrayList<>();

        // permute("aabaa", 0, "", list);
        solve("aabaa", 0, new ArrayList<>(), list);

        System.out.println(list);
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
}