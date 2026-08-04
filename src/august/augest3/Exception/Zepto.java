package august.augest3.Exception;

public class Zepto {

    //Generate the Ordeid
    public static void main(String[] args) {
String userName="Aditya";

        String orderId = null;

        //Try catch Block
        try {
            int a = 100/0;
            String city = "BLR";

            System.out.println("Order is out for Delivery :" + city);

            orderId = userName.substring(0, 5) + "12345";
            System.out.println("Order is Delivered and tour order id is " + orderId);

        } catch (ArithmeticException a) {
            System.out.println("number can;t found");

        }
        catch (NullPointerException n){
            System.out.println("Value is null please enter some data ");

        }
        catch (Exception e){
            System.out.println("Unknown exception ");
        }


    }
}