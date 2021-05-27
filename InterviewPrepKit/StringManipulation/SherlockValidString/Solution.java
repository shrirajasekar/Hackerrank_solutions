package InterviewPrepKit.StringManipulation.SherlockValidString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  /*
   * Complete the 'isValid' function below.
   *
   * The function is expected to return a STRING. The function accepts STRING s as
   * parameter.
   */

  public static String isValid(String s) {
    // Write your code here

    String result = "YES";
    Map<Character, Integer> frequencies = new HashMap<>();
    Set<Integer> uniqueFreqs = new HashSet<>();
    for (char c : s.toCharArray()) {
      if (frequencies.containsKey(c)) {
        frequencies.put(c, frequencies.get(c) + 1);
      } else {
        frequencies.put(c, 1);
      }
    }

    for (int i : frequencies.values()) {
      uniqueFreqs.add(i);
    }

    if (uniqueFreqs.size() == 1) {
      result = "YES";
    } else if (uniqueFreqs.size() > 2) {
      result = "NO";
    } else {
      // Unique freqs = 2
      int f1 = 0, f2 = 0, f1Count = 0, f2Count = 0;
      int i = 0;
      for (int n : uniqueFreqs) {
        if (i == 0) {
          f1 = n;
        } else {
          f2 = n;
        }
        i++;
      }
      // Calculate f1 and f2 count
      for (int x : frequencies.values()) {
        if (x == f1) {
          f1Count++;
        } else if (x == f2) {
          f2Count++;
        }
      }

      if ((f1 == 1 && f1Count == 1) || (f2 == 1 && f2Count == 1)) {
        result = "YES";
      } else if ((Math.abs(f1 - f2) == 1) && (f2Count == 1 || f1Count == 1)) {
        result = "YES";
      } else {
        result = "NO";
      }
    }

    return result;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String s = bufferedReader.readLine();

    String result = Result.isValid(s);

    bufferedWriter.write(result);
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
