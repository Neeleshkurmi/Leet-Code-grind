package collectionframework;
import java.util.ArrayList;

public class CustomArrayList {
    public static void main(String[] args) {
       ArrayList<Integer> list = new ArrayList<>(10);
        System.out.println(list.size());
        for (int i = 1; i <15; i++) {
            list.add(i);
        }
        System.out.println(list.size());
//        System.out.println(list);
        System.out.println(list.toString());
        System.out.println(list);
    }
}
