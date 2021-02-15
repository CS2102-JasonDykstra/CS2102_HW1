public class Match {
    IResult result;
    IContestant contestant1, contestant2;

    public Match (IContestant contestant1, IContestant contestant2, IResult result) {
        this.result = result;
        this.contestant1 = contestant1;
        this.contestant2 = contestant2;
    }

    public IContestant winner(){
        if(result.isValid())
            return result.getWinner();

        else return null;
    }
}
