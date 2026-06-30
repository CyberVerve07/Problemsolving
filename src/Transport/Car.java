package Transport;

import java.util.StringTokenizer;

public class Car  extends  Vehicle{
    public  int numberOfDoors;
    public String transMissiontype;
      Car(String name, int number, int model, String company, int numberOfDoors, String transMissiontype){

          // Use super keyword
          super(name,number,model,company);
          this.numberOfDoors=numberOfDoors;
          this.transMissiontype=transMissiontype;
      }
      void  startCar(){
          System.out.println("Car is Start ");

          super.start();

      }

}
