package Main;

import TreePackage.BinarySearchTree;
import TreePackage.BinaryNode;

import java.io.*;
import java.util.*;

public class Parser {
    private BinarySearchTree<String> reservedWordsBST;
    private BinarySearchTree<String> identifiersBST;

    public Parser() {
        reservedWordsBST = new BinarySearchTree<>();
        identifiersBST = new BinarySearchTree<>();
    }

    public BinarySearchTree<String> getReservedWordsBST() {
        return reservedWordsBST;
    }

    public BinarySearchTree<String> getIdentifiersBST() {
        return identifiersBST;
    }

    /**
     * Initializes the parser by loading reserved words and parsing the input file.
     *
     * @param reservedWordsFilePath Path to the reserved words file.
     * @param sourceFilePath        Path to the Java source file to parse.
     * @throws IOException if there is an error reading the files.
     */
    public void initializeAndParse(String reservedWordsFilePath, String sourceFilePath) throws IOException {
        // Load reserved words
        initializeReservedWords(reservedWordsFilePath);

        // Parse the source file
        parseFile(sourceFilePath);
    }

    /**
     * Loads reserved words from a file and populates a balanced BST.
     *
     * @param filename Path to the reserved words file.
     * @throws IOException if the file cannot be read.
     */
    public void initializeReservedWords(String filename) throws IOException {
        List<String> reservedWords = readLinesFromFile(filename);

        // Sort reserved words and build a balanced BST
        Collections.sort(reservedWords);
        BinaryNode<String> rootNode = buildBalancedBST(reservedWords, 0, reservedWords.size() - 1);
        reservedWordsBST.initializeRoot(rootNode);
    }

    /**
     * Recursively builds a balanced BST from a sorted list of words.
     *
     * @param words A sorted list of words.
     * @param start Starting index of the list.
     * @param end   Ending index of the list.
     * @return The root node of the balanced BST.
     */
    private BinaryNode<String> buildBalancedBST(List<String> words, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        BinaryNode<String> rootNode = new BinaryNode<>(words.get(mid));
        rootNode.setLeftChild(buildBalancedBST(words, start, mid - 1));
        rootNode.setRightChild(buildBalancedBST(words, mid + 1, end));
        return rootNode;
    }

    /**
     * Parses a Java source file to extract reserved words and identifiers.
     *
     * @param filename Path to the source file.
     * @throws IOException if the file cannot be read.
     */
    public void parseFile(String filename) throws IOException {
        List<String> lines = readLinesFromFile(filename);

        for (String line : lines) {
            String[] tokens = line.split("[^a-zA-Z0-9]+"); // Tokenize by stripping punctuation and whitespace
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    // Check in reservedWordsBST
                    if (reservedWordsBST.contains(token)) {
                        // Reserved word; skip adding to identifiers
                        System.out.println("Reserved Word: " + token);
                    } else if (!identifiersBST.contains(token)) {
                        // Only add non-reserved words as identifiers
                        identifiersBST.add(token);
                        System.out.println("Identifier Added: " + token);
                    }
                }
            }
        }
    }


    /**
     * Prints all reserved words found in the source file.
     */
    public void printReservedWords() {
        System.out.println("Reserved Words Found in the File:");
        Iterator<String> iterator = reservedWordsBST.getInorderIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * Prints all user-defined identifiers found in the source file.
     */
    public void printIdentifiers() {
        System.out.println("User-Defined Identifiers Found in the File:");
        List<String> identifiers = new ArrayList<>();
        Iterator<String> iterator = identifiersBST.getInorderIterator();
        while (iterator.hasNext()) {
            identifiers.add(iterator.next());
        }
        // Sort identifiers to ensure consistent output
        identifiers.sort(String::compareTo);
        for (String identifier : identifiers) {
            System.out.println(identifier);
        }
    }

    /**
     * Helper method to read lines from a file into a list.
     *
     * @param filename Path to the file.
     * @return A list of lines from the file.
     * @throws IOException if the file cannot be read.
     */
    private List<String> readLinesFromFile(String filename) throws IOException {
        List<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }
        }
        return lines;
    }
}
