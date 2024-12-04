package array.counting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The class is responsible for testing the `calculateSteps` method
 * in the `MinNumberOfStepsToMakeTwoStringsAnagram` class.
 * <p>
 * The `calculateSteps` method calculates the minimum number of steps required
 * to make two strings anagram by changing characters in one string
 * to match the other string character by character.
 */

public class MinNumberOfStepsToMakeTwoStringsAnagramTest {

    /**
     * Test when both strings are identical, should return 0
     */

    @Test
    public void testIdenticalStrings() {

        MinNumberOfStepsToMakeTwoStringsAnagram minSteps =
                new MinNumberOfStepsToMakeTwoStringsAnagram();

        String s = "abc";
        String t = "abc";

        int result = minSteps.calculateSteps(s, t);

        assertEquals(0, result);
    }

    /**
     * Test when strings are different with some characters matching, should return 1
     */

    @Test
    public void testSomeMatchingCharacters() {

        MinNumberOfStepsToMakeTwoStringsAnagram minSteps =
                new MinNumberOfStepsToMakeTwoStringsAnagram();

        String s = "abc";
        String t = "abd";

        int result = minSteps.calculateSteps(s, t);

        assertEquals(1, result);
    }

    /**
     * Test when none of the characters match, should return the length of any of the strings
     */

    @Test
    public void testNoMatchingCharacters() {

        MinNumberOfStepsToMakeTwoStringsAnagram minSteps =
                new MinNumberOfStepsToMakeTwoStringsAnagram();

        String s = "abc";
        String t = "def";

        int result = minSteps.calculateSteps(s, t);

        assertEquals(s.length(), result);
    }
}