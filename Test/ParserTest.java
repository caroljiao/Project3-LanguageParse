import Main.Parser;
import TreePackage.BinarySearchTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Parser class to validate its functionality in handling reserved words
 * and user-defined identifiers in Java source files.
 */
class ParserTest {

    private Parser parser;

    /**
     * Sets up a new Parser instance before each test case.
     */
    @BeforeEach
    void setUp() {
        parser = new Parser();
    }

    /**
     * Tests the initializeReservedWords method to ensure it correctly reads
     * reserved words from a file and adds them to the reserved words binary search tree.
     *
     * @throws IOException if an error occurs while reading or writing files.
     */
    @Test
    void initializeReservedWords() throws IOException {
        String reservedWordsTestFile = "reservedWordsTest.txt";
        Files.write(Paths.get(reservedWordsTestFile), String.join("\n", "abstract", "boolean", "public", "while").getBytes());

        parser.initializeReservedWords(reservedWordsTestFile);

        BinarySearchTree<String> reservedWordsBST = parser.getReservedWordsBST();
        assertTrue(reservedWordsBST.contains("abstract"));
        assertTrue(reservedWordsBST.contains("boolean"));
        assertTrue(reservedWordsBST.contains("public"));
        assertTrue(reservedWordsBST.contains("while"));

        Files.delete(Paths.get(reservedWordsTestFile));
    }

    /**
     * Tests the parseFile method to verify it processes a Java source file
     * and correctly separates reserved words from user-defined identifiers.
     *
     * @throws IOException if an error occurs while reading or writing files.
     */
    @Test
    void parseFile() throws IOException {
        String testSourceFile = "PalindromeTest.java";
        Files.write(Paths.get(testSourceFile), String.join("\n",
                "public class Palindrome {",
                "    public static void main(String[] args) {",
                "        String str = \"tacocat\";",
                "    }",
                "}"
        ).getBytes());

        String reservedWordsTestFile = "reservedWordsTest.txt";
        Files.write(Paths.get(reservedWordsTestFile), String.join("\n", "public", "class", "static", "boolean").getBytes());

        parser.initializeAndParse(reservedWordsTestFile, testSourceFile);

        BinarySearchTree<String> reservedWordsBST = parser.getReservedWordsBST();
        assertTrue(reservedWordsBST.contains("public"));
        assertTrue(reservedWordsBST.contains("class"));
        assertTrue(reservedWordsBST.contains("static"));
        assertTrue(reservedWordsBST.contains("boolean"));

        BinarySearchTree<String> identifiersBST = parser.getIdentifiersBST();
        assertTrue(identifiersBST.contains("Palindrome"));
        assertTrue(identifiersBST.contains("main"));
        assertTrue(identifiersBST.contains("args"));
        assertTrue(identifiersBST.contains("str"));
        assertTrue(identifiersBST.contains("tacocat"));

        Files.delete(Paths.get(testSourceFile));
        Files.delete(Paths.get(reservedWordsTestFile));
    }

    /**
     * Tests the printReservedWords method to ensure it correctly outputs the
     * reserved words in alphabetical order.
     *
     * @throws IOException if an error occurs while reading or writing files.
     */
    @Test
    void printReservedWords() throws IOException {
        String reservedWordsTestFile = "reservedWordsTest.txt";
        Files.write(Paths.get(reservedWordsTestFile), String.join("\n", "public", "class", "boolean").getBytes());

        parser.initializeReservedWords(reservedWordsTestFile);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        parser.printReservedWords();

        String expectedOutput = "Reserved Words Found in the File:\nboolean\nclass\npublic\n";
        assertEquals(expectedOutput, outContent.toString().replace("\r", ""));

        System.setOut(System.out);

        Files.delete(Paths.get(reservedWordsTestFile));
    }
}
