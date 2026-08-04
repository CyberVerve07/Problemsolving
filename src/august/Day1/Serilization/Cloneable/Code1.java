package august.Day1.Serilization.Cloneable;

public class Code1 implements Cloneable {

      String name;
      String adrres;
      double salary;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Code1(String name, String adrres, double salary) {
        this.name = name;
        this.adrres = adrres;
        this.salary = salary;


    }


}

 class  clone{
     public static void main(String[] args) throws CloneNotSupportedException {

         Code1 code1=new Code1("Prachii","BLR",70000);
                    Code1 code2= (Code1) code1.clone();   //Shallow copy

               code1.name="Prachi";

         Code1 e2= code1; //Simple way to clone an  object
         System.out.println(code1.name);
         System.out.println(e2.name);
         System.out.println("=========================");
         System.out.println(code1.name);
         System.out.println(code2.name);
         System.out.println(e2.hashCode());  //hashcode ek integer number hai jo object ko fast lookup ka liya use hota ha



     }

 }