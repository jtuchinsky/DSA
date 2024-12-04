package tree;

import java.util.*;

public class BinaryTree {
    public List<Integer> preorder(BinaryTreeNode root) {
        List<Integer> answer = new ArrayList<>();
        preorder(root, answer);
        return answer;
    }

    public List<Integer> inorder(BinaryTreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inorder(root, answer);
        return answer;
    }

    public List<Integer> postorder(BinaryTreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postorder(root, answer);
        return answer;
    }

    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            result.add(level);
        }

        return result;
    }

    public BinaryTreeNode buildTreeFromInorderAndPostorder(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;
        if (inorder.length == 1) return new BinaryTreeNode(inorder[0]);

        int rootVal = postorder[postorder.length - 1];
        int rootIdxInInorder = find(inorder, rootVal);
        BinaryTreeNode root = new BinaryTreeNode(rootVal);


        root.left = buildTreeFromInorderAndPostorder(
                Arrays.copyOfRange(inorder, 0, rootIdxInInorder),
                Arrays.copyOfRange(postorder, 0, rootIdxInInorder));
        root.right = buildTreeFromInorderAndPostorder(
                Arrays.copyOfRange(inorder, rootIdxInInorder + 1, inorder.length),
                Arrays.copyOfRange(postorder, rootIdxInInorder, postorder.length - 1));

        return root;
    }

    public BinaryTreeNode buildTreeFromPreorderAndInorder(int[] preorder, int[] inorder) {
        System.out.println("preorder = " + Arrays.toString(preorder) + ", inorder = " + Arrays.toString(inorder));
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new BinaryTreeNode(preorder[0]);

        int rootVal = preorder[0];
        int rootIdxInInorder = find(inorder, rootVal);
        BinaryTreeNode root = new BinaryTreeNode(rootVal);

        root.left = buildTreeFromPreorderAndInorder(
                Arrays.copyOfRange(preorder, 1, rootIdxInInorder+1),
                Arrays.copyOfRange(inorder, 0, rootIdxInInorder));
        root.right = buildTreeFromPreorderAndInorder(
                Arrays.copyOfRange(preorder, rootIdxInInorder + 1, preorder.length),
                Arrays.copyOfRange(inorder, rootIdxInInorder + 1, inorder.length));

        return root;
    }

    private int find(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
        }
        return -1;
    }

    private void preorder(BinaryTreeNode node, List<Integer> answer) {
        if (node == null) return;

        answer.add(node.val);
        preorder(node.left, answer);
        preorder(node.right, answer);
    }

    private void inorder(BinaryTreeNode node, List<Integer> answer) {
        if (node == null) return;

        inorder(node.left, answer);
        answer.add(node.val);
        inorder(node.right, answer);
    }


    private void postorder(BinaryTreeNode node, List<Integer> answer) {
        if (node == null) return;

        postorder(node.left, answer);
        postorder(node.right, answer);
        answer.add(node.val);
    }

}

