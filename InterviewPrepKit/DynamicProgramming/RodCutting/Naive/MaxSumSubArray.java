import java.io.*;
import java.util.Scanner;

public class MaxSumSubArray {
  public static int maxSumFlip(int input1, int[] input2) {
    int total_sum = 0;
    for (int i = 0; i < input1; i++)
      total_sum += input2[i];

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < input1; i++) {
      int sum = 0;
      for (int j = i; j < input1; j++) {
        sum += input2[j];
        max = Math.max(max, total_sum - 2 * sum);
      }
    }
    return Math.max(max, total_sum);
  }

  public static void main(String args[]) {
    int arr[] = { -2, 3, -1, -4, -2 };
    int N = arr.length;
    System.out.println(N);
    // Scanner s = new Scanner(System.in);

    // System.out.println("Input1: ");
    // N = s.nextInt();

    System.out.println(maxSumFlip(N, arr));
  }
}