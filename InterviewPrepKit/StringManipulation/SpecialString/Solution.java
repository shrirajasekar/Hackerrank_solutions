package InterviewPrepKit.StringManipulation.SpecialString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the substrCount function below.
  static long substrCount(int n, String s) {
    long result = n;
    List<String> specials = new ArrayList<>();
    // Pass n substrings to isSpecial and add them to a list
    for (int i = 2; i <= n; i++) {
      // i === > number of chars in subs
      // Move substrings through string s and validate
      System.out.println("------------");

      for (int j = 0; j < n; j++) {
        // j ===> starting pos of substring

        if (((j + i) <= n) && isSpecial(s.substring(j, j + i))) {
          System.out.println(String.format("(%d - %d) ===== %s", j, (j + i), s.substring(j, j + i)));
          specials.add(s.substring(j, j + i));
        }
      }

    }
    result = result + specials.size();
    return result;
  }

  static boolean isSpecial(String s) {
    return isAllCharSame(s) || isAllCharExceptMiddleSame(s);
  }

  static boolean isAllCharExceptMiddleSame(String s) {
    Set<Character> allChars = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.length() % 2 != 0 && i != (s.length() / 2)) {
        allChars.add(s.charAt(i));
      }
    }
    return allChars.size() == 1;
  }

  static boolean isAllCharSame(String s) {
    Set<Character> uniqueChars = new HashSet<>();
    boolean flag = false;
    for (char e : s.toCharArray()) {
      uniqueChars.add(e);
    }
    flag = uniqueChars.size() == 1;
    return flag;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    // BufferedWriter bufferedWriter = new BufferedWriter(new
    // FileWriter(System.getenv("OUTPUT_PATH")));

    // int n = scanner.nextInt();
    // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    // String s = scanner.nextLine();

    long result = substrCount(7, "abcbaba");
    System.out.println(result);
    System.out.println(isAllCharExceptMiddleSame("vvbvv"));

    // bufferedWriter.write(String.valueOf(result));
    // bufferedWriter.newLine();

    // bufferedWriter.close();

    // scanner.close();
  }
}
