package dailycode.july16.SbiBank;

public class Main {
    public static void main(String[] args) {

         Process process=new Process();
          Account u1= new SavingAccount("Raja","830393039454",2000);
           Account u2=new CurrentAccount("Rahul","70000034",80000);
            Account u3=new Fd("Preach","98303840384",150000);
            Account u4=new SeniorCitizenAccount("Ram kayak","48930942083",60000);
           process.credit(u1);
           process.credit(u2);
           process.credit(u3);
           process.credit(u4);
    }
}
