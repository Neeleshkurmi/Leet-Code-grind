package numbertheory;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<deck.length; i++){
            if(map.containsKey(deck[i])){
                map.put(deck[i],map.getOrDefault(deck[i],0)+1);
            }
            else map.put(deck[i], 1);
        }

        int counter = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(counter ==0)counter = entry.getValue();

            else if(counter!=0){
                if( counter != entry.getValue()) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3}));
    }
}
