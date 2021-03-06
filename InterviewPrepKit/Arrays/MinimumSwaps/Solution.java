package InterviewPrepKit.Arrays.MinimumSwaps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

  // Complete the minimumSwaps function below.
  static int minimumSwaps(int[] arr) {
    int swap = 0;
    for (int i = 0; i < arr.length; i++) {
      if ((i + 1) != arr[i]) {
        int c = i;
        while (arr[c] != (i + 1)) {
          c++;
        }
        int temp = arr[c];
        arr[c] = arr[i];
        arr[i] = temp;
        swap++;
      }
    }
    return swap;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    // BufferedWriter bufferedWriter = new BufferedWriter(new
    // FileWriter(System.getenv("OUTPUT_PATH")));

    // int n = scanner.nextInt();
    // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] arr = { 4, 3, 1, 2 };
    // String[] arrItems = scanner.nextLine().split(" ");
    // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    // for (int i = 0; i < n; i++) {
    // int arrItem = Integer.parseInt(arrItems[i]);
    // arr[i] = arrItem;
    // }

    int res = minimumSwaps(arr);
    System.out.println(res);
    // bufferedWriter.write(String.valueOf(res));
    // bufferedWriter.newLine();

    // bufferedWriter.close();

    // scanner.close();
  }
}
