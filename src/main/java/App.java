public class App {

    public static void main(String[] args){

        int balance = 10;
        int betSize = 1;
        int targetBalance = 16;

        MartingalePlayer player = new MartingalePlayer(balance, betSize, targetBalance);

        try {
              player.playRoulette();
        } catch (NoMoreMoneyException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
