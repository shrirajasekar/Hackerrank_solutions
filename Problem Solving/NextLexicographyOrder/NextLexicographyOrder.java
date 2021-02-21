import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NextLexicographyOrder {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        String result = "";
        StringBuilder s = new StringBuilder(w);
        int pivot;
        // Find the non-increasing suffix from right to left
        int i = w.length() - 1; // Because we are going from right to left
        while (i > 0 && Character.compare(s.charAt(i), s.charAt(i - 1)) <= 0) { // charAt i (Right) should be less than
            i--;                // charAt i-1 (left)
        }
        if (i == 0) { // Already in last/largest permutation
            result = "no answer";
            return result;
        }
        // Find the pivot point - One position to the left of 'Non-Increasing Suffix'
        pivot = i - 1; // i is the start of the suffix. So i-1 is the pivot

            int j = s.length() - 1;
            while (j > pivot) { // Traverse only through suffix
                if (Character.compare(s.charAt(j), s.charAt(pivot)) > 0) {
                    char pivotChar = s.charAt(pivot);
                    s.setCharAt(pivot, s.charAt(j));
                    s.setCharAt(j, pivotChar);
                    // ----- pivot --- j ----
                    // ----- j ---- pivot ----
                    break;
                }
                j--;
            }
        // Swap Pivot with the first greater than pivot element from the right in suffix

        // Reverse the suffix

        StringBuilder suffix = new StringBuilder(s.substring(pivot + 1));
        suffix = suffix.reverse();
        return (s.substring(0, pivot+1) + suffix).toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);
            System.out.println(result);
            // bufferedWriter.write(result);
            // bufferedWriter.newLine();
        }

        // bufferedWriter.close();

        scanner.close();
    }
}


