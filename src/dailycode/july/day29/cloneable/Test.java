package dailycode.july.day29.cloneable;

public class Test {

    public static void main(String[] args) throws Exception {

        Employee e1 = new Employee("Rahul", 50000);

        Employee e2 = e1.clone();

        System.out.println(e1.name);
        System.out.println(e2.name);

        System.out.println(e1 == e2);  //Same Data
      //  Different Object


    }
}