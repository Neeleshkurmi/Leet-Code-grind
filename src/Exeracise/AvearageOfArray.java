package Exeracise;

public class AvearageOfArray {
    public static void main(String[] args) {
        //declaring an array
        int[] arr={12,45,78,34,56};
        //variable to store sum of array
        double sum=0;
        //to calculate the sum of array
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        //calculating the average of array
        double avg=sum/arr.length;
        System.out.println("the average of array is: "+avg);
        //the numbers in array that are grater then average
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=avg){
                System.out.println("the numbers that are greater than or equals average are: "+arr[i]);
            }
        }

    }
}
