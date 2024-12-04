package tree;


public class UniValueSubtree {


    private int count = 0;

    public int countUnivalSubtrees(BinaryTreeNode root) {
        isUnival(root);
        return count;
    }

    private boolean isUnival(BinaryTreeNode node) {
        if (node == null) {
            return true;
        }

        // Check if left and right subtrees are unival
        boolean left = isUnival(node.left);
        boolean right = isUnival(node.right);

        // If one of the subtrees is not unival, this subtree is also not unival
        if (!left || !right) {
            return false;
        }

        // If left subtree is not null, check if its value is equal to the current node's value
        if (node.left != null && node.left.val != node.val) {
            return false;
        }

        // If right subtree is not null, check if its value is equal to the current node's value
        if (node.right != null && node.right.val != node.val) {
            return false;
        }

        // If this point is reached, it is a unival subtree
        count++;
        return true;
    }
}