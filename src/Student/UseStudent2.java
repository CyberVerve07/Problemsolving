package student;

public class UseStudent2 extends  Dav {
    public static void main(String[] args) {
       //Dav ka student 2
        Dav Student2=new Dav();//object
        Student2.name="Ashish";
        Student2.age=24;
        Student2.rollNo=20;

        //Print the data

        System.out.println("The student name is "+Student2.name);
        System.out.println("Student age is "+Student2.age);
        System.out.println("Student rollno is "+Student2.rollNo);


         Student2.study();
         Student2.bunk();
         Student2.sleep();

    }
}
