package Problem2;

public class Student {
    private String StudentName;
    private int age;
    private  String course;

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }



    // Create Constructor
      Student(String StudentName,int age,String course){
          this.StudentName=StudentName;
          this.age=age;
          this.course=course;

          }
          void  display(){
              System.out.println(StudentName);
              System.out.println(age);
              System.out.println(course);

          }





      }


