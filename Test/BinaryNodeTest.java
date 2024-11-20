package TreePackage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BinaryNode class, verifying the behavior of its methods.
 */
class BinaryNodeTest {

    /**
     * Tests the getData method to ensure it returns the correct value.
     */
    @Test
    void getData() {
        BinaryNode<String> node = new BinaryNode<>("Test");
        assertEquals("Test", node.getData(), "getData() should return the correct value.");
    }

    /**
     * Tests the setData method to ensure it correctly updates the node's data.
     */
    @Test
    void setData() {
        BinaryNode<String> node = new BinaryNode<>("Initial");
        node.setData("Updated");
        assertEquals("Updated", node.getData(), "setData() should update the node's data.");
    }

    /**
     * Tests the getLeftChild method to ensure it returns the correct left child.
     */
    @Test
    void getLeftChild() {
        BinaryNode<String> leftChild = new BinaryNode<>("LeftChild");
        BinaryNode<String> parent = new BinaryNode<>("Parent", leftChild, null);
        assertEquals(leftChild, parent.getLeftChild(), "getLeftChild() should return the correct left child.");
    }

    /**
     * Tests the setLeftChild method to ensure it correctly sets the left child.
     */
    @Test
    void setLeftChild() {
        BinaryNode<String> parent = new BinaryNode<>("Parent");
        BinaryNode<String> leftChild = new BinaryNode<>("LeftChild");
        parent.setLeftChild(leftChild);
        assertEquals(leftChild, parent.getLeftChild(), "setLeftChild() should correctly set the left child.");
    }

    /**
     * Tests the getRightChild method to ensure it returns the correct right child.
     */
    @Test
    void getRightChild() {
        BinaryNode<String> rightChild = new BinaryNode<>("RightChild");
        BinaryNode<String> parent = new BinaryNode<>("Parent", null, rightChild);
        assertEquals(rightChild, parent.getRightChild(), "getRightChild() should return the correct right child.");
    }

    /**
     * Tests the setRightChild method to ensure it correctly sets the right child.
     */
    @Test
    void setRightChild() {
        BinaryNode<String> parent = new BinaryNode<>("Parent");
        BinaryNode<String> rightChild = new BinaryNode<>("RightChild");
        parent.setRightChild(rightChild);
        assertEquals(rightChild, parent.getRightChild(), "setRightChild() should correctly set the right child.");
    }

    /**
     * Tests the hasLeftChild method to ensure it correctly identifies the presence of a left child.
     */
    @Test
    void hasLeftChild() {
        BinaryNode<String> parent = new BinaryNode<>("Parent");
        assertFalse(parent.hasLeftChild(), "hasLeftChild() should return false when no left child is present.");
        parent.setLeftChild(new BinaryNode<>("LeftChild"));
        assertTrue(parent.hasLeftChild(), "hasLeftChild() should return true when a left child is present.");
    }

    /**
     * Tests the hasRightChild method to ensure it correctly identifies the presence of a right child.
     */
    @Test
    void hasRightChild() {
        BinaryNode<String> parent = new BinaryNode<>("Parent");
        assertFalse(parent.hasRightChild(), "hasRightChild() should return false when no right child is present.");
        parent.setRightChild(new BinaryNode<>("RightChild"));
        assertTrue(parent.hasRightChild(), "hasRightChild() should return true when a right child is present.");
    }

    /**
     * Tests the isLeaf method to ensure it correctly identifies leaf nodes.
     */
    @Test
    void isLeaf() {
        BinaryNode<String> node = new BinaryNode<>("LeafNode");
        assertTrue(node.isLeaf(), "isLeaf() should return true for a leaf node.");
        node.setLeftChild(new BinaryNode<>("LeftChild"));
        assertFalse(node.isLeaf(), "isLeaf() should return false for a non-leaf node.");
    }

    /**
     * Tests the toString method to ensure it correctly returns the string representation of the node's data.
     */
    @Test
    void testToString() {
        BinaryNode<String> node = new BinaryNode<>("ToStringTest");
        assertEquals("ToStringTest", node.toString(), "toString() should return the correct string representation of the node's data.");
    }
}
