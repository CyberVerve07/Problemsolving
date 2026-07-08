package July7;


public class QueryConstructor {

    public static String QUERY = "select * from employee";    //Static method

    public String constructQuery(String empId, int salary) {  //Method and Condition::

        StringBuilder finalQuery = new StringBuilder(QUERY);

        if(empId != null) {
            finalQuery.append(" where empId =" + empId);
        }
        else if(salary > 0) {
            finalQuery.append(" where salary > " + salary);
        }

        finalQuery.append(";");

        return finalQuery.toString();
    }
}



