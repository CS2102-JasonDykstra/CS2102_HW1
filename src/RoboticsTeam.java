public class RoboticsTeam implements IContestant{
    String school;
    String feature;
    double previousScore;

    public RoboticsTeam(String school, String feature, double previousScore) {
        this.school = school;
        this.feature = feature;
        this.previousScore = previousScore;

    }

    // expectToBeat: RoboticsTeam RoboticsTeam -> boolean
    //takes another contestant as input and returns a boolean indicating whether the contestant would be expected to win against the given/input contestant.
    //The expected winner of a robotics competition is the one with a higher previous score.
    //If there is no clear expected winner, return false.

    public boolean expectToBeat(RoboticsTeam enemyTeam){
        return (this.previousScore > enemyTeam.previousScore);
    }
}
