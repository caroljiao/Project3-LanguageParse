package TreePackage;

/**
 * An interface for a binary tree structure.
 * This interface extends the {@link TreeInterface} and provides additional methods for setting up binary trees.
 *
 * @param <T> The type of data stored in the tree.
 */
public interface BinaryTreeInterface<T> extends TreeInterface<T> {

    /**
     * Sets the data in the root of the tree, clearing any existing tree structure.
     *
     * @param rootData The data to set in the root node.
     */
    void setTree(T rootData);

    /**
     * Sets the root data and attaches two subtrees to the root.
     * Any existing tree structure is replaced.
     *
     * @param rootData The data to set in the root node.
     * @param leftTree The left subtree to attach to the root (can be null for no left subtree).
     * @param rightTree The right subtree to attach to the root (can be null for no right subtree).
     */
    void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
}
