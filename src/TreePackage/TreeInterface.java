package TreePackage;

/**
 * An interface for a generic tree structure.
 * This interface provides basic tree operations.
 *
 * @param <T> The type of data stored in the tree.
 */
public interface TreeInterface<T> {

    /**
     * Retrieves the data stored in the root of the tree.
     *
     * @return The data in the root node, or null if the tree is empty.
     */
    T getRootData();

    /**
     * Checks whether the tree is empty.
     *
     * @return True if the tree contains no nodes, false otherwise.
     */
    boolean isEmpty();

    /**
     * Removes all nodes and data from the tree, effectively clearing it.
     */
    void clear();
}
