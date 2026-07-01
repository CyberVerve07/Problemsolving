package Transport;

import java.util.StringTokenizer;

public class Car  extends  Vehicle{
    private   int numberOfDoors;
    public String transMissiontype;

    Car(String name, int number, int model, String company, int numberOfDoors, String transMissiontype){

          // Use super keyword
          super(name,number,model,company);
          this.numberOfDoors=numberOfDoors;
          this.transMissiontype=transMissiontype;
      }
      void  startCar(){
          System.out.printf( "Car is Start  \n"+name);

          super.start();
          System.out.println("Model number is"+model);
          System.out.println("Company name is "+company);
          System.out.println("Number of doors "+numberOfDoors);
          System.out.println("Transmission type is "+transMissiontype);

      }
      //Using getters and setters


    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
