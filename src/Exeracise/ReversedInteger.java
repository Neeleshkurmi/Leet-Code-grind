package Exeracise;

public class ReversedInteger {
    public int reverse(int x) {
        int ReversedNumber=0;

        while (x>0){
            int Reminder=x%10;
            ReversedNumber=ReversedNumber*10+Reminder;
            x=x/10;

        }
        return ReversedNumber;

    }
    public void rev(int n){
        int reversed=0;
        if (n>0){
            int rem= n%10;
            reversed=reversed*10+rem;
            n/=10;
        } else if (n<0) {

        }
    }

}
