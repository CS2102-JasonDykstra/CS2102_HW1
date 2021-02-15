public class RoboticsResult implements IResult {
    RoboticsTeam team1;
    RoboticsTeam team2;
    double team1points;
    double team2points;
    int team1tasks;
    int team2tasks;
    boolean team1fell;
    boolean team2fell;

    public RoboticsResult(RoboticsTeam team1, RoboticsTeam team2,
                   double team1points, int team1tasks, boolean team1fell,
                   double team2points, int team2tasks, boolean team2fell) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1points = team1points;
        this.team2points = team2points;
        this.team1tasks = team1tasks;
        this.team2tasks = team2tasks;
        this.team1fell = team1fell;
        this.team2fell = team2fell;
    }

    // -> boolean
    //true if BOTH teams have fewer than 8 attempted tasks AND no more than 16 points.
    public boolean isValid(){
        return (team1tasks < 8) && (team2tasks < 8) && (team1points <= 16) && (team2points <= 16);
    }

    // double int boolean -> double
    // Takes in the number of points, the number of tasks, and whether the robot fell down.
    // calculates a final score by summing the points and tasks and then applying a 5 point deduction if the robot fell down.
    public double getScore(double points, int tasks, boolean fell){
        double score = 0;

        score = (points + tasks + (fell ? -5 : 0));

        return score;
    }

    // RoboticsTeam -> String
    // return the team with more points
    public IContestant getWinner(){
        double team1Score = this.getScore(team1points, team1tasks, team1fell);
        double team2Score = this.getScore(team2points, team2tasks, team2fell);
        return (team1Score > team2Score) ? team1 : team2;
    }

}
