package dailycode.july20.Ecom;

public class Main {
    public static void main(String[] args) {

           OrderManagement orderManagement=new PremimuUser("29083",794,"Clothes");
           OrderManagement orderManagement1= new PremimuUser("747399",555,"I Phone");
           OrderManagement orderManagement2=new Reseller("73974",938,"Laptop");

           orderManagement1.getOrderStatus();

           orderManagement1.placeOrder();
           orderManagement1.editOrder();
           orderManagement1.conformOrder();
    }
}
