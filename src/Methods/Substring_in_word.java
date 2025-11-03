package Methods;

public class Substring_in_word {
    public static int numOfStrings(String[] patterns, String word) {
        int count=0;
        for (String pattern : patterns) {
          if (word.contains(pattern)){
              count++;
          }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] s = {"a","abc","bc","d"};
        String word ="abc";
        System.out.println(numOfStrings(s, word));
    }
}
