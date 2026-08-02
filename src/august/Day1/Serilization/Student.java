package august.Day1.Serilization;

import java.io.Serializable;

public class Student implements Serializable {

    private  String name;
    private int rollNo;
    private  String grade;

    //Create  Constructors


    public Student(String name, int rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

       //Create the Getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
