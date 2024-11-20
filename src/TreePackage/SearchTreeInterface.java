package TreePackage;

/**
 * An interface for a search tree, extending the basic tree interface.
 * This interface defines methods specific to binary search tree functionality.
 *
 * @param <T> The type of elements in the tree, which must be comparable.
 */
public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T> {

    /**
     * Checks if the tree contains a specific entry.
     *
     * @param entry The element to search for.
     * @return True if the tree contains the entry, false otherwise.
     */
    boolean contains(T entry);

    /**
     * Retrieves an entry from the tree that matches the given input.
     *
     * @param entry The element to find in the tree.
     * @return The matching element, or null if no match is found.
     */
    T getEntry(T entry);

    /**
     * Adds a new entry to the tree.
     *
     * @param entry The element to add.
     */
    void add(T entry);
}
