
package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PopulatingNextRightPointerTest {
    PopulatingNextRightPointer populatingNextRightPointer = new PopulatingNextRightPointer();

    @Test
    void connect_EmptyTree() {
        PopulatingNextRightPointer.Node root = null;
        assertNull(populatingNextRightPointer.connect(root));
    }

    @Test
    void connect_TwoNodeTree() {
        PopulatingNextRightPointer.Node root = populatingNextRightPointer.new Node(1);
        root.left = populatingNextRightPointer.new Node(2);
        root = populatingNextRightPointer.connect(root);
        assertNotNull(root);
        assertNotNull(root.left);
        assertNull(root.next);
        assertNull(root.left.next);
    }

    @Test
    void connect_TreeWithMultipleLevels() {
        PopulatingNextRightPointer.Node root = populatingNextRightPointer.new Node(1);
        root.left = populatingNextRightPointer.new Node(2);
        root.right = populatingNextRightPointer.new Node(3);
        root.left.left = populatingNextRightPointer.new Node(4);
        root.right.right = populatingNextRightPointer.new Node(5);
        root = populatingNextRightPointer.connect(root);
        assertNotNull(root);
        assertNotNull(root.left);
        assertNotNull(root.right);
        assertNotNull(root.left.left);
        assertNotNull(root.right.right);
        assertNull(root.next);
        assertEquals(root.left.next, root.right);
        assertNull(root.left.left.next);
        assertNull(root.right.right.next);
    }
}