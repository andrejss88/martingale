import org.testng.Assert;
import org.testng.annotations.Test;

public class MartingalePlayerTest {

    @Test(expectedExceptions = NoMoreMoneyException.class)
    public void playerExitsWhenBetSizeGreaterThanBalance(){
        MartingalePlayer player = new MartingalePlayer(4,2, 100);

        int losingResult = BetColor.RED.getColor();
        player.updateData(losingResult);
    }


    @Test(expectedExceptions = NoMoreMoneyException.class)
    public void playerExitsWhenBetSizeGrowsTooBig(){
        int balance = 6;
        int betSize = 2;
        MartingalePlayer player = new MartingalePlayer(balance,betSize, 100);

        int losingResult = BetColor.RED.getColor();
        player.updateData(losingResult); // lost, but can still play
        Assert.assertEquals(player.getBalance(), balance - betSize);

        player.updateData(losingResult);
    }

    @Test
    public void playerCanPlayOneMoreTimeWhenBalanceGreaterThanBetSize(){
        int balance = 6;
        int betSize = 2;
        MartingalePlayer player = new MartingalePlayer(balance,betSize, 100);

        int losingResult = BetColor.RED.getColor();
        player.updateData(losingResult);
        Assert.assertEquals(player.getBalance(), balance - betSize);
    }


}
