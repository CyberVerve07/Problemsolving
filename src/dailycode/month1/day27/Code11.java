package dailycode.month1.day27;

public class Code11 {

       //Exception Handling : is An exception is an unexpected event that occurs during program execution and
    //break the flow  normal flow of execution:
    public static void main(String[] args) {
        try {
            int a=5;
            float b=89;
            System.out.println(a/b);
        }
        catch (ArithmeticException e){
            System.out.println("Division by 0  is not allowed ");
        }


    }
}