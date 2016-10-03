package fr.p10.miage.rps.tests;

import fr.p10.miage.rps.model.RPSEnum;
import fr.p10.miage.rps.model.Result;
import fr.p10.miage.rps.model.RockPaperScissors;
import org.testng.annotations.*;

import javax.rmi.CORBA.Tie;

import static org.testng.Assert.*;

/**
 * Created by wilpiron on 03/10/2016.
 */
public class RockPaperScissorsTest {

    RockPaperScissors rps;

    @BeforeMethod
    public void setUp() throws Exception {
        rps = new RockPaperScissors();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        rps = null;
    }

    @Test
    public void testPlay() throws Exception {

    }

    @DataProvider(name="WinData")
    public Object[][] createWinData(){
        return new Object[][]{
                {"PAPER","ROCK"},{"ROCK","SCISSORS"},{"SCISSORS","PAPER"}
        };
    }

    @DataProvider(name="TieData")
    public Object[][] createTieData(){
        return new Object[][]{
                {"PAPER","PAPER"},{"ROCK","ROCK"},{"SCISSORS","SCISSORS"}
        };
    }

    @DataProvider(name="LostData")
    public Object[][] createLostData(){
        return new Object[][]{
                {"ROCK","PAPER"},{"SCISSORS","ROCK"},{"PAPER","SCISSORS"}
        };
    }

    @Test(dataProvider="WinData")
    public void testWinPlay(String p1, String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1),RPSEnum.valueOf(p2)), Result.WIN);
    }

    @Test(dataProvider="TieData")
    public void testTiePlay(String p1, String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1),RPSEnum.valueOf(p2)), Result.TIE);
    }

    @Test(dataProvider="LostData")
    public void testLostPlay(String p1, String p2){
        assertEquals(rps.play(RPSEnum.valueOf(p1),RPSEnum.valueOf(p2)), Result.LOST);
    }
}