package dailycode.july06;

public class Code08 {
    public  String name;
    public  int age;
    public  String course;

     Code08(String name,int age,String course){
         this.name=name;
         this.age=age;
         this. course=course;

     }

       void study(){
           System.out.println("Print Student Details::");
           System.out.println("______________________");
         System.out.println("Student is study ::" +this.name);

           System.out.println(this.age);

           System.out.println(this.course);

       }
}
