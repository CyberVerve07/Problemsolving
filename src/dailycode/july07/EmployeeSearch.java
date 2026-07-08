package dailycode.july07;
public class EmployeeSearch {

    public void search(SearchInput input) {

        if (input.empId == null &&
                input.salary == null &&
                input.department == null) {

            System.out.println("Showing all employees...");
            return;
        }

        if (input.empId != null) {
            System.out.println("Searching by Employee ID: " + input.empId);
        }

        if (input.salary != null) {
            System.out.println("Searching Salary > " + input.salary);
        }

        if (input.department != null) {
            System.out.println("Searching Department: " + input.department);
        }
    }
}
