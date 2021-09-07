package Patterns;

import java.util.Scanner;

public class HalfTriangle {

  public static void main(String[] args) {
    Scanner x = new Scanner(System.in);
    System.out.println("Enter number of Rows");
    int n = x.nextInt();

    for (int i = 0; i < n; i++) {
      // Something
      // Print _row number_ stars ->> (i+1) stars
      for (int j = 0; j <= i; j++) {
        System.out.print(j + 1);

      }
      System.out.println();
    }

  }
}
