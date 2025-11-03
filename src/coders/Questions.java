package coders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Questions {

    public  String disemvowel(String str) {
        return str.replaceAll("(?i)[aeiou]","");

    }

    public int removeElement(int[] a, int val) {
        int s= 0, e = a.length-1;

        while(e>=s){
            if(a[s]==val){
                if(a[e]==val){
                    e--;
                }
                a[s]=a[e];
                e--;
            }
            s++;
        }
        return s+1;
    }

    public int[] plusOne(int[] digits) {

        String s="";

        for(int i=0; i<digits.length; i++){
            s+=digits[i];
        }
        int n= Integer.valueOf(s);
        n+=1;
        s = String.valueOf(n);
        int[] ans = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            ans[i]= Character.getNumericValue(s.charAt(i));
        }
        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<>();
        int a = 1;
        for(int i=0; i<=numRows; i++){
            int temp = a;
            while(temp>0){
                l.add(List.of(temp%10));
                temp/=10;
            }
            a=a*10+a;
        }
        return l;
    }

    public ArrayList<Integer> union(int[] a1, int[] a2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        Integer prev = null;

        while (i < a1.length && j < a2.length) {
            int val;
            if (a1[i] < a2[j]) {
                val = a1[i++];
            } else if (a1[i] > a2[j]) {
                val = a2[j++];
            } else {
                val = a1[i];
                i++;
                j++;
            }
            if (!valEquals(val, prev)) {
                list.add(val);
                prev = val;
            }
        }

        // Process remaining elements in a1
        while (i < a1.length) {
            if (!valEquals(a1[i], prev)) {
                list.add(a1[i]);
                prev = a1[i];
            }
            i++;
        }

        // Process remaining elements in a2
        while (j < a2.length) {
            if (!valEquals(a2[j], prev)) {
                list.add(a2[j]);
                prev = a2[j];
            }
            j++;
        }

        return list;
    }
    public ArrayList<Integer> unions(int[] a1, int[] a2){
        ArrayList<Integer> list = new ArrayList<>();
        int i=0, j=0, prev=-1;

        while(i<a1.length && j < a2.length){
            if (a1[i] < a2[j]) {
                if (a1[i] != prev) {
                    list.add(a1[i]);
                    prev = a1[i];
                }
                i++;
            } else if (a1[i] > a2[j]) {
                if (a2[j] != prev) {
                    list.add(a2[j]);
                    prev = a2[j];
                }
                j++;
            } else { // a1[i] == a2[j]
                if (a1[i] != prev) {
                    list.add(a1[i]);
                    prev = a1[i];
                }
                i++;
                j++;
            }
        }
        if (i==a1.length && j < a2.length) {
            for(int k=j; k<a2.length; k++){
                if(a2[k]!=prev) {
                    list.add(a2[k]);
                    prev=a2[k];
                }
            }
        }
        else if (i<a1.length && j == a2.length) {
            for(int k=i; k<a1.length; k++){
                if(a1[k]!=prev) {
                    list.add(a1[k]);
                    prev=a1[k];
                }
            }
        }
        return list;
    }

    // Helper method for null-safe comparison
    private boolean valEquals(Integer a, Integer b) {
        return a != null && a.equals(b);
    }


    public static void main(String[] args) {
        int n =5;
        for(int i=n-2; i>=0; i--) {
            int space = (n / 2) - i;

            for (int j = 1; j <= space + 1; j++) {
                System.out.print(" ");
            }
            int stars = i + 1;
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= space + 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
//        Questions q = new Questions();
//        String str="This website is for losers LOL!";
//        System.out.println(Questions.disemvowel(str));
//        int[] arr = {0,1,2,2,3,0,4,2};
//        System.out.println(q.removeElement(arr,2));
//
//        int [] arr = {1};
//        System.out.println(q.removeElement(arr,1));
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(q.plusOne(new int[]{1,2,3})));
//        System.out.println(q.generate(5));
//        System.out.println(q.unions(new int[] {1, 2, 2},new int[]  {2, 2, 3, 3}));

    }
}
