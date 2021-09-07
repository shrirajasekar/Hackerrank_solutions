package cts;

public class Apples {

  public static int minGridPerimeter(int input1) {
    double totalApplesInSquare = 0;
    int unit = 0;
    while (input1 > totalApplesInSquare) {
      unit++;

      totalApplesInSquare += 12 * Math.pow(unit, 2);
    }

    return unit * 8;
  }

  public static void main(String[] args) {
    System.out.println(minGridPerimeter(13));
  }
}
