package Patterns;

import java.util.Scanner;

public class Floyd {

  public static void main(String[] args) {
    Scanner x = new Scanner(System.in);
    System.out.println("Enter number of Rows");
    int n = x.nextInt();
    int num = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < (i + 1); j++) {
        System.out.print(num);
        num++;
      }
      System.out.println();
    }

  }

}
