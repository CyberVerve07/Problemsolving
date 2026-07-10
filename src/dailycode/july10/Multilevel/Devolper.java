package dailycode.july10;

public class Devolper extends Employee {

    String project;

    Devolper(String name, int id, String employeeBranch) {
        super(name, id, employeeBranch);
    }

    void  writeCode(){

           System.out.println("Devolper is write code :"+this.name);

       }

}
