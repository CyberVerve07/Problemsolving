package dailycode.july.day09.employeemanagement;

public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(int id) {
        super(id);
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public void writeCode() {
        System.out.println("Developer " + getName() + " is writing code in " + this.programmingLanguage + ".");
    }
}
