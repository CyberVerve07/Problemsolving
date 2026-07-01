package Day29;
class Animal {

    String name = "Animal";

    Animal() {   //constructor
        System.out.println("Animal Constructor");
    }

    void sound() {   //method
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal { //class name

    String name;

    Dog(String name) {
        super();              // Parent constructor call use to access the members
        this.name = name;     // this refers to the current object of the class where it is used.
        //this call same class constructor
    }

    void display() {
        System.out.println("Parent Name : " + super.name); // Parent variable
        System.out.println("Dog Name    : " + this.name);  // Current object variable

        super.sound(); // Parent method call
    }
}

  class Main {
    public static void main(String[] args) { //main method call the methods display

        Dog d = new Dog("Tommy");
        d.display();
        d.sound();
    }
}