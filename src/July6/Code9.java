package July6;

public class Code9 {
    //
    //Default constructor
    //Parameterized constructor
    //
    //Print a message from both constructors.
      public  String name;
      public  int id;
      public String dept;

       Code9(String name,int id,String dept){
           this.name=name;
           this.id=id;
           this.dept=dept;}

           void employee(){
               System.out.println( "Employee is  currently busy ::" +this.name);
           }


    public static void main(String[] args) {
        Code9 work=new Code9("Aditya",3739,"IT");
        work.employee();

    }
    }



