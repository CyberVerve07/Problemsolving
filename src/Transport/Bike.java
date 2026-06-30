package Transport;

public class Bike extends  Vehicle{
    public int price;
    public String handel;
      // Create consructor :
    Bike(String name,int number,int model,String company,int price,String handel){


        //USe super keywors
        super(name,number,model,company,price,handel);
        this.price=price;
        this.handel=handel;
        super.start();


    }
    public  void stopBike(){
        System.out.println("Bike is Stop "+name);
    }
}
