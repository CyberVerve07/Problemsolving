package oops.inheritance;

public class Vehicle {
    public  String name;
    public  int modelNo;
    public  String rc;
    public  int year;
       //
    Vehicle(){

    }
    Vehicle(String name,int modelNo,String rc,int year){
        this.name=name;
        this.modelNo=modelNo;
        this.rc=rc;
        this.year=year;

    }
    void start(){
        System.out.println("Car is start"+name);

    }
}
