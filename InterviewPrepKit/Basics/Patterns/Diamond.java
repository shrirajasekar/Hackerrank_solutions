package Patterns;

import java.util.Scanner;

public class Diamond {
  public static void main(String[] args) {
    Scanner x = new Scanner(System.in);
    System.out.println("Enter number of Rows");
    int n = x.nextInt();

    // Print Full Triangle
    for (int i = 0; i < ((n / 2) + 1); i++) {
      // Print Space
      for (int s = 0; s < (n / 2 - i); s++) {
        System.out.print(" ");
      }

      // Print Star
      for (int j = 0; j < (2 * i + 1); j++) {
        System.out.print("*");
      }

      // Next Line
      System.out.println();
    }

    // Print Inverted Triangle

    for (int i = 0; i < n / 2; i++) {

      // Print Space
      for (int s = 0; s < (i + 1); s++) {
        System.out.print(" ");
      }

      // Print Star
      for (int j = 0; j < (2 * (n / 2) - 1 - 2 * i); j++) {
        System.out.print("*");
      }

      // Next Line
      System.out.println();

    }

  }
}
