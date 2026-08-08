package august.augest8;

public class Demo6 {

  static  int a;

   static {
       System.out.println("Hello");
       //The static block executes during class initialization, before the main() method executes."
       //"Jab class initialize hoti hai, uske static initialization ka kaam pehle hota hai. Uske baad main execute hota hai."
   }

    public static void main(String[] args) {
        System.out.println("Java");
    }

}
