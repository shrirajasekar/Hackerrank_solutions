package Patterns;

import java.util.Scanner;

public class FullTriangle {
  public static void main(String[] args) {

    Scanner x = new Scanner(System.in);
    System.out.println("Enter number of Rows");
    int n = x.nextInt();

    for (int i = 0; i < n; i++) {
      // Print Space
      for (int s = 0; s < (n - (2 * i) + 2); s++) {
        System.out.print(" ");
      }

      // Print Stars
      for (int j = 0; j < (2 * i + 1); j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }

}
