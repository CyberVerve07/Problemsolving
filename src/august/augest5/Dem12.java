package august.augest5;

public class Dem12 {
    public static void main(String[] args) {
        System.out.println("Start Program ");

            try {
                System.out.println("Outter try block");
                try {
                    System.out.println("Inner  try block");
                    System.out.println(90/0);

                }catch (NullPointerException n){
                    System.out.println("Null pointer exception is through :");
                }
            }catch (ArithmeticException a){
                System.out.println("Exception is found ");
            }





    }

}
