package Exeracise;

public class devide {
    public int devide(int number,int devisor){

        int res=0;
        int count=0;
        while(number>0){
          res  = number-devisor;
          count++;
        }
        return count;
    }

}
