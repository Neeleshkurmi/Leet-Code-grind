package Exeracise;

public class StringToInteger {

        public static String multiply(String num1, String num2) {
            char[] ch= num1.toCharArray();
            String sum="";
            int c=ch.length;
            char[] ch1= num2.toCharArray();
            int c1= ch1.length;

            for(int i=0; i<c; i++){
                for(int j=1; j<c1; j++){
                    int product=i*j;
                    System.out.println(product);
                }
            }
            return sum;
        }

    public static void main(String[] args) {
        String re= multiply("123","234");
        System.out.println(re);
    }
}
