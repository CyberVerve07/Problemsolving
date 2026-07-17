package dailycode.july17.Code1.TCS;

public class Main {
    public static void main(String[] args) {

          Process process=new Process();

             Employee e1=new SoftwareEngineer("Aditya", 7,80000);
             Employee e2=new HR("Prachi",90,50000);
             Employee e3=new Manager("Rahul",91,40000);

                process.tcs(e1);
                process.tcs(e2);
                process.tcs(e3);
    }
}
