package dailycode.july29.cloneable;

public class Student implements Cloneable {

    String name;
    String rollno;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    }

