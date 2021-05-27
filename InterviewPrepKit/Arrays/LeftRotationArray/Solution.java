package InterviewPrepKit.Arrays.LeftRotationArray;

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

// class Result {

/*
 * Complete the 'rotLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY. The function accepts
 * following parameters: 1. INTEGER_ARRAY a 2. INTEGER d
 */

// }

public class Solution {
  public static void main(String[] args) throws IOException {
    // int n = 5;

    int d = 4;

    List<Integer> a = Arrays.asList(1, 2, 3, 4, 5);

    List<Integer> result = rotLeft(a, d);
  }

  public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
    List<Integer> firstPart = a.subList(d, a.size());
    List<Integer> secondPart = a.subList(0, d);
    List<Integer> result = new ArrayList<>();
    result.addAll(firstPart);
    result.addAll(secondPart);
    return result;
  }

}
