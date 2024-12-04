### DFS Traversal
```java
/* Basic node of the binary tree */
class TreeNode {
    int val;
    TreeNode left, right;
}

void traverse(TreeNode root) {
    // pre-order traversal
    traverse(root.left);
    // in-order traversal
    traverse(root.right);
    // post-order traversal
}
```

#### Top-down Traversal
**"Top-down"** means that in each recursive call, we will visit the node first to come up with some values, and pass these 
values to its children when calling the function recursively.  
So the **"top-down"** solution can be considered as a kind of **preorder** traversal. To be specific, the recursive function 
top_down(root, params) works like this:
```
function topDownTraversal(node, result) {
    if node is null then
        return

    result.add(node.value)
    topDownTraversal(node.left, result)
    topDownTraversal(node.right, result)
}

function startTraversal(root) {
    result = new List()
    topDownTraversal(root, result)
    return result
}

// Assuming we have a binary tree with a root node
root = getBinaryTreeRoot() 
result = startTraversal(root)

// result now contains the values in top-down (pre-order) traversal order
```

That's how we implement it in Java
```java
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BinaryTreeTraversal {
    
    public List<Integer> topDownTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        traverse(node, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        // return specific value for null node
        if (node == null) {
            return;
        }
        
        // Update result if needed
        result.add(node.value);
        traverse(node.left, result);
        traverse(node.right, result);
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeTraversal traversal = new BinaryTreeTraversal();
        List<Integer> result = traversal.topDownTraversal(root);

        // Output the result
        System.out.println(result); // Should print [1, 2, 4, 5, 3]
    }
}
```
### BFS Traversal


