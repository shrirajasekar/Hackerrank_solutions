
public class Key {

  public static int findKey(int input1, int input2, int input3) {
    int sum = 0;
    sum = (largestDigit(input1)+largestDigit(input2)+largestDigit(input3)) - (smallestDigit(input1)+smallestDigit(input2)+smallestDigit(input3))
    return sum;

  }

  public static int largestDigit(int num) {
    int remainder, largest = 0;
    while (num > 0) {
      remainder = num % 10;
      if (largest < remainder) {
        largest = remainder;
      }
      num = num / 10;
    }
    return largest;
  }

  public static int smallestDigit(int num) {
    int remainder, smallest = num % 10;
    while (num > 0) {
      remainder = num % 10;
      if (smallest > remainder) {
        smallest = remainder;
      }
      num = num / 10;
    }
    return smallest;
  }

  public static void main(String[] args) {
    System.out.println("In Main");
    int sum = 0;
    sum = (largestDigit(3521) + largestDigit(2452) + largestDigit(1352))
        - (smallestDigit(3521) + smallestDigit(2452) + smallestDigit(1352));
    // System.out.println(findKey(3521, 2452, 1352));
    System.out.println(sum);
  }

}