package Collections.Set;

 class Demo{
     String name="Puppy";
 }
public class Demo1 {
    //Set
    public static void main(String[] args) {
        //if two obj are returning the same hashcode the those may be equals or not  //Hash collision
        //if two obj are same its hashcode will be same
        String name="Aditya";
        String name2="Aditya";
        System.out.println("Hashcode of name "+name.hashCode());
        System.out.println("Hashcode of name2 "+name2.hashCode());
    Demo demo=new Demo();
    Demo demo2=new Demo();
        System.out.println(demo.equals(demo2));
        System.out.println(demo.hashCode());
        System.out.println(demo2.hashCode());


}}
