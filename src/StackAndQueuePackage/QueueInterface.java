package StackAndQueuePackage;

/**
 * An interface for a queue data structure.
 * A queue is a collection of objects that are inserted and removed according to the first-in, first-out (FIFO) principle.
 *
 * @param <T> The type of elements stored in the queue.
 */
public interface QueueInterface<T> {

    /**
     * Adds a new entry to the back of the queue.
     *
     * @param newEntry The object to be added to the queue.
     */
    void enqueue(T newEntry);

    /**
     * Removes and returns the entry at the front of the queue.
     *
     * @return The object at the front of the queue.
     * @throws java.util.NoSuchElementException if the queue is empty.
     */
    T dequeue();

    /**
     * Retrieves the entry at the front of the queue without removing it.
     *
     * @return The object at the front of the queue.
     * @throws java.util.NoSuchElementException if the queue is empty.
     */
    T peek();

    /**
     * Checks whether the queue is empty.
     *
     * @return {@code true} if the queue is empty; {@code false} otherwis
    boolean isEmpty();
}
