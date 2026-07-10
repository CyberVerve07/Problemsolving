package dailycode.july10;

public class Employee {

     public  String name;
     int id;
      String employeeBranch;

       Employee(String name,int id,String employeeBranch){
           this.name=name;
           this.id=id;
           this.employeeBranch=employeeBranch;

       }

          void  work(){
              System.out.println("Employee are on work:"+this.name);
          }


}
