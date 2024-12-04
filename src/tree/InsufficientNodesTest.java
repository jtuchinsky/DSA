package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import tree.InsufficientNodes;

class InsufficientNodesTest {

    private final InsufficientNodes insufficientNodes = new InsufficientNodes();

    @Test
    void testSufficientSubsetAllNodesSufficient() {
        InsufficientNodes.TreeNode root = insufficientNodes.new TreeNode(5,
                insufficientNodes.new TreeNode(4),
                insufficientNodes.new TreeNode(6));

        assertEquals(5, insufficientNodes.sufficientSubset(root, 4).val);
        assertEquals(4, insufficientNodes.sufficientSubset(root, 4).left.val);
        assertEquals(6, insufficientNodes.sufficientSubset(root, 4).right.val);
    }

    @Test
    void testSufficientSubsetSomeNodesInsufficient() {
        InsufficientNodes.TreeNode root = insufficientNodes.new TreeNode(5,
                insufficientNodes.new TreeNode(4),
                insufficientNodes.new TreeNode(6, insufficientNodes.new TreeNode(2), null));

        assertNull(insufficientNodes.sufficientSubset(root, 7).right.left);
    }

    @Test
    void testSufficientSubsetAllNodesInsufficient() {
        InsufficientNodes.TreeNode root = insufficientNodes.new TreeNode(1,
                insufficientNodes.new TreeNode(2),
                insufficientNodes.new TreeNode(3));

        assertNull(insufficientNodes.sufficientSubset(root, 5));
    }

    @Test
    void testSufficientSubsetNullRoot() {
        assertNull(insufficientNodes.sufficientSubset(null, 0));
    }
}