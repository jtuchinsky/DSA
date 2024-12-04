package tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {
    private BinaryTree tree;
    private BinaryTreeNode root;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree();
        root = new BinaryTreeNode(1);
        BinaryTreeNode leftChild = new BinaryTreeNode(2);
        BinaryTreeNode rightChild = new BinaryTreeNode(3);
        root.left = leftChild;
        root.right = rightChild;
    }

    @org.junit.jupiter.api.Test
    void testPreorderWithNonNullRoot() {
        List<Integer> expectedPreorderTraversal = Arrays.asList(1, 2, 3);
        assertEquals(expectedPreorderTraversal, tree.preorder(root));
    }

    @org.junit.jupiter.api.Test
    void testPreorderWithNullRoot() {
        List<Integer> expectedPreorderTraversal = new ArrayList<>();
        assertEquals(expectedPreorderTraversal, tree.preorder(null));
    }

    @org.junit.jupiter.api.Test
    void testInorderWithNonNullRoot() {
        List<Integer> expectedInorderTraversal = Arrays.asList(2, 1, 3);
        assertEquals(expectedInorderTraversal, tree.inorder(root));
    }

    @org.junit.jupiter.api.Test
    void testInorderWithNullRoot() {
        List<Integer> expectedInorderTraversal = new ArrayList<>();
        assertEquals(expectedInorderTraversal, tree.inorder(null));
    }

    @org.junit.jupiter.api.Test
    void testPostorderWithNonNullRoot() {
        List<Integer> expectedPostorderTraversal = Arrays.asList(2, 3, 1);
        assertEquals(expectedPostorderTraversal, tree.postorder(root));
    }

    @org.junit.jupiter.api.Test
    void testPostorderWithNullRoot() {
        List<Integer> expectedPostorderTraversal = new ArrayList<>();
        assertEquals(expectedPostorderTraversal, tree.postorder(null));
    }

    @org.junit.jupiter.api.Test
    void testLevelOrderWithNonNullRoot() {
        List<List<Integer>> expectedLevelOrderTraversal = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2, 3)
        );
        assertEquals(expectedLevelOrderTraversal, tree.levelOrder(root));
    }

    @org.junit.jupiter.api.Test
    void testLevelOrderWithNullRoot() {
        List<List<Integer>> expectedLevelOrderTraversal = new ArrayList<>();
        assertEquals(expectedLevelOrderTraversal, tree.levelOrder(null));
    }

    @org.junit.jupiter.api.Test
    void testBuildTreeFromInorderAndPostorderWithNonNullArrays() {
        BinaryTree tree = new BinaryTree();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        BinaryTreeNode root = tree.buildTreeFromInorderAndPostorder(inorder, postorder);

        List<Integer> expectedInorderTraversal = Arrays.asList(9, 3, 15, 20, 7);
        List<Integer> expectedPostorderTraversal = Arrays.asList(9, 15, 7, 20, 3);

        assertEquals(expectedInorderTraversal, tree.inorder(root));
        assertEquals(expectedPostorderTraversal, tree.postorder(root));
    }

    @org.junit.jupiter.api.Test
    void testBuildTreeFromInorderAndPostorderWithNullArrays() {
        BinaryTree tree = new BinaryTree();
        int[] inorder = {};
        int[] postorder = {};
        BinaryTreeNode root = tree.buildTreeFromInorderAndPostorder(inorder, postorder);

        List<Integer> expectedInorderTraversal = new ArrayList<>();
        List<Integer> expectedPostorderTraversal = new ArrayList<>();

        assertEquals(expectedInorderTraversal, tree.inorder(root));
        assertEquals(expectedPostorderTraversal, tree.postorder(root));
    }

    @Test
    void testBuildTreeFromPreorderAndInorderWithNonNullArrays() {
        BinaryTree tree = new BinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BinaryTreeNode root = tree.buildTreeFromPreorderAndInorder(preorder, inorder);

        List<Integer> expectedPreorderTraversal = Arrays.asList(3, 9, 20, 15, 7);
        List<Integer> expectedInorderTraversal = Arrays.asList(9, 3, 15, 20, 7);

        assertEquals(expectedPreorderTraversal, tree.preorder(root));
        assertEquals(expectedInorderTraversal, tree.inorder(root));
    }

    @Test
    void testBuildTreeFromPreorderAndInorderWithNullArrays() {
        BinaryTree tree = new BinaryTree();
        int[] preorder = {};
        int[] inorder = {};
        BinaryTreeNode root = tree.buildTreeFromPreorderAndInorder(preorder, inorder);

        List<Integer> expectedPreorderTraversal = new ArrayList<>();
        List<Integer> expectedInorderTraversal = new ArrayList<>();

        assertEquals(expectedPreorderTraversal, tree.preorder(root));
        assertEquals(expectedInorderTraversal, tree.inorder(root));
    }

    @Test
    void testBuildTreeFromPreorderAndInorderWithSingleElement() {
        BinaryTree tree = new BinaryTree();
        int[] preorder = {1};
        int[] inorder = {1};
        BinaryTreeNode root = tree.buildTreeFromPreorderAndInorder(preorder, inorder);

        List<Integer> expectedPreorderTraversal = Arrays.asList(1);
        List<Integer> expectedInorderTraversal = Arrays.asList(1);

        assertEquals(expectedPreorderTraversal, tree.preorder(root));
        assertEquals(expectedInorderTraversal, tree.inorder(root));
    }
}

