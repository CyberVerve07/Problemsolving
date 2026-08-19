package august.augest8;



class A{
     void show1(){
        System.out.println("Show 1");
    }
//Typecasting (or type conversion) is the process of changing a variable or
// value from one data type to another,

        }
         class B extends A {
    void show2(){
        System.out.println("Show 2");
    }
         }

public class Demo7 {

    public static void main(String[] args) {

         A obj= new B();  //Upcasting
         obj.show1();

    }
}
//Upcasting is the process of treating a child-class object as a reference of its parent class.
// It is an implicit and generally safe conversion because a child object is also a parent-type object.