package misc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateParenthesisTest {

    /**
     * This class tests the GenerateParenthesis class
     */
    @Test
    public void testGenerateParenthesis1() {
        // Create object and initialize it
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();

        // Call method generateParenthesis
        List<String> result = generateParenthesis.generateParenthesis(3);

        // Verify the result
        assertEquals(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"), result);
    }

    @Test
    public void testGenerateParenthesis2() {
        // Create object and initialize it
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();

        // Call method generateParenthesis
        List<String> result = generateParenthesis.generateParenthesis(1);

        // Verify the result
        assertEquals(Arrays.asList("()"), result);
    }

    @Test
    public void testGenerateParenthesis3() {
        // Create object and initialize it
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();

        // Call method generateParenthesis
        List<String> result = generateParenthesis.generateParenthesis(2);

        // Verify the result
        assertEquals(Arrays.asList("(())", "()()"), result);
    }
}