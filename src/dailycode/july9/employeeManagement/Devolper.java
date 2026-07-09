package dailycode.july9.employeeManagement;

public class Devolper extends  Employee {
    private   String programmingLanguage;

    Devolper(int id) {
        super(id);
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    void  writecode(){
           System.out.println( "Devolper is write code in  "+this.programmingLanguage);
        System.out.println(" Devolper name is "+this.getName());
       }
}
