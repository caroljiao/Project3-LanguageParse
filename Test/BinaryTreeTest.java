package TreePackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BinaryTree class to validate the correctness of its methods.
 */
class BinaryTreeTest {

    private BinaryTree<String> binaryTree;

    /**
     * Initializes a new BinaryTree instance before each test.
     */
    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree<>();
    }

    /**
     * Tests the getRootData method to ensure it retrieves the correct root data or null for an empty tree.
     */
    @Test
    void getRootData() {
        assertNull(binaryTree.getRootData(), "Root data should be null for an empty tree.");
        binaryTree.setRootNode(new BinaryNode<>("Root"));
        assertEquals("Root", binaryTree.getRootData(), "Root data should be 'Root' after setting the root node.");
    }

    /**
     * Tests the isEmpty method to ensure it correctly identifies whether the tree is empty.
     */
    @Test
    void isEmpty() {
        assertTrue(binaryTree.isEmpty(), "Tree should be empty initially.");
        binaryTree.setRootNode(new BinaryNode<>("Root"));
        assertFalse(binaryTree.isEmpty(), "Tree should not be empty after setting the root node.");
    }

    /**
     * Tests the clear method to ensure the tree is properly emptied.
     */
    @Test
    void clear() {
        binaryTree.setRootNode(new BinaryNode<>("Root"));
        assertFalse(binaryTree.isEmpty(), "Tree should not be empty before clearing.");
        binaryTree.clear();
        assertTrue(binaryTree.isEmpty(), "Tree should be empty after clearing.");
    }

    /**
     * Tests the setRootNode method to ensure the root node is set correctly.
     */
    @Test
    void setRootNode() {
        BinaryNode<String> rootNode = new BinaryNode<>("Root");
        binaryTree.setRootNode(rootNode);
        assertEquals("Root", binaryTree.getRootData(), "Root data should be 'Root' after setting the root node.");
    }

    /**
     * Tests the getRootNode method to ensure the correct root node is retrieved.
     */
    @Test
    void getRootNode() {
        assertNull(binaryTree.getRootNode(), "Root node should be null for an empty tree.");
        BinaryNode<String> rootNode = new BinaryNode<>("Root");
        binaryTree.setRootNode(rootNode);
        assertEquals(rootNode, binaryTree.getRootNode(), "Root node should match the one set.");
    }

    /**
     * Tests the getInorderIterator method to ensure it performs in-order traversal correctly.
     */
    @Test
    void getInorderIterator() {
        binaryTree.setRootNode(new BinaryNode<>("B"));
        binaryTree.getRootNode().setLeftChild(new BinaryNode<>("A"));
        binaryTree.getRootNode().setRightChild(new BinaryNode<>("C"));

        Iterator<String> iterator = binaryTree.getInorderIterator();
        assertTrue(iterator.hasNext(), "Iterator should have elements.");
        assertEquals("A", iterator.next(), "First element in in-order traversal should be 'A'.");
        assertEquals("B", iterator.next(), "Second element in in-order traversal should be 'B'.");
        assertEquals("C", iterator.next(), "Third element in in-order traversal should be 'C'.");
        assertFalse(iterator.hasNext(), "Iterator should have no more elements.");
    }

    /**
     * Tests the breadthFirstTraversal method to ensure nodes are traversed in level order.
     */
    @Test
    void breadthFirstTraversal() {
        binaryTree.setRootNode(new BinaryNode<>("Root"));
        binaryTree.getRootNode().setLeftChild(new BinaryNode<>("Left"));
        binaryTree.getRootNode().setRightChild(new BinaryNode<>("Right"));

        // Redirect console output to verify the output of breadth-first traversal
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        binaryTree.breadthFirstTraversal();
        System.setOut(originalOut);

        String expectedOutput = "Breadth-First Traversal:\nRoot Left Right \n";
        assertEquals(expectedOutput, outContent.toString().replaceAll("\r", ""), "Breadth-first traversal output should match.");
    }
}
