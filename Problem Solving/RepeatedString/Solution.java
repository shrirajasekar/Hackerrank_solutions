import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        // If n < string length - pass substring to count fn
        long result = 0;
        long rep = 0;
        long end = s.length();
        if (n <= s.length()) {
            end = (int) n;
            result = countA(s.substring(0, (int) end));
        } else {
            rep = n / s.length();
            end = n % s.length();
            rep = rep * countA(s);
            result = rep + countA(s.substring(0, (int) end));
        }
        // If n > string length -
        // Count number of a in one instance of the string
        // Divide String length by n - Find number of repetition

        // Find remainder of string length by n - Pass Substring of size remainder from
        // start
        // to count function

        return result;
    }

    // Count a function
    private static long countA(String s) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);

        scanner.close();
    }
}
