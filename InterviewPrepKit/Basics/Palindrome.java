import java.util.InputMismatchException;

public class Palindrome {
  public static void main(String[] args) {
    // madam
    String input = "mada1m";

    // Method 1 - Reverse a String and check if equal ----- NOT Efficient
    if (input.equals(reverseString(input))) {
      System.out.println("Palin");
    } else {
      System.out.println("NP");
    }
    // Method 2 - Check if first and last char is same and so on.
    System.out.println(checkPalindrome(input));
  }

  public static String reverseString(String input) {
    String reverse = "";
    int l = input.length();

    for (int i = l - 1; i >= 0; i--) { // Runs for length of the STring times.
      reverse = reverse + input.charAt(i);
    }

    return reverse;
  }

  public static boolean checkPalindrome(String input) {
    int l = input.length();
    boolean result = true;

    for (int i = 0; i <= l / 2; i++) {
      if (input.charAt(i) != input.charAt(l - 1 - i)) {
        result = false;
        break;
      }
    }

    return result;
  }
}
