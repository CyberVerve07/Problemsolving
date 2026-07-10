package dailycode.july10;

public class Senior extends Devolper {   // Multiple

    Senior(String name, int id, String employeeBranch) {
        super(name, id, employeeBranch);
    }


    public void reviewCode() {

        System.out.println("Senior devolper is Review Code:" + this.name);
    }


    public void leadTeam() {

        System.out.println(this.name + " is leading the development team.");
    }
}
