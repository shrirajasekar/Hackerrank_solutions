package InterviewPrepKit.Arrays.NewYearChaos;

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
   * Complete the 'minimumBribes' function below.
   *
   * The function accepts INTEGER_ARRAY q as parameter.
   */

  public static void minimumBribes(List<Integer> q) {
    // Write your code here
    int flag = 0;
    int diff = 0;
    for (int i = q.size(); i >= 0; i--) {
      if (q.get(i) < q.get(i - 1)) {
        diff = diff + q.get(i - 1) - q.get(i);
        if ((q.get(i - 1) - q.get(i)) > 2) {
          flag = 1;
          break;
        }
      }
    }
    System.out.println(flag == 1 ? "Too Chaotic" : diff);
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {
    // BufferedReader bufferedReader = new BufferedReader(new
    // InputStreamReader(System.in));

    // int t = Integer.parseInt(bufferedReader.readLine().trim());

    // IntStream.range(0, t).forEach(tItr -> {
    // try {
    // int n = Integer.parseInt(bufferedReader.readLine().trim());

    // List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$",
    // "").split(" ")).map(Integer::parseInt)
    // .collect(toList());

    // Result.minimumBribes(q);
    // } catch (IOException ex) {
    // throw new RuntimeException(ex);
    // }
    // });

    // bufferedReader.close();

    int flag = 0;
    int diff = 0;
    List<Integer> q = Arrays.asList(2, 5, 1, 3, 4);
    for (int i = q.size() - 1; i > 0; i--) {
      if (q.get(i) < q.get(i - 1)) {
        diff = diff + q.get(i - 1) - q.get(i);
        if ((q.get(i - 1) - q.get(i)) > 2) {
          flag = 1;
          break;
        }
      }
    }
    System.out.println(flag == 1 ? "Too Chaotic" : diff);
  }
}
