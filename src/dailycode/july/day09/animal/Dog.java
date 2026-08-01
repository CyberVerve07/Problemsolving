package dailycode.july.day09.animal;

public class Dog  extends  Animal{

     String home;

     public Dog(String name, String bread, int age) {
         super(name, bread, age);
     }

     void  bark(){
         System.out.println("woff woff woff "+this.name);
     }
     
}

