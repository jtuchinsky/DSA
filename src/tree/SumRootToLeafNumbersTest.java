package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumRootToLeafNumbersTest {

    /**
     * A class that provides functionality to calculate the sum of numbers
     * formed by root-to-leaf paths in a binary tree. The numbers are formed
     * by concatenating the values of the nodes along the path.
     */
    private SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();

    @Test
    void testSumNumbers_singleNodeTree() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        assertEquals(5, sumRootToLeafNumbers.sumNumbers(root));
    }

    @Test
    void testSumNumbers_simpleTree() {
        BinaryTreeNode root = new BinaryTreeNode(1, new BinaryTreeNode(2), new BinaryTreeNode(3));
        assertEquals(25, sumRootToLeafNumbers.sumNumbers(root));
    }

    @Test
    void testSumNumbers_treeWithMultiplePaths() {
        BinaryTreeNode root = new BinaryTreeNode(4,
                new BinaryTreeNode(9, new BinaryTreeNode(5), new BinaryTreeNode(1)),
                new BinaryTreeNode(0));
        assertEquals(1026, sumRootToLeafNumbers.sumNumbers(root));
    }

    @Test
    void testSumNumbers_treeWithOnlyLeftChildren() {
        BinaryTreeNode root = new BinaryTreeNode(2,
                new BinaryTreeNode(3,
                        new BinaryTreeNode(4, null, null), null), null);
        assertEquals(234, sumRootToLeafNumbers.sumNumbers(root));
    }

    @Test
    void testSumNumbers_treeWithOnlyRightChildren() {
        BinaryTreeNode root = new BinaryTreeNode(7, null,
                new BinaryTreeNode(8, null,
                        new BinaryTreeNode(9, null, null)));
        assertEquals(789, sumRootToLeafNumbers.sumNumbers(root));
    }
}