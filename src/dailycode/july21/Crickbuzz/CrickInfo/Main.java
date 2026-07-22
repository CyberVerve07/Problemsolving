package dailycode.july21.Crickbuzz.CrickInfo;

public class Main {
    public static void main(String[] args) {

        // IPLMatch type use karo taaki interface methods bhi call ho sake
        IPLMatch match = new IPLMatch(8393, "CSK", "RCB", "Chepauk", 20,
                220, 8, 120, "Ruturaj", 87, "Jemmi", 6);

        // Match class ke methods
        match.displayMatchInfo();
        match.startMatch();
        match.updateScore(20, 2, 2);

        // CricketServices ke through interface methods call karo
        CricketServices services = new CricketServices();

        services.displayLiveScore(match);     // LiveScore interface
        services.displayPlayerStats(match);   // PlayerStats interface
        services.displayScoreCard(match);     // ScoreCard interface

    }
}
