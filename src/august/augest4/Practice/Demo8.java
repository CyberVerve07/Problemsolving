package august.augest4.Practice;

public class Demo8 implements  Cloneable {

     private  String name;
     private  String address;
     private  double salary;
     private  String city;


     //Generate Constructor


    public Demo8(String name, String address, double salary, String city) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.city = city;
    }


      //Generate Getters and setters :


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
