package august.augest4.Practice;

public class Demo5 {
    public static void main(String[] args) {
        try{

            int x=10/0;

        }
        catch(ArithmeticException e){

            System.out.println("Catch");
            System.out.println("Catch handles");

        }
        finally{

            System.out.println("Finally");

        }
    }
}
