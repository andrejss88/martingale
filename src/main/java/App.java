public class App {

    private static int balance = 50;
    private static int betSize = 1;
    private static double targetBalance = 100;

    public static void main(String[] args){

        MartingalePlayer player = new MartingalePlayer(balance, betSize, targetBalance);
        StatsManager manager = new StatsManager();

        int numOfGames = 10_000;
        for(int i = 1; i <= numOfGames; i++){
            boolean gameWon = player.playRoulette();
            manager.collectData(gameWon);
            player.resetBalanceAndBetSize(balance, betSize);
        }

        manager.printResults();
    }
}
