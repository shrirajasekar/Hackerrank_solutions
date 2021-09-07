package Java8.Streams;

import java.util.List;
import java.util.ArrayList;

public class LambdaExample {
  public static void main(String[] args) {
    List<Integer> items = new ArrayList<>();

    items.add(2);
    items.add(3);
    items.add(4);

    // items.forEach(item -> System.out.println(item * item));
    items.forEach(System.out::println);
  }
}