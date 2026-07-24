package dailycode.july24;

public class Employee implements Cloneable {


    //    //Marker interface  give ability to perform some task : also called Tag interface
    //    //Cloning,Serialization etc:
    //    //Interface is empty
    //Use to make the zeros copy :

    String name;
    String location;

    public Employee(String name, String location) {
        super();
        this.name = name;
        this.location = location;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
