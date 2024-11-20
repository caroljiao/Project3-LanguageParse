package StackAndQueuePackage;

import java.util.NoSuchElementException;

/**
 * The LinkedQueue class implements a generic queue using a singly linked list.
 * It provides operations to enqueue, dequeue, peek, and check whether the queue is empty.
 *
 * @param <T> The type of elements stored in the queue.
 */
public class LinkedQueue<T> {
    private Node<T> front; // Front of the queue
    private Node<T> rear;  // Rear of the queue

    /**
     * Constructs an empty LinkedQueue.
     */
    public LinkedQueue() {
        front = null;
        rear = null;
    }

    /**
     * Adds a new entry to the back of the queue.
     *
     * @param item The item to be added.
     */
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
    }

    /**
     * Removes and returns the front entry of the queue.
     *
     * @return The front entry of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        T data = front.getData();
        front = front.getNext();
        if (front == null) { // If the queue is now empty
            rear = null;
        }
        return data;
    }

    /**
     * Retrieves the front entry without removing it.
     *
     * @return The front entry of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return front.getData();
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Removes all entries from the queue.
     */
    public void clear() {
        front = null;
        rear = null;
    }

    /**
     * Private static nested class representing a node in the linked list.
     *
     * @param <T> The type of data stored in the node.
     */
    private static class Node<T> {
        private T data;       // Data stored in the node
        private Node<T> next; // Reference to the next node

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
         * Retrieves the next node.
         *
         * @return The next node in the list.
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * Sets the next node in the list.
         *
         * @param next The next node to link to.
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
