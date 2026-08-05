package august.augest5;

public class Zepto {

    public static void main(String[] args) {

        try {
            order("Biscoff","830993" ,30);
        }
        catch (IllegalArgumentException a){
            System.out.println(a.getMessage());
        }
    }
        static void   order(String itemName,String orderId,double price) {

            if (orderId == null || orderId.isBlank()) {
                throw new IllegalArgumentException("Order id can't be empty:");
            }
            System.out.println("Order name is "+itemName);
            System.out.println("Order id is "+orderId);
            System.out.println("Price is "+price);
        }
}
