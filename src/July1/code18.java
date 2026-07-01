package July1;

public class code18 {
    public static void main(String[] args) {
        //Perform the following operations:
        //
        //Print Name in uppercase.
        //Print Course in lowercase.
        //Print the length of College.
        //Concatenate all three Strings.
        //Print the final result.
        String name="Aditya";
        String course="BCA";
        String college="DAV";
        System.out.println(name.toUpperCase());
        System.out.println((course.toLowerCase()));
        System.out.println(college.length());


          String fullName=name.concat( " Gupta");
        System.out.println(fullName);
        String DegreeName=course.concat(" In Computer Science");
        System.out.println(DegreeName);
        String universty=college.concat((" Himachal Pradesh University"));
        System.out.println(universty);



    }
}
