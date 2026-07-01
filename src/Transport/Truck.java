package Transport;

public class Truck extends Vehicle{
    public String Driver;
    public String Condition;
    //
    Truck(String name,int number,int model,String company,String Driver,String Condition){
        //Use super keyword
        super(name,number,model,company,Driver,Condition);
        this.Driver=Driver;
        this.Condition=Condition;

    }
    void startTruck(){
        System.out.printf("The Truck is start "+name,model);
    }



}
