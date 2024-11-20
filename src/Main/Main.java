package Main;

import java.io.File;
import java.io.IOException;

/**
 * The Main class serves as the entry point for the Java Language Parser program.
 * It initializes the Parser, checks for required input files, and processes a source Java file
 * to identify reserved words and user-defined identifiers.
 */
public class Main {
    /**
     * The main method of the program. It initializes the Parser, verifies input files,
     * and processes the reserved words and source Java file to display the results.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of the Parser class
        Parser parser = new Parser();

        // Define file paths
        String reservedWordsFilePath = "reservedWords.txt";
        String sourceFilePath = "Palindrome.java";

        // Debug: Check if the input files exist
        if (!checkFileExists(reservedWordsFilePath, "reservedWords.txt") ||
                !checkFileExists(sourceFilePath, "Palindrome.java")) {
            System.err.println("\nError: One or more required files are missing. Exiting program.");
            return; // Exit the program
        }

        try {
            // Initialize and parse the files
            parser.initializeAndParse(reservedWordsFilePath, sourceFilePath);

            // Print the results
            System.out.println("\n--- Reserved Words Found ---");
            parser.printReservedWords();

            System.out.println("\n--- User-Defined Identifiers Found ---");
            parser.printIdentifiers();

        } catch (IOException e) {
            // Handle any IO exceptions
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Checks if a file exists and logs its status.
     *
     * @param filePath  The path to the file.
     * @param fileLabel A label for the file (for logging purposes).
     * @return True if the file exists, false otherwise.
     */
    private static boolean checkFileExists(String filePath, String fileLabel) {
        File file = new File(filePath);
        System.out.println("Checking " + fileLabel + ":");
        System.out.println("File exists: " + file.exists());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        return file.exists();
    }
}
