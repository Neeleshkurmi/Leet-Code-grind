package Methods;

public class Alike {
    public static boolean halvesAreAlike(String s) {

        int mid = s.length()/2;
        String s1= s.substring(0,mid);
        String s2 = s.substring(mid);
        int count1=0, count2=0;
        for (int i = 0; i < s2.length(); i++) {
            if(s1.charAt(i)=='a'||s1.charAt(i)=='A'||s1.charAt(i)=='E'||s1.charAt(i)=='e'||s1.charAt(i)=='i'||s1.charAt(i)=='I'||s1.charAt(i)=='O'||s1.charAt(i)=='o'||s1.charAt(i)=='U'||s1.charAt(i)=='u'){
                count1++;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if(s2.charAt(i)=='a'||s2.charAt(i)=='A'||s2.charAt(i)=='E'||s2.charAt(i)=='e'||s2.charAt(i)=='i'||s2.charAt(i)=='I'||s2.charAt(i)=='O'||s2.charAt(i)=='o'||s2.charAt(i)=='U'||s2.charAt(i)=='u'){
                count2++;
            }
        }
        return count1== count2?true:false;

    }

    public static void main(String[] args) {
        String s="book";
        System.out.println(halvesAreAlike(s));
    }
}
