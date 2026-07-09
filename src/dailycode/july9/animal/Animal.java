package dailycode.july9.animal;

public class Animal {
    ///*
    //Question 1: Animal
    //
    //Create a parent class Animal.
    //
    //Method:
    //- eat()
    //
    //Create child class Dog.
    //
    //Method:
    //- bark()
    //
    //Create object of Dog and call both methods.
    //*/

     String name;
     String  bread;
      int  age ;


         //Blank const
     public  Animal(){

     }

    public Animal(String name,String bread,int age)
    {
        this.name = name;
        this.bread = bread;
        this.age=age;
    }

    void  eat(){
              System.out.println("Animal is Eating ::"+name);
              System.out.println(bread);
              System.out.println(age);
          }


}
