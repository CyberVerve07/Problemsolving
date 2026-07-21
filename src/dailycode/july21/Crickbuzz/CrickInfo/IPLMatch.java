package dailycode.july21.Crickbuzz.CrickInfo;

public class IPLMatch extends Match implements LiveScore, PlayerStats, ScoreCard {

    private int runs;
    private int wickets;
    private int ballsFaced;
    private String topScorer;
    private int topScorerRuns;
    private String topBowler;
    private int wicketsTaken;

    public IPLMatch(int matchId,
                    String team1,
                    String team2,
                    String stadium,
                    double overs,
                    int runs,
                    int wickets,
                    int ballsFaced,
                    String topScorer,
                    int topScorerRuns,
                    String topBowler,
                    int wicketsTaken) {

        super(matchId, team1, team2, stadium, overs);

        this.runs = runs;
        this.wickets = wickets;
        this.ballsFaced = ballsFaced;
        this.topScorer = topScorer;
        this.topScorerRuns = topScorerRuns;
        this.topBowler = topBowler;
        this.wicketsTaken = wicketsTaken;
    }

    @Override
    public void startMatch() {

        System.out.println("==============================");
        System.out.println("Match Started");
        System.out.println("Venue : " + getStadium());
        System.out.println(getTeam1() + " vs " + getTeam2());
        System.out.println(getTeam1() + " won the toss and elected to bat first.");
        System.out.println("==============================");

    }

    @Override
    public void showLiveScore() {

        System.out.println("========== LIVE SCORE ==========");
        System.out.println(getTeam1() + " : " + runs + "/" + wickets);
        System.out.println("Overs : " + getOvers());

        double runRate = runs / getOvers();

        System.out.println("Run Rate : " + runRate);
        System.out.println("================================");

    }

    @Override
    public void updateScore() {

    }

    @Override
    public void updateScore(int newRuns, int newWickets, double newOvers) {

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