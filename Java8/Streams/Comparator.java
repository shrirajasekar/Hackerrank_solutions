package Java8.Streams;

import java.util.Arrays;

public class Comparator {

  public static void main(String[] args) {
    String[] words = { "a", "is", "boy", "playing" };

    // Arrays.sort(words);
    Arrays.sort(words, (x, y) -> Integer.compare(x.length(), y.length()));
    System.out.println(Arrays.toString(words));
  }

}
