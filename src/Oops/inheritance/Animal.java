package oops.inheritance;

public class Animal {
    public String name;
    public int age;
     Animal(){

     }
    // constructor
        Animal(String name,int age){
            this.name=name;
            this.age=age;
        }
         void  eat (){// function
             System.out.println("Animal is eating food "+name);
         }
}
