package student;

public class Dav {
    //Attributes
  public String name;
   public int  age;
   public int  rollNo;
   private String gf;

   //getters or setters
    public String getName(){
        return this.name;
    }

    //Constructor
   public Dav() {
    System.out.println("Constructor is call");
   }

        //Parameterized constructor:
     public Dav(String name, int age, int rollNo,String gf) {
         this.name = name;  //
         this.age = age;
         this.rollNo = rollNo;
     }

     //Methods
    void  study(){
        System.out.println(name+"Problems.Study");
    }
    //Method2
     void  sleep(){
         System.out.println(name+" sleeping ");

     }
     void  bunk(){
         System.out.println(name+"he is into bunk ");
     }
     void lunch(){
         System.out.println(name+"Eating lunch");
     }
     private  void gfChatting(){
         System.out.println(name+"Bro is chatting ");
     }


}
