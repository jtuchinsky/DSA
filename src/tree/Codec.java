package tree;

import java.util.Arrays;

public class Codec {

    // Encodes a tree to a single string.    
    public String serialize(BinaryTreeNode root) {
        return preorder(root);
    }


    private String preorder(BinaryTreeNode node/*, StringBuilder answer*/){
        if(node == null) {
            return "null,";
        }

        return node.val + "," + preorder(node.left) + preorder(node.right);
    }

    // Decodes your encoded data to tree.
    public BinaryTreeNode deserialize(String data) {
        //System.out.println(data);

        if(data == null || data.length() == 0) return null;
        String[] nodes = data.split(",");

        return deserialize(nodes, new int[]{0});
    }


    private BinaryTreeNode deserialize(String[] nodes, int[] curr){
        String node = nodes[curr[0]];
        //System.out.println(node + ", " + Arrays.toString(curr));
        if(node.equals("null")) return null;
        BinaryTreeNode ret = new BinaryTreeNode(Integer.parseInt(node));
        curr[0]++;
        ret.left = deserialize(nodes, curr);
        curr[0]++;
        ret.right = deserialize(nodes, curr);

        return ret;
    }
}
