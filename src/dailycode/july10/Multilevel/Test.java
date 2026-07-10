package dailycode.july10;

public class Test {
    public static void main(String[] args) {
      //  Devolper sc=new Devolper("Aditya",789,"Devolper");

        //sc.work();
        //sc.writeCode();
        System.out.println("\n--- Testing Multiple Inheritance with Senior ---");
        Senior senior = new Senior("Amit", 101, "Engineering");
        senior.work();        // inherited from Employee
        senior.writeCode();   // inherited from Devolper
        senior.reviewCode();  // implemented from CodeReviewer
        senior.leadTeam();    // implemented from TeamLeader
    }
}
