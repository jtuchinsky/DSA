package array.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for GridUniquePaths.
 * GridUniquePaths is a class that finds the number of unique paths from top-left corner to bottom-right
 * corner of a grid. The only movements allowed are either down or to the right.
 */
public class GridUniquePathsTest {

    /**
     * Test case for uniquePaths method.
     * Checking for standard use case with m = 3, n = 2. The expected result is 3.
     */
    @Test
    public void testUniquePaths_basic() {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
        int uniquePaths = gridUniquePaths.uniquePaths(3, 2);
        assertEquals(3, uniquePaths);
    }

    /**
     * Test case for uniquePaths method.
     * Checking edge cases where we have only one row or one column. We should have only one unique path in such cases.
     */
    @Test
    public void testUniquePaths_edgeCase_OneRowAndOneColumn() {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
        int uniquePathsRow = gridUniquePaths.uniquePaths(1, 7);
        assertEquals(1, uniquePathsRow);
        int uniquePathsColumn = gridUniquePaths.uniquePaths(7, 1);
        assertEquals(1, uniquePathsColumn);
    }

    /**
     * Test case for uniquePaths method.
     * Check for larger m, n values to ensure that the implementation can handle larger cases. In this case m = 7 and n = 7
     */
    @Test
    public void testUniquePaths_largerValues() {
        GridUniquePaths gridUniquePaths = new GridUniquePaths();
        int uniquePaths = gridUniquePaths.uniquePaths(7, 7);
        assertEquals(924, uniquePaths);
    }
}