package dailycode.july06;

public class Code09 {
    //
    //Default constructor
    //Parameterized constructor
    //
    //Print a message from both constructors.
      public  String name;
      public  int id;
      public String dept;

       Code09(String name,int id,String dept){
           this.name=name;
           this.id=id;
           this.dept=dept;}

           void employee(){
               System.out.println( "Employee is  currently busy ::" +this.name);
           }


    public static void main(String[] args) {
        Code09 work=new Code09("Aditya",3739,"IT");
        work.employee();

    }
    }



