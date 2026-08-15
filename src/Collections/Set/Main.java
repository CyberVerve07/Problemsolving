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


        //Collection framework in java is a srt o classes and interfaces that  provide inbuild data structure and
        //easy to store,manipulate the data elements ::
        //List is a interface in java collection framework it is represent the order of collection
        //and also allow to duplicate elements
        //in list duplicate elements allowed because in list their is no machinist to compare the values

        //Arraylist is a resizable array that allow duplicate elements and order manner its default size is 10
        //Arraylist provide us index based access:


        // Arraylist internally working it is use an array internally the default size is 10 it increase size by 50%
        //old array +new array .1.5

         //Array list is better when we use the get and read operation or insert the element in the last element its
        //timeComplexity will be become 0(1).
        //list allows duplicates because the List contract permits duplicate elements.
        //list allow the duplicate elements because the list contract permits duplicate elements :
    //   The commonly taught default initial capacity is 10,
// but the no-argument constructor can defer allocation until the first element is added.





    }

}
