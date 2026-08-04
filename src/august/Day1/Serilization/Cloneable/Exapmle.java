//package august.Day1.Serilization.Cloneable;
//
//class Address {
//    String city;
//
//    Address(String city) {
//        this.city = city;
//    }
//}
//
//class Employe implements Cloneable {
//
//    String name;
//    Address address;
//
//    Employe(String name, Address address) {
//        this.name = name;
//        this.address = address;
//    }
//
//    @Override
//    public Employee clone() throws CloneNotSupportedException {
//        return (Employee) super.clone();
//    }
//
//    public static void main(String[] args) throws CloneNotSupportedException {
//        Address a = new Address("Delhi");
//
//        Employee e1 = new Employee("Rahul",34,40000);
//
//        Employee e2 = (Employee) e1.clone();
//    }
//
//
//}
//
