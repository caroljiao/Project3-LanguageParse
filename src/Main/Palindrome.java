package Main;

/**
 * The Palindrome class provides a simple example program that checks
 * whether a given string is a palindrome (a word, phrase, or sequence
 * that reads the same backward as forward).
 */
public class Palindrome {
   /**
    * The main method initializes a string, processes it to check if it is a palindrome,
    * and prints the result.
    *
    * @param args Command-line arguments (not used).
    */
   public static void main(String[] args) {
      String str = "tacocat";

      // Convert the string to lowercase for case-insensitive comparison
      str = str.toLowerCase();
      boolean isPalindrome = isPalindrome(str);

      // Print the result
      System.out.println(isPalindrome);
   }

   /**
    * Determines if a given string is a palindrome.
    *
    * @param str The input string to be checked.
    * @return {@code true} if the input string is a palindrome; {@code false} otherwise.
    */
   public static boolean isPalindrome(String str) {
      String rev = "";  // Variable to store the reversed string
      boolean ans = false; // Result variable

      // Reverse the input string
      for (int i = str.length() - 1; i >= 0; i--) {
         rev = rev + str.charAt(i);
      }

      // Compare the reversed string with the original
      if (str.equals(rev)) {
         ans = true;
      }
      return ans;
   }
}
