package dailycode.july9.employeeManagement;

public class Test {
    public static void main(String[] args) {
        Developer developer = new Developer(340);
        developer.setName("Aditya");
        developer.setSalary(50000);
        developer.setProgrammingLanguage("Java Spring Boot");

        developer.writeCode();
        developer.displayDetails();

        System.out.println("\nTesting negative salary check:");
        developer.setSalary(-1000); // Should print error message and keep previous salary
        System.out.println("Current Salary: " + developer.getSalary());
    }
}
