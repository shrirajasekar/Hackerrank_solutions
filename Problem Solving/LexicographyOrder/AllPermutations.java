import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AllPermutations {

    static String nextPermutation(String w) {
        String result = "";
        StringBuilder s = new StringBuilder(w);
        int pivot;
        // Find the non-increasing suffix from right to left
        int i = w.length() - 1; // Because we are going from right to left
        while (i > 0 && Character.compare(s.charAt(i), s.charAt(i - 1)) <= 0)
        // charAt i (Right) should be less than the one on the left (i-1)
        {
            i--; // charAt i-1 (left)
        }
        if (i == 0) { // Already in last/largest permutation
            result = "no answer";
            return result;
        }
        // Find the pivot point - One position to the left of 'Non-Increasing Suffix'
        pivot = i - 1; // i is the start of the suffix. So i-1 is the pivot

        // Swap Pivot with the first greater than element from the right in suffix
        int j = s.length() - 1;
        while (j > pivot) { // Traverse only through suffix
            if (Character.compare(s.charAt(j), s.charAt(pivot)) > 0) {
                char pivotChar = s.charAt(pivot);
                s.setCharAt(pivot, s.charAt(j));
                s.setCharAt(j, pivotChar);
                break;
            }
            j--;
        }

        // Reverse the suffix

        StringBuilder suffix = new StringBuilder(s.substring(pivot + 1));
        suffix = suffix.reverse();
        return (s.substring(0, pivot + 1) + suffix).toString();
    }

    static String prevPermutation(String w) {
        String result = "";
        StringBuilder s = new StringBuilder(w);
        int pivot;
        // Find the non-decreasing suffix from right to left
        int i = w.length() - 1; // Because we are going from right to left
        while (i > 0 && Character.compare(s.charAt(i), s.charAt(i - 1)) > 0)
        // charAt i (Right) should be less than the one on the left (i-1)
        {
            i--; // charAt i-1 (left)
        }
        if (i == 0) { // Already in first/least permutation
            result = "no answer";
            return result;
        }
        // Find the pivot point - One position to the left of 'Non-Increasing Suffix'
        pivot = i - 1; // i is the start of the suffix. So i-1 is the pivot

        // Swap Pivot with the first lesser than the element from the right in suffix
        int j = s.length() - 1;
        while (j > pivot) { // Traverse only through suffix
            if (Character.compare(s.charAt(j), s.charAt(pivot)) < 0) {
                char pivotChar = s.charAt(pivot);
                s.setCharAt(pivot, s.charAt(j));
                s.setCharAt(j, pivotChar);
                break;
            }
            j--;
        }

        // Reverse the suffix

        StringBuilder suffix = new StringBuilder(s.substring(pivot + 1));
        suffix = suffix.reverse();
        return (s.substring(0, pivot + 1) + suffix).toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String w = scanner.nextLine();
        String prev = w;
        String next = w;
        String result = w;
        while (true) {
            prev = prevPermutation(prev);
            if (!prev.equals("no answer"))
                result = prev + "\n" + result;
            if (prev.equals("no answer"))
                break;
        }
        while (true) {
            next = nextPermutation(next);
            if (!next.equals("no answer"))
                result = result + "\n" + next;
            if (next.equals("no answer"))
                break;
        }
        System.out.println(result);
        scanner.close();
    }
}
