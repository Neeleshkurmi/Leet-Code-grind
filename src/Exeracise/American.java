package Exeracise;

public class American {
    public static void main(String[] args) {

        for(int i=0; i<=5; i++){
            if(i%2==0){
                System.out.println(" *** ");
            }
            else {
                System.out.println("*****");
            }
            for(int j=0,n=28; j<=n; j++){
                System.out.print("=");
            }
        }
        int n=32;
        for(int i=0; i<=4; i++){
            for(int j=0; j<=n; j++){
                System.out.print("=");
            }
            System.out.println();
        }
    }
}
