import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StatsManager {

    private List<Boolean> gameList = new ArrayList<>();

    public void collectData(boolean gameResult){
        gameList.add(gameResult);
    }

    public void printResults(){
        List<Boolean> wonGames = gameList.stream()
                .filter(g -> g)
                .collect(toList());

        List<Boolean> lostGames = gameList.stream()
                .filter(g -> !g)
                .collect(toList());

        int wonGamesTotal = wonGames.size();
        int lostGamesTotal = lostGames.size();
        int allGamesTotal = gameList.size();
        double winRatio = (double) wonGamesTotal / allGamesTotal * 100;

        System.out.println("Games won: " + wonGamesTotal);
        System.out.println("Games lost: " + lostGamesTotal);
        System.out.println("Winning chance: " + winRatio);
    }

}
