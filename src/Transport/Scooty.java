package Transport;

public class Scooty extends  Vehicle {
    public String color;
    public  String price;
    // Const
    Scooty(String name,int number,int model,String company,String color,String price){

        //Use Super keyword
        super(name,number,model,company,color,price);
        this.color=color;
        this.price=price;

    }
    void showDetails(){
        System.out.println(" Details are  "+name);
    }
}
