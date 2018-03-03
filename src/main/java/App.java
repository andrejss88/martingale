public class App {

    public static void main(String[] args){

        int balance = 10;
        int betSize = 2;
        int targetBalance = 16;

        MartingalePlayer player = new MartingalePlayer(balance, betSize, targetBalance);

        int numOfGames = 2;
//        for(int i = 0; i <= numOfGames; i++){
            boolean gameWon = player.playRoulette();
            System.out.println(gameWon);
//        }

    }
}
