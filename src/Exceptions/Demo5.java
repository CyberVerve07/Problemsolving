package Exceptions;

public class Demo5 {
    //SqlException is a checked exception which occurs when there is an error in database access or other database-related issues.
    public static void main(String[] args) {
        try {
            // Simulating a database operation that throws SQLException
            throw new java.sql.SQLException("Database access error");
        } catch (java.sql.SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
