package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RotateArrayTest {
    // Description: This class contains test methods that test the rotate method of the RotateArray class.

    @Test
    public void testRotateArrayWithNoRotation() {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5};
        rotateArray.rotate(nums, 0);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums);
    }

    @Test
    public void testRotateArrayWithOneRotation() {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5};
        rotateArray.rotate(nums, 1);
        assertArrayEquals(new int[]{2, 3, 4, 5, 1}, nums);
    }

    @Test
    public void testRotateArrayWithMoreThanOneRotation() {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(nums, 3);
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
    }

    @Test
    public void testRotateArrayWithManyRotations() {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5};
        rotateArray.rotate(nums, 10);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums);
    }

    @Test
    public void testRotateArrayWithNegativeRotation() {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5};
        rotateArray.rotate(nums, -1);
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, nums);
    }
}