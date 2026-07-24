package dailycode.july24;

public class Driver{
     public static void main(String[] args) throws CloneNotSupportedException {
          Employee e1=new Employee("Aditya","Delhi");
          
           Employee e2=(Employee) e1.clone();   //Clone the object:: Marker interface
         System.out.println(e2.name +" "+e2.location);        
         
     }

       //Can we Create your Own marker Interface :::::::::; Yes it will empty : 
 }
