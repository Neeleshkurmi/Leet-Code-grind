package Methods;

public class Longest_Common_Prefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return ""; // If input is empty or null
        }

        // If there's only one string, return it as the prefix
        if (strs.length == 1) {
            return strs[0];
        }

        // Handle strings with empty values
        for (String str : strs) {
            if (str.isEmpty()) {
                return ""; // No prefix if any string is empty
            }
        }
        String str1 = strs[0];
        String str2 = strs[1];
        String str3 = strs.length > 2 ? strs[2] : "";
        String ans = "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                for (int k = 0; k <str3.length() ; k++) {
                    if(str1.charAt(i)==str2.charAt(j) && str1.charAt(i)==str3.charAt(k)){ ans += str1.charAt(i);
                    }
                }
            }
        }
        if(ans.isEmpty()){
            return ans;
        }
        return ans;
    }


    public static void main(String[] args) {

//        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // Output: "fl"
//        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
//        System.out.println(longestCommonPrefix(new String[]{"", "b", "c"}));              // Output: ""
//        System.out.println(longestCommonPrefix(new String[]{"a"}));                       // Output: "a"
//        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));

    }
}
