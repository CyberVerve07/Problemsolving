package august.augest3.ATMMachine;

public class Main {
    public static void main(String[] args) {
        //Create an obj

          Atm atm=new Atm("Prachi","8048490",70000);


          atm.showAccountDetails();
          atm.deposit(800);
          atm.withdraw(50000);


    }
}
