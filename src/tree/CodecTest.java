package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodecTest {

    @Test
    public void testSerialize() {
        Codec codec = new Codec();
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(15);
        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(18);

        String serialized = codec.serialize(root);
        String expected = "10,5,3,null,null,7,null,null,15,null,18,null,null,";
        assertTrue(serialized.equals(expected), "Serialized string does match the expected output.");

    }

    @Test
    public void testDeserialize() {
        Codec codec = new Codec();
        String serializedTree = "10,5,3,null,null,7,null,null,15,null,18,null,null,";
        BinaryTreeNode root = codec.deserialize(serializedTree);

        String verificationString = codec.serialize(root);
        assertTrue(serializedTree.equals(verificationString), "Deserialized tree string does match the input string.");
    }

    @Test
    public void testEmptyTreeSerialize() {
        Codec codec = new Codec();
        BinaryTreeNode root = null;
        String serialized = codec.serialize(root);
        String expected = "null,";
        assertTrue(serialized.equals(expected), "Serialized string for an empty tree does not match the expected output.");
    }

    @Test
    public void testEmptyTreeDeserialize() {
        Codec codec = new Codec();
        String serializedTree = "null,";
        BinaryTreeNode root = codec.deserialize(serializedTree);

        String verificationString = codec.serialize(root);
        assertTrue(serializedTree.equals(verificationString), "Deserialized tree string for an empty tree does not match the input string.");
    }

}