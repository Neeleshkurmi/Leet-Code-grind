package Math_Searching;

public class Smallest_Word {
    public static char nextGreatestLetter(char[] letters, char target) {
        int start =0, end =letters.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
//            if(target <letters[mid] && target>letters[start]){
//                return letters[start+1];
//            }
            if(target<letters[mid]){
                end  =mid-1;
            }
            if(target>letters[mid]){
                start = mid +1;
            }
            else if(letters[mid]==target){
                return letters[mid+1];
            }

        }
        return letters[0];
    }

    public static void main(String[] args) {
      char [] n= {'c','f','j'};
        System.out.println(nextGreatestLetter(n,'a'));
        System.out.println(nextGreatestLetter(n, 'c'));
        System.out.println(nextGreatestLetter(n,'d'));
    }
}
