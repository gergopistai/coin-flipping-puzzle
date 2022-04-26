package coins.state;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

    private Coins state1 = new Coins(7, 3); // the original initial state

    private Coins state2; // the goal state
    {
        BitSet bs = new BitSet(7);
        bs.set(0, 7);
        state2 = new Coins(7, 3, bs);
    }

    @Test
    public void getFlipsTest() {
        assertEquals(state1.getFlips(), Coins.generateFlips(state1.getN(), state1.getM()));
    }

    @Test
    public void generateFlipsTest() {
        for (int i = 1; i < 15; i++)
            for (int j = 1; j < i - 1; j++)
                assertEquals(CombinatoricsUtils.binomialCoefficient(i, j), Coins.generateFlips(i, j).size());
    }

    @Test
    public void isGoalTest() {
        assertTrue(state2.isGoal());
    }

}
