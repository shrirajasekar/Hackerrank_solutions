package InterviewPrepKit.StringManipulation.MakeAnagrams;

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
   * Complete the 'makeAnagram' function below.
   *
   * The function is expected to return an INTEGER. The function accepts following
   * parameters: 1. STRING a 2. STRING b
   */

  public static int makeAnagram(String a, String b) {
    // Write your code here
    int[] freqFirst = new int[26];
    int[] freqSecond = new int[26];
    int deletions = 0;

    for (int i = 0; i < a.length(); i++) {
      freqFirst[a.charAt(i) - 'a'] = freqFirst[a.charAt(i) - 'a'] + 1;
    }
    for (int j = 0; j < b.length(); j++) {
      freqSecond[b.charAt(j) - 'a'] = freqSecond[b.charAt(j) - 'a'] + 1;
    }

    for (int k = 0; k < 26; k++) {
      deletions = deletions + Math.abs(freqFirst[k] - freqSecond[k]);
    }

    System.out.println(deletions);
    return deletions;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    // BufferedReader bufferedReader = new BufferedReader(new
    // InputStreamReader(System.in));
    // BufferedWriter bufferedWriter = new BufferedWriter(new
    // FileWriter(System.getenv("OUTPUT_PATH")));

    String a = "cde";
    String b = "abc";

    int res = Result.makeAnagram(a, b);

    // bufferedWriter.write(String.valueOf(res));
    // bufferedWriter.newLine();

    // bufferedReader.close();
    // bufferedWriter.close();
  }
}
