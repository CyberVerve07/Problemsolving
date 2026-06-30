package Transport;

public class Bike extends  Vehicle{
    public int price;
    public String handel;
      // Create consructor :
    Bike(String name,int number,int model,String company,int price,String handel){


        //USe super keyword
        super(name,number,model,company,price,handel);
        this.price=price;
        this.handel=handel;
        super.start();


    }
    public  void stopBike(){
        System.out.printf("Bike is Stop \n "+name,model);

    }
    public  void  openTank(){
        System.out.printf("Open fuel tank \n"+name,model);
    }
}
