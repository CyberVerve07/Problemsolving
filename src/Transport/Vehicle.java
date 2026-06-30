package Transport;

public class Vehicle {
    public String name;
    public int number;
    public int model;
    public String company;
     //Default Constructor
    Vehicle(){ //default constructor

    }

    //
    Vehicle(String name, int number, int model, String company){ //Constructor Parameterized for car
    //This reference current instance
       this.name=name;
       this.model=model;
       this.number=number;
       this.company=company;

    }

    public Vehicle(String name, int number, int model, String company, int price, String handel) {
       //for Bike
        this.name=name;
        this.model=model;
        this.number=number;
        this.company=company;
    }
    public Vehicle(String name,int number,int model,String company,String Driver,String Condition){
        this.name=name;
        this.model=model;
        this.number=number;
        this.company=company;
    }

    void  start(){
           System.out.println("Vehicle is Start"+name);
       }

         void stop(){
             System.out.println("Vehicle is Stop"+name);
         }




}
