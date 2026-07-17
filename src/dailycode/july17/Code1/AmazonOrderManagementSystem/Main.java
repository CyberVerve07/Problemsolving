package dailycode.july17.Code1.AmazonOrderManagementSystem;

public class Main {
    public static void main(String[] args) {

           Process process=new Process();

           Order oder1=new ClothingOrder(384,"Kartik",987,290);
           Order order2=new ElectronicsOrder(934,"Aditya",9888,212);
           Order order3=new GroceryOrder(4930,"Ram",899,100);

             process.process(oder1);
             process.process(order2);


    }
}
