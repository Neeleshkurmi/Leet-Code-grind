public class TwoSum {
    public static void main(String[] args) {
        int arr={};
        int target;
        for(int i=0; i<=arr.length; i++){
            for(int j=1; j<=arr.length; j++){
                if(i*j==target){
                    return i , j ;
                }
            }
        }
    }
}
