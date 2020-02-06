import java.util.*;
import java.lang.*;
import core.data.*;

public class Test
{    
    private static BrasileiraoMatch[] loadMatches() {
        DataSource ds = DataSource.connect("brasileirao-matches.csv").load();
        return ds.fetchArray("BrasileiraoMatch",
            "time", "dayOfWeek", "date", "team1", "team2", "winner", "round", "arena",
             "team1Score", "team2Score", "team1State", "team2State", "winnerTeamState");
    }
    
    public static void largestVictory() {
        BrasileiraoMatch[] matches = loadMatches();
        BrasileiraoMatch biggestDifferentialMatch = matches[0];
        int biggestDifferential = Math.abs(matches[0].getTeam1Score() - matches[0].getTeam2Score());
        
        for(BrasileiraoMatch match : matches) {
            int goalDifferential = Math.abs(match.getTeam1Score() - match.getTeam2Score());
            
            if (goalDifferential > biggestDifferential) {
                biggestDifferential = goalDifferential;
                biggestDifferentialMatch = match;
            }
        }
        
        int winnerScore = biggestDifferentialMatch.getTeam1Score() > biggestDifferentialMatch.getTeam2Score()
            ? biggestDifferentialMatch.getTeam1Score()
            : biggestDifferentialMatch.getTeam2Score(); 
        int loserScore = biggestDifferentialMatch.getTeam1Score() < biggestDifferentialMatch.getTeam2Score()
            ? biggestDifferentialMatch.getTeam1Score()
            : biggestDifferentialMatch.getTeam2Score(); 
        
        System.out.println("The largest margin of victory was by " + biggestDifferentialMatch.getWinner() 
            + ". They won " + winnerScore + "-" + loserScore + " on " + biggestDifferentialMatch.getDate());
    }
    
    public static void stateWithMostVictories() {
        BrasileiraoMatch[] matches = loadMatches();
        HashMap<String, Integer> stateWinCount = new HashMap<>();
        
        for(BrasileiraoMatch match : matches) {
            if (match.getWinnerTeamState().equals("Empate")) {
                continue;
            }
            
            if (!stateWinCount.containsKey(match.getWinnerTeamState())) {
                stateWinCount.put(match.getWinnerTeamState(), 1);
            } else {
                stateWinCount.replace(match.getWinnerTeamState(), stateWinCount.get(match.getWinnerTeamState()) + 1);
            }
        }
        
        Map.Entry<String, Integer> max = null;
        
        for(Map.Entry<String, Integer> entry : stateWinCount.entrySet()) {
            if (max == null) {
                max = entry;
            } else if (entry.getValue() > max.getValue()) {
                max = entry;
            }
        }
        
        System.out.println("The state with the most victories is " + max.getKey() + " with " + max.getValue() + " victories.");
    }
}
