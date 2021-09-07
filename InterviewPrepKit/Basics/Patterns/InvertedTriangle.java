package Patterns;

import java.util.Scanner;

public class InvertedTriangle {
  public static void main(String[] args) {
    Scanner x = new Scanner(System.in);
    System.out.println("Enter number of Rows");
    int n = x.nextInt();

    for (int i = 0; i < n; i++) {
      // Print Space
      for (int s = 0; s < i; s++) {
        System.out.print(" ");
      }
      // Print Star
      for (int j = 0; j < Math.abs(2 * (n - i) - 1); j++) {
        System.out.print("*");
      }

      // Next line
      System.out.println();
    }
  }
}
