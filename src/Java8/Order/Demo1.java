package Java8.Order;

interface   Demo1 {

     void  buy();

      default void  refund(){
         System.out.println("Refund is Credit : ");
     }
     
}
