package Oops;

public class Vehicel {
    public  String name;
    public  int modelNo;
    public  String rc;
    public  int year;
       //
    Vehicel(){

    }
    Vehicel(String name,int modelNo,String rc,int year){
        this.name=name;
        this.modelNo=modelNo;
        this.rc=rc;
        this.year=year;

    }
    void start(){
        System.out.println("Car is start"+name);

    }
}
