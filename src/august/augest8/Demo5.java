package august.augest8;

public class Demo5 {
     static  int  count=0;
      Demo5(){
          count++;
      }

    public static void main(String[] args) {
        Demo5 demo5=new Demo5();
        Demo5 demo6=new Demo5();
        System.out.println(Demo5.count);
    }


}
