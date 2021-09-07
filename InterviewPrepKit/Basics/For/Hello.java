package For;

import java.util.Scanner;

public class Hello {
  public static void main(String[] args) {
    Scanner x = new Scanner(System.in);
    System.out.println("Enter a number");
    int n = x.nextInt();

    // Print 5 times
    for (int i = 1; i <= n; i++) {
      System.out.println("Hello " + i);
    }

  }
}
