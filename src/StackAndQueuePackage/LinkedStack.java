package StackAndQueuePackage;

import java.util.EmptyStackException;

/**
 * The LinkedStack class implements a generic stack using a singly linked list.
 * It provides operations to push, pop, peek, and check whether the stack is empty.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class LinkedStack<T> {
    private Node<T> topNode; // Top node in the stack

    /**
     * Constructs an empty LinkedStack.
     */
    public LinkedStack() {
        topNode = null;
    }

    /**
     * Pushes a new entry onto the top of the stack.
     *
     * @param item The item to be added to the stack.
     */
    public void push(T item) {
        topNode = new Node<>(item, topNode);
    }

    /**
     * Removes and returns the top entry of the stack.
     *
     * @return The top entry of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = topNode.getData();
        topNode = topNode.getNext();
        return data;
    }

    /**
     * Retrieves the top entry without removing it.
     *
     * @return The top entry of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return topNode == null;
    }

    /**
     * Removes all entries from the stack.
     */
    public void clear() {
        topNode = null; // Deallocate all nodes
    }

    /**
     * Private static nested class representing a node in the linked list.
     *
     * @param <T> The type of data stored in the node.
     */
    private static class Node<T> {
        private T data;       // Data stored in the node
        private Node<T> next; // Link to the next node

        /**
         * Constructs a Node with the given data and next reference.
         *
         * @param data The data to store in the node.
         * @param next The next node in the list.
         */
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
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
         * Retrieves the next node in the list.
         *
         * @return The next node in the list.
         */
        public Node<T> getNext() {
            return next;
        }
    }
}
