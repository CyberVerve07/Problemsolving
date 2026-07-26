package student;

public class UseStudent3 {
    public static void main(String[] args) {
         //create ana new onject
        Dav Student3= new Dav();
        Student3.name="Harsh";
        Student3.age=19;
        Student3.rollNo=6;
        //  Print values
        System.out.println("The name of the student is "+Student3.name);
        System.out.println("The Age of the Student is "+Student3.age);
        System.out.println("The Roll no of the Student is "+Student3.rollNo);
        //Method call
        Student3.study();
        Student3.sleep();;
        Student3.bunk();

    }
}
