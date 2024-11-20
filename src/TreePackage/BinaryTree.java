package TreePackage;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A generic Binary Tree implementation that provides basic tree operations such as
 * checking if the tree is empty, clearing the tree, and traversing the tree using
 * in-order and breadth-first traversal.
 *
 * @param <T> The type of elements stored in the tree.
 */
public class BinaryTree<T> implements TreeInterface<T> {
    private BinaryNode<T> root;

    /**
     * Default constructor that creates an empty binary tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Retrieves the data stored in the root node of the tree.
     *
     * @return The data in the root node, or {@code null} if the tree is empty.
     */
    public T getRootData() {
        return (root != null) ? root.getData() : null;
    }

    /**
     * Checks whether the binary tree is empty.
     *
     * @return {@code true} if the tree is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Clears the binary tree by removing all nodes.
     */
    public void clear() {
        root = null;
    }

    /**
     * Sets the root node of the binary tree.
     *
     * @param rootNode The new root node of the tree.
     */
    public void setRootNode(BinaryNode<T> rootNode) {
        this.root = rootNode;
    }

    /**
     * Retrieves the root node of the binary tree.
     * This method is protected to allow subclasses to access the root node.
     *
     * @return The root node of the tree.
     */
    protected BinaryNode<T> getRootNode() {
        return root;
    }

    /**
     * Provides an iterator that performs an in-order traversal of the binary tree.
     *
     * In-order traversal visits nodes in the following order:
     * 1. Left child
     * 2. Current node
     * 3. Right child
     *
     * @return An iterator for in-order traversal of the tree.
     */
    public Iterator<T> getInorderIterator() {
        return new InorderIterator();
    }

    /**
     * An inner class that implements an in-order traversal iterator for the binary tree.
     */
    private class InorderIterator implements Iterator<T> {
        private LinkedList<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;

        /**
         * Constructor for the in-order iterator, initializing the traversal.
         */
        public InorderIterator() {
            nodeStack = new LinkedList<>();
            currentNode = root;
        }

        /**
         * Checks if there are more nodes to visit during the traversal.
         *
         * @return {@code true} if there are more nodes to visit, {@code false} otherwise.
         */
        @Override
        public boolean hasNext() {
            return !nodeStack.isEmpty() || currentNode != null;
        }

        /**
         * Retrieves the next node in the in-order traversal.
         *
         * @return The data of the next node in the traversal.
         */
        @Override
        public T next() {
            BinaryNode<T> nextNode = null;

            // Traverse to the leftmost node
            while (currentNode != null) {
                nodeStack.addFirst(currentNode); // Push to stack
                currentNode = currentNode.getLeftChild();
            }

            if (!nodeStack.isEmpty()) {
                nextNode = nodeStack.removeFirst(); // Pop from stack
                currentNode = nextNode.getRightChild();
            }

            return nextNode != null ? nextNode.getData() : null;
        }
    }

    /**
     * Performs a breadth-first traversal of the binary tree.
     * Visits nodes level by level, starting from the root.
     *
     * This method is primarily for debugging and visualization purposes.
     */
    public void breadthFirstTraversal() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        LinkedList<BinaryNode<T>> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("Breadth-First Traversal:");
        while (!queue.isEmpty()) {
            BinaryNode<T> current = queue.poll();
            System.out.print(current.getData() + " ");

            if (current.getLeftChild() != null) {
                queue.add(current.getLeftChild());
            }
            if (current.getRightChild() != null) {
                queue.add(current.getRightChild());
            }
        }
        System.out.println(); // Line break after traversal
    }
}
