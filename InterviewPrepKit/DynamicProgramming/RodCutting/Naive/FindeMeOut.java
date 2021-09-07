public class FindeMeOut {
  public static void main(String[] args) {
    int N = 10;
    System.out.println(FindeMe(N));
  }

  public static int FindeMe(int input1) {
    int res = 0;
    for (int i = 2; i <= Integer.MAX_VALUE; i++) {
      if (findSum(input1 * i) == input1) {
        res = input1 * i;
        break;
      }
    }
    return res;
  }

  public static int findSum(int number) {
    int sum = 0;
    while (number != 0) {
      sum = sum + number % 10;
      number = number / 10;
    }
    return sum;
  }
}
