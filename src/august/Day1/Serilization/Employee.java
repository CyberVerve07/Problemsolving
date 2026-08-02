package august.Day1.Serilization;

import java.io.Serializable;

public class Employee implements Serializable {

    private  String name;
     private  int id;
     private  String adress;
     private  double sallary;


       //Generate the Constructor ::


    public Employee(String name, int id, String adress, double sallary) {
        this.name = name;
        this.id = id;
        this.adress = adress;
        this.sallary = sallary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getSallary() {
        return sallary;
    }

    public void setSallary(double sallary) {
        this.sallary = sallary;
    }
}
