package assignments.assignment04;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameTest {

    @Test
    public void testWinner(){

        assertEquals(true, Game.checkWinner("melltorp", "utespelare"));
        assertEquals(true, Game.checkWinner("melltorp", "olserod"));
        assertEquals(true, Game.checkWinner("utespelare", "knarrevik"));
        assertEquals(true, Game.checkWinner("knarrevik", "melltorp"));
        assertEquals(true, Game.checkWinner("olserod", "yngvar"));
        assertEquals(true, Game.checkWinner("yngvar", "melltorp"));
        assertEquals(false, Game.checkWinner("melltorp", "melltorp"));
        assertEquals(false, Game.checkWinner("utespleare", "melltorp"));
        assertEquals(false, Game.checkWinner("olserod", "melltorp"));
        assertEquals(false, Game.checkWinner("knarrevik", "utespelare"));
        assertEquals(false, Game.checkWinner("yngvar", "olserod"));
        assertEquals(false, Game.checkWinner("yngvar", "olserod"));

    }
}
