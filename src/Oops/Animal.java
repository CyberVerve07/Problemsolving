package Oops;

public class Animal {
    //Data members properties of a class  data members ::
    String name;
    String bread;
    String color;
    int age;

     //constructor
    Animal( String animalName,int AnimalAge1){
        name=animalName;
        age=AnimalAge1;
    }
  void run(){
      System.out.println( name+ "is running ");

  }
   void hunt(){
      System.out.println("Age is"+age );
  }

    public static void main(String[] args) {
        System.out.println("Start");
        Animal dog= new Animal();

        dog.run();







    }
}

