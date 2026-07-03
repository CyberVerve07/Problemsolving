package July2;

public class Animal {
    //Animal
    //↑
    //Dog
    //
    //Use inheritance.
    //
    //Dog should access the parent method.
    public String name;
    public int  age;
    public String eyes;
    Animal(){
        //default constructor
    }

      Animal(String name,int age,String eyes){
          this.name=name;
          this.age=age;
          this.eyes=eyes;


      }
        void sleep(){
            System.out.println("Animal into the sleep "+this.name);
        }
}
