package dailycode.july01;

public class Code21 {
    //Problem Statement
    //
    //Create the following Strings.
    //
    //Employee Name
    //
    //Department
    //
    //Company
    //
    //Print:
    //
    //Employee Name in uppercase.
    //Department length.
    //Company lowercase.
    //Full information using concat().
    public static void Main(String[] args) {
        String employeeName="Aditya";
        String departmentNAme="IT";
        String company="Kodewala";
        System.out.println(employeeName.toUpperCase());
        System.out.println(departmentNAme.length());
        System.out.println(company.toLowerCase());
        String fullName=employeeName.concat(" Gupta");
        String deptName=departmentNAme.concat(" park");
        String compName=company.concat(" Accedmy");
        System.out.println(fullName);
        System.out.println(deptName);
        System.out.println(compName);

    }
}
