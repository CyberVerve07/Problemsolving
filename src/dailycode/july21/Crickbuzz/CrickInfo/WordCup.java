package dailycode.july21.Crickbuzz.CrickInfo;

public class WordCup extends  Match implements  LiveScore,ScoreCard,PlayerStats{
    private int runs;
    private int wickets;
    private int ballsFaced;
    private String topScorer;

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public String getTopScorer() {
        return topScorer;
    }

    public void setTopScorer(String topScorer) {
        this.topScorer = topScorer;
    }

    public int getTopScorerRuns() {
        return topScorerRuns;
    }

    public void setTopScorerRuns(int topScorerRuns) {
        this.topScorerRuns = topScorerRuns;
    }

    public String getTopBowler() {
        return topBowler;
    }

    public void setTopBowler(String topBowler) {
        this.topBowler = topBowler;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }

    private int topScorerRuns;

    public WordCup(int matchId, String team1, String team2, String stadium, double overs, int runs, int wickets, int ballsFaced, String topScorer, int topScorerRuns, String topBowler, int wicketsTaken) {
        super(matchId, team1, team2, stadium, overs);
        this.runs = runs;
        this.wickets = wickets;
        this.ballsFaced = ballsFaced;
        this.topScorer = topScorer;
        this.topScorerRuns = topScorerRuns;
        this.topBowler = topBowler;
        this.wicketsTaken = wicketsTaken;
    }

    private String topBowler;
    private int wicketsTaken;

    public WordCup(int matchId, String team1, String team2, String stadium, double overs) {
        super(matchId, team1, team2, stadium, overs);
    }

    @Override
    public void showLiveScore() {
        System.out.println("==============================");
        System.out.println("Match Started");
        System.out.println("Venue : " + getStadium());
        System.out.println(getTeam1()+"vs"+getTeam2());
        System.out.println(getTeam1() + " won the toss and elected to bat first.");
        System.out.println("==============================");


    }

    @Override
    public void updateScore() {

    }

    @Override
    public void updateScore(int newRuns, int newWickets, int newOvers) {
        runs=newRuns+=newRuns;
        wickets=newWickets+=newWickets;
        setOvers(getOvers()+newOvers);
        System.out.println("Live Score Update Successfully");
    }

    @Override
    void startMatch() {


    }

    @Override
    public void updateScore(int newRuns, int newWickets, double newOvers) {

    }

    @Override
    public void showTopScorer() {
        System.out.println("Top Scorer");
        System.out.println(topScorer + " : " + topScorerRuns + " Runs");


    }

    @Override
    public void showTopBowler() {
        System.out.println("Top Bowler");
        System.out.println(topBowler + " : " + wicketsTaken + " Wickets");


    }

    @Override
    public void showStrikeRate() {
        double strikeRate = (topScorerRuns * 100.0) / ballsFaced;

        System.out.println("Strike Rate : " + strikeRate);

    }

    @Override
    public void generateScoreCard() {
        System.out.println("========== SCORE CARD ==========");
        System.out.println(getTeam1() + " vs " + getTeam2());
        System.out.println("Final Score : " + runs + "/" + wickets);
        System.out.println("Overs : " + getOvers());
        System.out.println("================================");


    }

    @Override
    public void showBattingCard() {
        System.out.println("========== BATTING CARD ==========");
        System.out.println(topScorer + " - " + topScorerRuns + " Runs");


    }

    @Override
    public void showBowlingCard() {
        System.out.println("========== BOWLING CARD ==========");
        System.out.println(topBowler + " - " + wicketsTaken + " Wickets");


    }
}
