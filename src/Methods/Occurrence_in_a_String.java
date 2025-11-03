public class Occurrence_in_a_String {
    public static int strStr(String haystack, String needle) {
       if(needle.isEmpty()){
           return 0;
       }
       return haystack.indexOf(needle);
    }
    public static int strStr2(String haystack, String needle) {
        // Handle edge cases
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        // Sliding window approach
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle ="sad";
        System.out.println(strStr2(haystack,needle));
    }
}
