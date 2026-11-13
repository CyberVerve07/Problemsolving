package Collection.list;

public class Eemployee4 {
    private String employeeName;
    private String employeeDepartment;
            private double salary;
    //Create a Constructor of it
     public Eemployee4(String employeeName, String employeeDepartment, double salary) {
         this.employeeName = employeeName;
         this.employeeDepartment = employeeDepartment;
         this.salary = salary;
     }

     //Create the getters methods
        public String getEmployeeName() {
        return employeeName;
        }
        public String getEmployeeDepartment(){
         return employeeDepartment;
    }

        public double getSalary() {
        return salary;
        }


        //Create an to string method to print the object in a readable format

    @Override
    public String toString() {
        return "Eemployee4{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", salary=" + salary +
                '}';
    }
}
