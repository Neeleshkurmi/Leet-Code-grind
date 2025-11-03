package Methods;

import java.util.Locale;

public class Pallindorme_String {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Move left pointer until we find an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer until we find an alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare the characters at left and right pointers (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt
                    (right))) {
                return false;
            }

            // Move both pointers inward
            left++;
            right--;
        }
        return true;

    }

    public static void main(String[] args) {
        String s= "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
