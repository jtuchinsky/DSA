package array.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A test class for the SeparateBlackAndWhiteBalls class.
 * This class tests the "minimumSteps" operation of the SeparateBlackAndWhiteBalls class.
 */
public class SeparateBlackAndWhiteBallsTest {

    @Test
    public void testMinimumSteps_AllZero() {
        SeparateBlackAndWhiteBalls balls = new SeparateBlackAndWhiteBalls();
        long result = balls.minimumSteps("00000");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testMinimumSteps_NoZero() {
        SeparateBlackAndWhiteBalls balls = new SeparateBlackAndWhiteBalls();
        long result = balls.minimumSteps("111111");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testMinimumSteps_RandomPattern1() {
        SeparateBlackAndWhiteBalls balls = new SeparateBlackAndWhiteBalls();
        long result = balls.minimumSteps("0101010");
        Assertions.assertEquals(9, result);
    }

    @Test
    public void testMinimumSteps_RandomPattern2() {
        SeparateBlackAndWhiteBalls balls = new SeparateBlackAndWhiteBalls();
        long result = balls.minimumSteps("11110000");
        Assertions.assertEquals(6, result);
    }

    @Test
    public void testMinimumSteps_EmptyString() {
        SeparateBlackAndWhiteBalls balls = new SeparateBlackAndWhiteBalls();
        long result = balls.minimumSteps("");
        Assertions.assertEquals(0, result);
    }
}