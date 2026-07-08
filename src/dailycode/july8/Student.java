package dailycode.july8;

public class Student {
    ///*
    //Question 1: Student Management
    //
    //Create a Student class.
    //
    //Private Variables:
    //- name
    //- age
    //- marks
    //
    //Methods:
    //- Constructor
    //- Getters & Setters
    //
    //Conditions:
    //- Age > 0
    //- Marks must be between 0 and 100.
    //
    //Create object in main() and print all details.
    //*/

           private  String name;
           private  int age;
           private  int marks;


                 //Methods
                Student(String name,int age ,int marks ){

                }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
                    if (marks >100)
                        System.out.println("Extra marks for good handwriting:");
        this.marks = marks;
    }

    public void setAge(int age)
    {
        if (age<0){
            System.out.println("Invalid age::");
        }
        this.age = age;
    }
}
