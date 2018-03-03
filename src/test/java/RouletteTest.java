import Roulettes.Roulette;
import Roulettes.SimpleRoulette;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static java.time.Instant.now;
import static java.util.stream.Collectors.toSet;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RouletteTest {

    @Test(description = "After 100 spins, list should contain only 1 or 0")
    public void rouletteSpinProducesOnlyOneOrZero(){

        // Use a set because it should discard a lot of inserted duplicates (1s and 0s) -> faster execution
        Set<Integer> resultList = new HashSet<>();
        Roulette r = new SimpleRoulette();
        Instant start = now();

        // spin 100 times and populate the Set
        for(int i = 0; i < 1000; i++){
            resultList.add(r.spin());
        }

        // the list should be populated with 2 diff values only
        assertEquals(resultList.size(), 2);

        // get rid of 1s and 0s and check the list is zero
        Set<Integer> filteredList = resultList.stream()
                .filter(i -> i !=0)
                .filter(i -> i !=1)
                .collect(toSet());

        assertTrue(filteredList.isEmpty());

        System.out.println(Duration.between(start, now()));
    }
}
