import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {

    public Examples() {
    }

    /*
    // This shows what a test case looks like
    @Test
    public void simpleCheck() {
	assertEquals(4, 4);
    }
    */

    @Test
    public void testInitializeRugbyTeam() {
        RugbyTeam testTeam = new RugbyTeam("Ireland", "Green", true, 0, 0);
        assertEquals("Ireland", testTeam.country);
    }

    @Test
    public void testInitializeRoboticsTeam() {
        RoboticsTeam testTeam = new RoboticsTeam("WPI", "Breaks a lot", 0);
        assertEquals("WPI", testTeam.school);
    }

    @Test
    public void testInitializeRugbyResult() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 1.5, 1.5);
        assertEquals("Ireland", testRugbyResult.team1.country);
    }

    @Test
    public void testInitializeRoboticsResult() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 0);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 3, false);
        assertEquals("WPI", testRoboticsResult.team1.school);
    }

    @Test
    public void testRugbyTeamExpectToBeatOneInitmidationRitual() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 0, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", false, 0, 0);
        assertEquals(true, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRugbyTeamExpectToBeatBothIntimidationRitual() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        assertEquals(true, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRoboticsTeamExpectToBeatPreviousScoresEqual() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 0);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        assertEquals(false, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRoboticsTeamExpectToBeatPreviousScoresNotEqual() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        assertEquals(true, testTeam1.expectToBeat(testTeam2));
    }

    @Test
    public void testRugbyResultIsValidTrue() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 1.5, 1.5);
        assertEquals(true, testRugbyResult.isValid());

    }

    @Test
    public void testRugbyResultIsValidFalse() {
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 200, 1.5);
        assertEquals(false, testRugbyResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidTrue() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 3, false);
        assertEquals(true, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultIsValidFalse() {
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 20, 3, false,
                10, 3, false);
        assertEquals(false, testRoboticsResult.isValid());
    }

    @Test
    public void testRoboticsResultGetScoreNoFall(){
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 3, false);
        assertEquals(4.0, testRoboticsResult.getScore(1, 3, false), 0.01);
    }

    @Test
    public void testRoboticsResultGetScoreYesFall(){
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 3, false);
        assertEquals(-1.0, testRoboticsResult.getScore(1, 3, true), 0.01);
    }

    @Test
    public void testRugbyResultGetWinnerTeam1(){
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 100, 0);
        assertEquals(testTeam1, testRugbyResult.getWinner());
    }

    @Test
    public void testRugbyResultGetWinnerTeam2(){
        RugbyTeam testTeam1 = new RugbyTeam("Ireland", "Green", true, 1, 0);
        RugbyTeam testTeam2 = new RugbyTeam("Finland", "Blue", true, 0, 0);
        RugbyResult testRugbyResult = new RugbyResult(testTeam1, testTeam2, 0, 100);
        assertEquals(testTeam2, testRugbyResult.getWinner());
    }

    @Test
    public void testRoboticsResultGetWinnerTeam1(){
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 12, 3, false,
                10, 3, true);
        assertEquals(testTeam1, testRoboticsResult.getWinner());
    }

    @Test
    public void testRoboticsResultGetWinnerTeam2(){
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, true,
                10, 3, false);
        assertEquals(testTeam2, testRoboticsResult.getWinner());
    }

    @Test
    public void testMatchWinnerTeam1(){
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, false,
                10, 3, true);
        Match testMatch = new Match(testTeam1, testTeam2, testRoboticsResult);
        assertEquals(testTeam1, testMatch.winner());
    }

    @Test
    public void testMatchWinnerTeam2(){
        RoboticsTeam testTeam1 = new RoboticsTeam("WPI", "Breaks a lot", 1);
        RoboticsTeam testTeam2 = new RoboticsTeam("RPI", "Loses a lot", 0);
        RoboticsResult testRoboticsResult = new RoboticsResult(testTeam1, testTeam2, 10, 3, true,
                10, 3, false);
        Match testMatch = new Match(testTeam1, testTeam2, testRoboticsResult);
        assertEquals(testTeam2, testMatch.winner());
    }
}
