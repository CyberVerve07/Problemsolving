package Collections.Set;

public class Main {
    public static void main(String[] args) {

        Demo4 e1 = new Demo4("Aditya", 62);
        System.out.println(e1.name);
        System.out.println(e1.rollNo);

        Demo4 e2=new Demo4("Aditya",62);
        System.out.println(e2.name);
        System.out.println(e2.rollNo);


        System.out.println("Does obj1 and obj2 are equals ");
        System.out.println(e1.equals(e2));

        String name=new String("Aditya");
        String name2=new String("Aditya");
        System.out.println(name.equals(name2));
        System.out.println(name==name2);


    }

}
