public class RugbyResult implements IResult {
    RugbyTeam team1;
    RugbyTeam team2;
    double team1points;
    double team2points;


    public RugbyResult(RugbyTeam team1, RugbyTeam team2, double team1points, double team2points) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1points = team1points;
        this.team2points = team2points;
    }

    // -> boolean
    //true if BOTH teams are under 150 points.
    public boolean isValid(){
        return (team1points < 150) && (team2points < 150);
    }

    // RugbyResult -> Contestant
    // return the team with more points

    public IContestant getWinner(){
        return (team1points > team2points) ? team1 : team2;
    }

}
