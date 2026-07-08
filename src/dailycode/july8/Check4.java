package dailycode.july8;

public class Check4{
    public static void main(String[] args) {
        Student ck=new Student("Aditya",20,87);
        ck.setName("Aditya");
        ck.setAge(19);
        ck.setMarks(89);


        System.out.println("Name of the student is :"+ck.getName());
        System.out.println("Student age is :"+ck.getAge());
        System.out.println("Student marks is :"+ck.getMarks());
    }
}
