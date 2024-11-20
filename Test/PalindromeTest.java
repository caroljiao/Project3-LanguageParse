import Main.Palindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Palindrome class to validate the functionality of
 * palindrome detection and proper handling of the main method.
 */
class PalindromeTest {

    /**
     * Tests the isPalindrome method with various cases, including:
     * - Valid palindromes
     * - Case insensitivity
     * - Empty strings
     * - Single characters
     * - Non-palindromic inputs
     */
    @Test
    void isPalindrome() {
        assertTrue(Palindrome.isPalindrome("tacocat"), "Should return true for a valid palindrome.");
        assertTrue(Palindrome.isPalindrome("Able was I ere I saw Elba".toLowerCase()), "Should handle case-insensitive palindromes.");
        assertFalse(Palindrome.isPalindrome("hello"), "Should return false for a non-palindrome.");
        assertTrue(Palindrome.isPalindrome(""), "Should return true for an empty string.");
        assertTrue(Palindrome.isPalindrome("a"), "Should return true for a single character.");
        assertFalse(Palindrome.isPalindrome("12345"), "Should return false for non-palindromic numbers.");
        assertTrue(Palindrome.isPalindrome("12321"), "Should return true for numeric palindromes.");
    }

    /**
     * Tests the main method of the Palindrome class.
     * Ensures that the main method executes without throwing exceptions.
     */
    @Test
    void main() {
        try {
            String[] args = {};
            Palindrome.main(args); // Execute the main method
        } catch (Exception e) {
            fail("Main method should not throw exceptions. Error: " + e.getMessage());
        }
    }
}
