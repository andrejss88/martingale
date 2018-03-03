import Roulettes.BetColor;
import Roulettes.Roulette;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MartingalePlayerTest {

    Roulette veryPredictableRoulette  = new Roulette() {
        @Override
        public int spin() {
            return BetColor.RED.getColor();
        }
    };

    @Test
    public void playerLosesGameWhenBetSizeGreaterThanBalance(){
        MartingalePlayer player = new MartingalePlayer(4,5, 100);
        player.setRoulette(veryPredictableRoulette);

        assertFalse(player.playRoulette());
    }


    @Test
    public void playerWinsWhenTargetBalanceReached(){
        int balance = 6;
        int betSize = 2;
        int targetBalance = 6;
        MartingalePlayer player = new MartingalePlayer(balance,betSize, targetBalance);
        player.setRoulette(veryPredictableRoulette);

        assertTrue(player.playRoulette());
    }


}
