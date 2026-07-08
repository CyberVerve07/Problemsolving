package dailycode.july07;
public class Main {

    public static void main(String[] args) {

        EmployeeSearch service = new EmployeeSearch();

        SearchInput input = new SearchInput(); // Default constructor

        input.empId = 101;
        input.salary = 50000.0;
        input.department = "IT";

        service.search(input);
    }
}