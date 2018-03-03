public class MartingalePlayer {

    Roulette roulette = new Roulette();

    private int balance;
    private int targetBalance;
    private int betSize;
    private int betOnBlack = BetColor.BLACK.getColor(); // default strategy

    private int resetBetSize;


    public MartingalePlayer(int balance, int betSize, int targetBalance){
        this.balance = balance;
        this.betSize = betSize;
        this.targetBalance = targetBalance;

        resetBetSize = betSize;
    }

    public void playRoulette(){
        System.out.println("Starting with balance: " + getBalance());
        while (!checkIfTargetReached()){
            int spinResult = roulette.spin();
            updateData(spinResult);
        }
    }

    public int getBalance() {
        return balance;
    }

    public void updateData(int spinResult){
        boolean won = spinResult == betOnBlack;

        if(won){

            balance += betSize;     // increase balance
            betSize = resetBetSize; // reset to init
            System.out.println("WON! New Balance:  " + balance + ". Bet size for next round: " + betSize);

            checkIfTargetReached();

        } else {
            balance -= betSize;
            betSize = betSize * 2;
            System.out.println("LOST! New Balance:  " + balance + ". Increasing bet size for next round: " + betSize);

            checkIfNotBust();
        }
    }

    public boolean checkIfTargetReached() {
        return balance >= targetBalance;
    }

    private void checkIfNotBust() {
        if(balance < betSize){
            System.out.println("==========================");
            throw new NoMoreMoneyException("No more money! Remaining balance: " + balance + " but need " + betSize + " to continue");
        }
    }
}
