package Transport;

public class Scooty extends  Vehicle {
    public String color;
    public  String price;
    // Const
    Scooty(String name,int number,int model,String company,String color,String price){

        //Use Super keyword
        super(name,number,model,company);
        this.color=color;
        this.price=price;

    }
    void showDetails(){
        System.out.println(" Details are: ");
        System.out.println("Name: " + name);
        System.out.println("Number: " + number);
        System.out.println("Model: " + model);
        System.out.println("Company: " + company);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
    }
}
