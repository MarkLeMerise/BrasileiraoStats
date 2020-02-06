public class BrasileiraoMatch
{
    private String time;
    private String dayOfWeek;
    private String date;
    private String team1;
    private String team2;
    private String winner;
    private String round;
    private String arena;
    private int team1Score;
    private int team2Score;
    private String team1State;
    private String team2State;
    private String winnerTeamState;
    
    public BrasileiraoMatch(
        String time, String dayOfWeek, String date, String team1, String team2, String winner,String round, 
        String arena, int team1Score, int team2Score, String team1State, String team2State, String winnerTeamState
    ) {
        this.time = time;
        this.dayOfWeek = dayOfWeek;
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.winner = winner;
        this.round = round;
        this.arena = arena;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.team1State = team1State;
        this.team2State = team2State;
        this.winnerTeamState = winnerTeamState;
    }

    public String getTime() {
        return time;
    }
    
    public String getDayOfWeek() {
        return dayOfWeek;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getTeam1() {
        return team1;
    }
    
    public String getTeam2() {
        return team2;
    }
    
    public String getWinner() {
        return winner;
    }
    
    public String getRound() {
        return round;
    }
    
    public String getArena() {
        return arena;
    }
    
    public int getTeam1Score() {
        return team1Score;
    }
    
    public int getTeam2Score() {
        return team2Score;
    }
    
    public String getTeam1State() {
        return team1State;
    }
    
    public String getTeam2State() {
        return team2State;
    }
    
    public String getWinnerTeamState() {
        return winnerTeamState;
    }

}
