package Methods;

import java.util.List;

public class MatchingRule {
    public static void main(String[] args) {
       List<List<String>>s;
      
    }
    public static int Match(List<List<String>> items, String rulekey, String rulevalue){
        int count=0,KeyIndex=-1;
        if(rulekey.equals("type")){
            KeyIndex=0;
        } else if (rulekey.equals("color")) {
            KeyIndex=1;
        } else if (rulekey.equals("name")) {
            KeyIndex=2;
        }
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).get(KeyIndex).equals(rulevalue)){
                count++;
            }
        }
        return count;
    }
}
