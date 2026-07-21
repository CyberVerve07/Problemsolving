package dailycode.july21.Crickbuzz;

public class Details implements Score{
    @Override
    public void checkScore() {
        System.out.println("Check Score of live Match:");
        System.out.println("India 314-5 overs 50: Rohit Sharma 128,KL Rahul 176*  ");
        System.out.println();
        System.out.println("Australia need 231 from 230 balls are left :: T head on 59*, S smith 12*");
        System.out.println();

    }

    @Override
    public void showResult() {
        System.out.println("Australia win by 7 wickets :   ");
        System.out.println();

    }

    @Override
    public void browserTeam() {
        System.out.println("Currently Australia  is Dominating : ");

    }

    @Override
    public void iccRanking() {
        System.out.println("Joe Root is no1 in Test Ranking : ");
        System.out.println();

    }

    @Override
    public void schedule() {
        System.out.println("WordCup 2027 Starts from 1 July Ready India:: ");

    }

     //Main method
    public static void main(String[] args) {
        Details details =new Details();
         details.checkScore();
         details.showResult();
         details.browserTeam();
         details.iccRanking();
         details.schedule();
    }
}
