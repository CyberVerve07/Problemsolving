package Student;

public class Dav {
    //Attributes
  public String name;
   public int  age;
   public int  rollNo;

    //Constructor
   public Dav() {
    System.out.println("Constructor is call");
   }

        //Parameterized constructor:
     public Dav(String name, int age, int rollNo) {
         this.name = name;
         this.age = age;
         this.rollNo = rollNo;
     }

     //Methods
    void  study(){
        System.out.println(name+"Study");
    }
    //Method2
     void  sleep(){
         System.out.println(name+" sleeping ");

     }
     void  bunk(){
         System.out.println(name+"he is into bunk ");
     }


}
