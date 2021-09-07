package InterviewPrepKit.DynamicProgramming.RodCutting.Naive;

// // A Naive recursive solution for Rod cutting problem
class Solution {
  /*
   * Returns the best obtainable price for a rod of length n and price[] as prices
   * of different pieces
   */
  static int cutRod(int price[], int n) {
    if (n <= 0)
      return 0;
    int max_val = Integer.MIN_VALUE;

    // Recursively cut the rod in different pieces and
    // compare different configurations
    for (int i = 0; i < n; i++) {
      System.out.println(String.format("%d --+-- %d ==== %d", price[i], cutRod(price, n - i - 1),
          price[i] + cutRod(price, n - i - 1)));
      System.out.println(String.format("n - i - 1 ==== > %d", n - i - 1));
      max_val = Math.max(max_val, price[i] + cutRod(price, n - i - 1));
      System.out.println(String.format("Max === > %d ", max_val));
    }

    return max_val;
  }

  /* Driver program to test above functions */
  public static void main(String args[]) {
    int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
    int size = arr.length;
    System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));

  }
}
/* This code is contributed by Rajat Mishra */
