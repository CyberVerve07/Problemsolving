package dailycode.july21.Crickbuzz.CrickInfo;

//Develop a Console Based Cricket Information System similar to Cricbuzz/Cricinfo.
//
//The application should allow users to:
//
//View live score
//View match summary
//View player statistics
//Display team information
//Generate scorecard

public  abstract  class Match {

    //Declare the fields for the Abstract Class:
    private int matchId;
    private String team1;
    private String team2;
    private String stadium;
    private double overs;


    //Generates the Constructor for initialization the values:
    public Match(int matchId, String team1, String team2, String stadium, double overs) {
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
        this.stadium = stadium;
        this.overs = overs;
    }



    public static void  companyInfo()  {
        System.out.println("Conduct by ICC :");

    }         // static

    //Declare the Setters and Getters :

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public double getOvers() {
        return overs;
    }

    public void setOvers(double overs) {
        this.overs = overs;
    }
      //Declare the Methods for Performing some Tasks:

    public final void displayMatchInfo() {
        System.out.println("===== MATCH INFO =====");
        System.out.println("Match ID  : " + getMatchId());
        System.out.println("Teams     : " + getTeam1() + " vs " + getTeam2());
        System.out.println("Stadium   : " + getStadium());
        System.out.println("Overs     : " + getOvers());
        System.out.println("=====================");
    }

    public abstract void startMatch();

    public abstract void updateScore(int newRuns, int newWickets, double newOvers);
}



