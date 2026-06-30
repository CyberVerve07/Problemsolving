package Oops;

public class Anaimal {
    public String name;
    public int age;
     Anaimal(){

     }
    // constructor
        Anaimal(String name,int age){
            this.name=name;
            this.age=age;
        }
         void  eat (){// function
             System.out.println("Animal is eating food "+name);
         }
}
