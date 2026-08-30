package Java8.Lambda;

 interface  Demo2 {

     static void  sayHello(){
         System.out.println("Hello Java");
     }

     default void By(){
         System.out.println("By java");
     }


}

  class B implements Demo2{

      public static void main(String[] args) {
Demo2 demo2=new Demo2() {
    @Override
    public void By() {
        Demo2.super.By();
    }
};
          Demo2.sayHello();
          demo2.By();
      }
  }
