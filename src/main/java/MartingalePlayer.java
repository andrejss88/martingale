import Roulettes.BetColor;
import Roulettes.Roulette;
import Roulettes.SimpleRoulette;

/**
 * Martingale Player: always bets on Black
 */
public final class MartingalePlayer {

    Roulette roulette = new SimpleRoulette();

    private int balance;
    private double targetBalance;
    private double betSize;
    private int betOnBlack = BetColor.BLACK.getColor(); // default strategy

    private int resetBetSize;

    private boolean gameWon;


    public MartingalePlayer(int balance, int betSize, double targetBalance){
        this.balance = balance;
        this.betSize = betSize;
        this.targetBalance = targetBalance;

        resetBetSize = betSize;
    }

    /**
     * Set a Roulette that the player will play
     */

    public void setRoulette(Roulette roulette){
        this.roulette = roulette;
    }

    public boolean playRoulette(){
//        System.out.println("Starting with balance: " + getBalance());
        while (canContinuePlaying()){
            int spinResult = roulette.spin();
            updateBalanceAndBetSize(spinResult);
        }
        return gameWon;
    }

    public void resetBalanceAndBetSize(int balance, int betSize) {
        this.balance = balance;
        this.betSize = betSize;
    }

    private boolean canContinuePlaying() {

        if(balance >= targetBalance){
//            System.out.println("===========================");
//            System.out.println("Target balance reached: " + balance);
            gameWon = true;
            return false; // stop playing

        } else if(balance < betSize) {
//            System.out.println("===========================");
//            System.out.println("No more money! Remaining balance: " + balance + " but need " + betSize + " to continue");
            gameWon = false;
            return false;  // stop playing

        } else {
            return true;
        }
    }

    public int getBalance() {
        return balance;
    }

    private void updateBalanceAndBetSize(int spinResult){
        boolean wonRound = spinResult == betOnBlack;

        if(wonRound){

            balance += betSize;     // increase balance
            betSize = resetBetSize; // reset to init
//            System.out.println("WON! New Balance:  " + balance + ". Bet size for next round: " + betSize);

        } else {
            balance -= betSize;
            betSize = betSize * 2;
//            System.out.println("LOST! New Balance:  " + balance + ". Increasing bet size for next round: " + betSize);
        }
    }
}
