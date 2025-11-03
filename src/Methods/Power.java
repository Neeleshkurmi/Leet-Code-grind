package Methods;

public class Power {

        public static double pow(double x,double n){
            double res=1;
            boolean isNegative = n < 0;
            n = Math.abs(n); // Make n positive for the loop

            for (int i = 1; i <= (int) n; i++) {
                res *= x;
            }

            // If the power was negative, take the reciprocal
            if (isNegative) {
                res = 1 / res;
            }

            return res;

        }



}

