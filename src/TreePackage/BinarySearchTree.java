package TreePackage;

import java.util.Queue;
import java.util.LinkedList;

/**
 * A generic Binary Search Tree implementation that extends the BinaryTree class
 * and implements the SearchTreeInterface. The tree supports common operations
 * such as adding entries, checking for containment, and retrieving entries.
 *
 * @param <T> The type of elements stored in the tree. Must implement Comparable.
 */
public class BinarySearchTree<T extends Comparable<? super T>> extends BinaryTree<T> implements SearchTreeInterface<T> {

    /**
     * Constructs an empty Binary Search Tree.
     */
    public BinarySearchTree() {
        super();
    }

    /**
     * Checks if the tree contains a specific entry.
     *
     * @param entry The entry to search for.
     * @return {@code true} if the entry exists in the tree, {@code false} otherwise.
     */
    public boolean contains(T entry) {
        return getEntry(entry) != null;
    }

    /**
     * Retrieves a specific entry from the tree.
     *
     * @param entry The entry to retrieve.
     * @return The entry if found, or {@code null} if not found.
     */
    public T getEntry(T entry) {
        return findEntry(getRootNode(), entry);
    }

    /**
     * A helper method to recursively find an entry in the tree.
     *
     * @param rootNode The root node of the subtree to search.
     * @param entry    The entry to find.
     * @return The entry if found, or {@code null} if not found.
     */
    private T findEntry(BinaryNode<T> rootNode, T entry) {
        if (rootNode == null) {
            return null;
        }
        int comparison = entry.compareTo(rootNode.getData());
        if (comparison == 0) {
            return rootNode.getData();
        } else if (comparison < 0) {
            return findEntry(rootNode.getLeftChild(), entry);
        } else {
            return findEntry(rootNode.getRightChild(), entry);
        }
    }

    /**
     * Adds a new entry to the tree while maintaining the binary search tree properties.
     *
     * @param entry The entry to add.
     */
    public void add(T entry) {
        setRootNode(addEntry(getRootNode(), entry));
    }

    /**
     * A helper method to recursively add a new entry to the tree.
     *
     * @param rootNode The root node of the subtree.
     * @param entry    The entry to add.
     * @return The updated root node of the subtree.
     */
    private BinaryNode<T> addEntry(BinaryNode<T> rootNode, T entry) {
        if (rootNode == null) {
            return new BinaryNode<>(entry);
        }
        int comparison = entry.compareTo(rootNode.getData());
        if (comparison < 0) {
            rootNode.setLeftChild(addEntry(rootNode.getLeftChild(), entry));
        } else if (comparison > 0) {
            rootNode.setRightChild(addEntry(rootNode.getRightChild(), entry));
        }
        return rootNode;
    }

    /**
     * Initializes the root node of the binary search tree.
     * Provides controlled access to the protected `setRootNode` method from `BinaryTree`.
     *
     * @param rootNode The root node to set.
     */
    public void initializeRoot(BinaryNode<T> rootNode) {
        setRootNode(rootNode); // Calls the protected method from BinaryTree
    }

    /**
     * Performs a breadth-first traversal (level-order traversal) of the tree
     * and prints the elements in level order.
     */
    public void breadthFirstTraversal() {
        if (getRootNode() == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<BinaryNode<T>> queue = new LinkedList<>();
        queue.add(getRootNode());

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            BinaryNode<T> current = queue.poll();
            result.append(current.getData()).append(" ");

            if (current.getLeftChild() != null) {
                queue.add(current.getLeftChild());
            }
            if (current.getRightChild() != null) {
                queue.add(current.getRightChild());
            }
        }

        System.out.println(result.toString().trim());
    }
}
