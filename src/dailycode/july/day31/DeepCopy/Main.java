package dailycode.july.day31.deepcopy;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address a=new Address("Delhi");

        Student s1=new Student("Rahul",a);

        Student s2=(Student)s1.clone();

        s2.address.city="Mumbai";

        System.out.println(s1.address.city);
        System.out.println(s2.address.city);
        System.out.println(s1);
        System.out.println(s2);
    }
}
