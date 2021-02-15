public class RugbyTeam implements IContestant {
    String country;
    String jersy;
    boolean haka;
    int wins;
    int loses;

    public RugbyTeam(String country, String jersy, boolean haka, int wins, int loses) {
        this.country = country;
        this.jersy = jersy;
        this.haka = haka;
        this.wins = wins;
        this.loses = loses;

    }
    // expectToBeat: RugbyTeam RugbyTeam -> boolean
    //takes another contestant as input and returns a boolean indicating whether the contestant would be expected to win against the given/input contestant.
    //if only one team has an intimidation ritual, that team is the expected winner;
    //if neither or both teams have such rituals, the expected winner is the one with the bigger gap between number of wins and number of losses.

    public boolean expectToBeat(RugbyTeam enemyTeam) {
        if (this.haka == enemyTeam.haka) {
            return (this.wins - this.loses) > (enemyTeam.wins - enemyTeam.loses);
        }
        else
            return (this.haka);
    }
}
