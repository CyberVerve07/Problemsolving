package august.augest3;

 interface OrderService {


      abstract  void  Details();


       default void discount(){
           System.out.println("Discount is applied: 5%");

       }





}
