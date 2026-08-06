package august.augest6;
public class Demo4 {

    public static void main(String[] args) {

        try {

            System.out.println("A");

            int x = 10 / 0;

        }
        catch (Exception e){

            System.out.println("B");

            throw new NullPointerException();

        }
        finally{

            System.out.println("C");

        }

        System.out.println("D");

    }

}
