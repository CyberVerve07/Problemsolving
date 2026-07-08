package July7;

public class Code2 {
    public static void main(String[] args) {
        StringBuilder qurey=new StringBuilder("Select * from employees WHERE 1=1");
         boolean filterByDepartment=true;

           if (filterByDepartment){
               qurey.append("And Department is IT::");
           }
           boolean filterBySalary=true;
            if (filterBySalary){
                qurey.append("AND salary> 50000");
            }
        System.out.println(qurey.toString());
    }
}
