package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointer {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        //List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Node> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node node = q.poll();
                level.add(node);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            //result.add(level);
            for (int i = 0; i < level.size() - 1; i++) level.get(i).next = level.get(i + 1);
        }

        return root;
    }

}
