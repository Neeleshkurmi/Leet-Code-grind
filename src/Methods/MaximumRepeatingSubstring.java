package Methods;

public class MaximumRepeatingSubstring {
    public static int maxRepeating(String sequence, String word) {

      int count =0 ;
      String repeated =word;
      while(sequence.contains(repeated)){
          count++;
          repeated+=word;
      }
      return count;
    }

    public static void main(String[] args) {
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        String word = "aaaba";
        System.out.println(maxRepeating(sequence, word));
        String seq ="ababc", word2 = "ba";
        System.out.println(maxRepeating(seq,word2));

    }
}
