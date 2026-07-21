package dailycode.july21.Crickbuzz.CrickInfo;

// Note: Class name should ideally be WorldCup — typo kept to avoid renaming file
public class WordCup extends Match implements LiveScore, ScoreCard, PlayerStats {

    // Fields declared at the top (Bug #12 fixed)
    private int runs;
    private int wickets;
    private int ballsFaced;
    private String topScorer;
    private int topScorerRuns;
    private String topBowler;
    private int wicketsTaken;

    // Getters and Setters
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

    // Full constructor
    public WordCup(int matchId, String team1, String team2, String stadium, double overs,
                   int runs, int wickets, int ballsFaced, String topScorer,
                   int topScorerRuns, String topBowler, int wicketsTaken) {
        super(matchId, team1, team2, stadium, overs);
        this.runs = runs;
        this.wickets = wickets;
        this.ballsFaced = ballsFaced;
        this.topScorer = topScorer;
        this.topScorerRuns = topScorerRuns;
        this.topBowler = topBowler;
        this.wicketsTaken = wicketsTaken;
    }

    // Minimal constructor
    public WordCup(int matchId, String team1, String team2, String stadium, double overs) {
        super(matchId, team1, team2, stadium, overs);
    }

    @Override
    public void startMatch() {
        // Bug #13 fixed: implemented startMatch with output
        System.out.println("==============================");
        System.out.println("World Cup Match Started");
        System.out.println("Venue : " + getStadium());
        System.out.println(getTeam1() + " vs " + getTeam2());
        System.out.println(getTeam1() + " won the toss and elected to bat first.");
        System.out.println("==============================");
    }

    @Override
    public void showLiveScore() {
        // Bug #10 fixed: now shows actual live score, not match-start info
        System.out.println("========== LIVE SCORE ==========");
        System.out.println(getTeam1() + " : " + runs + "/" + wickets);
        System.out.println("Overs : " + getOvers());
        double runRate = (getOvers() > 0) ? runs / getOvers() : 0;
        System.out.println("Run Rate : " + runRate);
        System.out.println("================================");
    }

    @Override
    public void updateScore() {
        // empty — reserved for no-arg interface contract
    }

    @Override
    public void updateScore(int newRuns, int newWickets, double newOvers) {
        // Bug #11 fixed: implemented this overload (was empty before)
        runs += newRuns;
        wickets += newWickets;
        setOvers(getOvers() + newOvers);
        System.out.println("Live Score Updated Successfully");
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
