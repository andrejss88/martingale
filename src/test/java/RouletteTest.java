import Roulettes.Roulette;
import Roulettes.SimpleRoulette;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RouletteTest {

    @Test(description = "After 100 spins, list should contain only 1 or 0")
    public void rouletteSpinProducesOnlyOneOrZero(){

        List<Integer> resultList = new ArrayList<>();
        Roulette r = new SimpleRoulette();
        // spin 100 times and populate list
        for(int i = 0; i < 100; i++){
            resultList.add(r.spin());
        }

        // the list is indeed populated
        assertEquals(resultList.size(), 100);

        // get rid of 1s and 0s and check the list is zero
        List<Integer> filteredList = resultList.stream()
                .filter(i -> i !=0)
                .filter(i -> i !=1)
                .collect(toList());

        assertTrue(filteredList.isEmpty());
    }
}
