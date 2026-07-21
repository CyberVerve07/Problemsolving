package dailycode.july21.Crickbuzz.CrickInfo;

public class Main {
    public static void main(String[] args) {

         Match match=new IPLMatch(8393,"CSK,","RCB","Chepauk",20,
                 220,8,120,"Ruturaj",87,"Jemmi",6);

           match.displayMatchInfo();
           match.startMatch();
           match.updateScore(20,2,2);






    }
}
