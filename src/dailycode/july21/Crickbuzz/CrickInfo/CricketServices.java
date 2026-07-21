package dailycode.july21.Crickbuzz.CrickInfo;

public class CricketServices {

    // Display Live Score
    public void displayLiveScore(LiveScore liveScore) {

        liveScore.showLiveScore();

    }

    // Update Live Score
    public void updateLiveScore(LiveScore liveScore,
                                int runs,
                                int wickets,
                                double overs) {

        liveScore.updateScore(runs, wickets, overs);

        System.out.println();
        liveScore.showLiveScore();

    }

    // Display Score Card
    public void displayScoreCard(ScoreCard scoreCard) {

        scoreCard.generateScoreCard();
        scoreCard.showBattingCard();
        scoreCard.showBowlingCard();

    }

    // Display Player Statistics
    public void displayPlayerStats(PlayerStats playerStats) {

        playerStats.showTopScorer();
        playerStats.showTopBowler();
        playerStats.showStrikeRate();

    }

}