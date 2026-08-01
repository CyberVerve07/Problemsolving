package dailycode.july.day31.DeepCopy;

class Student implements Cloneable{

    String name;

    Address address;

    Student(String name,Address address){
        this.name=name;
        this.address=address;
    }

    public Object clone() throws CloneNotSupportedException{

        Student cloned=(Student)super.clone();

        cloned.address=new Address(this.address.city);

        return cloned;

    }

}
