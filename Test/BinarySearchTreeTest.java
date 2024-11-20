package TreePackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the BinarySearchTree class, ensuring the correct implementation of its methods.
 */
class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;

    /**
     * Sets up a new BinarySearchTree instance before each test.
     */
    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    /**
     * Tests the contains method to ensure it correctly identifies whether an element exists in the BST.
     */
    @Test
    void contains() {
        bst.add(10);
        bst.add(20);
        bst.add(5);

        assertTrue(bst.contains(10), "contains() should return true for existing elements.");
        assertTrue(bst.contains(20), "contains() should return true for existing elements.");
        assertTrue(bst.contains(5), "contains() should return true for existing elements.");
        assertFalse(bst.contains(15), "contains() should return false for non-existent elements.");
    }

    /**
     * Tests the getEntry method to ensure it retrieves the correct element or null if not present.
     */
    @Test
    void getEntry() {
        bst.add(30);
        bst.add(15);
        bst.add(50);

        assertEquals(30, bst.getEntry(30), "getEntry() should return the correct element.");
        assertEquals(15, bst.getEntry(15), "getEntry() should return the correct element.");
        assertNull(bst.getEntry(25), "getEntry() should return null for non-existent elements.");
    }

    /**
     * Tests the add method to ensure elements are added correctly to the BST.
     */
    @Test
    void add() {
        bst.add(40);
        bst.add(20);
        bst.add(60);

        assertTrue(bst.contains(40), "add() should add elements to the BST.");
        assertTrue(bst.contains(20), "add() should add elements to the BST.");
        assertTrue(bst.contains(60), "add() should add elements to the BST.");
    }

    /**
     * Tests the initializeRoot method to ensure the root node is set correctly.
     */
    @Test
    void initializeRoot() {
        BinaryNode<Integer> rootNode = new BinaryNode<>(100);
        bst.initializeRoot(rootNode);

        assertEquals(100, bst.getRootData(), "initializeRoot() should set the root node correctly.");
    }

    /**
     * Tests the breadthFirstTraversal method to ensure nodes are printed in level order.
     */
    @Test
    void breadthFirstTraversal() {
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);
        bst.add(60);
        bst.add(80);

        // Redirect the console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        bst.breadthFirstTraversal();

        // Restore original System.out
        System.setOut(originalOut);

        String expectedOutput = "50 30 70 20 40 60 80";
        assertEquals(expectedOutput, outContent.toString().trim(), "breadthFirstTraversal() should print nodes in level order.");
    }
}
