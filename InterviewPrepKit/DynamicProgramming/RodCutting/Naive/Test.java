public class Test {
  public static void main(String[] args) {
    int a = 0, b = 1, c = 1, n = 10;
    // while (c < n) {
    // b = b * c;
    // a = a + (b / c);
    // c = c + 1;

    // }
    // System.out.println(a);
    System.out.println(testing(10, 7));

  }

  public static int testing(int x, int y) {
    if (x < y) {
      return testing(y, x);
    } else if (y != 0) {
      return (x + testing(x, y - 1));
    } else {
      return 0;
    }
  }

}
