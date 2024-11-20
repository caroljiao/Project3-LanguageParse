package StackAndQueuePackage;

/**
 * An interface for a stack data structure.
 * A stack is a collection of objects that are inserted and removed according to the last-in, first-out (LIFO) principle.
 *
 * @param <T> The type of elements stored in the stack.
 */
public interface StackInterface<T> {

    /**
     * Adds a new entry to the top of the stack.
     *
     * @param newEntry The object to be added to the stack.
     */
    void push(T newEntry);

    /**
     * Removes and returns the top entry of the stack.
     *
     * @return The object at the top of the stack.
     * @throws java.util.EmptyStackException if the stack is empty.
     */
    T pop();

    /**
     * Retrieves the top entry of the stack without removing it.
     *
     * @return The object at the top of the stack.
     * @throws java.util.EmptyStackException if the stack is empty.
     */
    T peek();

    /**
     * Checks whether the stack is empty.
     *
     * @return {@code true} if the stack is empty; {@code false} otherwise.
     */
    boolean isEmpty();
}
