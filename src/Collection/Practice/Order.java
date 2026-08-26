package Collections.Practice;

public interface Order {

    abstract  void  electronics();

     default  void  discount(){
         System.out.println("5% discount is available : ");
     }


}
