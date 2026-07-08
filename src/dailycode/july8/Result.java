package dailycode.july8;

public class Result {
    /// *
    //Question 11: Student Result System
    //
    //Create a Student class.
    //
    //Private Variables:
    //- name
    //- marks
    //
    //Methods:
    //- Constructor
    //- Getter & Setter
    //- calculateResult()
    //
    //Rules:
    //- marks between 0-100
    //
    //Output:
    //
    //Name : Rahul
    //Marks : 78
    //Result : Pass
    //
    //If marks < 40
    //
    //Result : Fail
    //*/
    private String name;
    private int marks;

    Result(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100) {

        } else {
            System.out.println("You enter Invalid marks :");
        }

        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;

    }

    void checkResult(int marks)
    {
        if (marks>=40){
            System.out.println("PASS ");
            this.marks=marks;

        }
        else {
            System.out.println("Fail");
        }

    }
}