package tree;

public class SumRootToLeafNumbers {
    int r = 0;
    public int sumNumbers(BinaryTreeNode root) {
        Integer cr = 0;
        //Integer r = 0;

        traverse(root, cr);

        //System.out.println(result);

        return r;
    }

    private void traverse(BinaryTreeNode node, Integer cr){
        cr = cr * 10 + node.val;
        //System.out.println(cr + "; " + r);

        if(isLeaf(node)) {
            r = r + cr;
            //System.out.println(cr + "; " + r);
            return;
        }

        if(node.left != null) traverse(node.left, cr);
        //cr = cr - node.val;
        if(node.right != null) traverse(node.right, cr);
        //cr = cr  - node.val;
    }

    private boolean isLeaf(BinaryTreeNode node){
        return node.left == null && node.right == null;
    }
}
