package Exeracise;

public class LinearSearch{
public static void  main (String [] args){

    int[] arr={12,34,56,78,90};
    java.util.Scanner sc= new java.util.Scanner(System.in);
     System.out.println("Enter the value of x:");
    int x= sc.nextInt();
    int flag=0;
    
   

for(int i=0; i<=arr.length; i++){
    if(arr[i]==x){
       flag=1;
       break;
    }

}
if(flag==1){
    System.out.println("found");
}
else{
    System.out.println("not found");
}
}

}