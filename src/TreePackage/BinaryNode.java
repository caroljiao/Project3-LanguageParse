package TreePackage;

/**
 * Represents a single node in a binary tree.
 *
 * @param <T> The type of data stored in the node.
 */
public class BinaryNode<T> {
    private T data;                     // Data stored in the node
    private BinaryNode<T> leftChild;    // Reference to the left child
    private BinaryNode<T> rightChild;   // Reference to the right child

    /**
     * Constructs a BinaryNode with the given data.
     *
     * @param data The data to store in the node.
     */
    public BinaryNode(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Constructs a BinaryNode with the given data and child nodes.
     *
     * @param data       The data to store in the node.
     * @param leftChild  The left child of the node.
     * @param rightChild The right child of the node.
     */
    public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * Retrieves the data stored in the node.
     *
     * @return The data stored in the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Updates the data stored in the node.
     *
     * @param data The new data to store in the node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Retrieves the left child of the node.
     *
     * @return The left child of the node, or {@code null} if none exists.
     */
    public BinaryNode<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Updates the left child of the node.
     *
     * @param leftChild The new left child of the node.
     */
    public void setLeftChild(BinaryNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Retrieves the right child of the node.
     *
     * @return The right child of the node, or {@code null} if none exists.
     */
    public BinaryNode<T> getRightChild() {
        return rightChild;
    }

    /**
     * Updates the right child of the node.
     *
     * @param rightChild The new right child of the node.
     */
    public void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * Checks if the node has a left child.
     *
     * @return {@code true} if the node has a left child, {@code false} otherwise.
     */
    public boolean hasLeftChild() {
        return leftChild != null;
    }

    /**
     * Checks if the node has a right child.
     *
     * @return {@code true} if the node has a right child, {@code false} otherwise.
     */
    public boolean hasRightChild() {
        return rightChild != null;
    }

    /**
     * Checks if the node is a leaf (has no children).
     *
     * @return {@code true} if the node is a leaf, {@code false} otherwise.
     */
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    /**
     * Returns a string representation of the data stored in the node.
     *
     * @return A string representation of the node's data.
     */
    @Override
    public String toString() {
        return data.toString();
    }
}
