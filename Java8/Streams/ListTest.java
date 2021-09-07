package Java8.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
  public static void main(String[] args) {
    List<String> employees = Arrays.asList("Shri", "Raj", "Adam", "Albert", "Bob", "Cathy");
    // employees.forEach(e -> {
    // if (!e.startsWith("A")) {
    // System.out.println(e);
    // }
    // });
    employees.stream().filter(e -> e.startsWith("A")).forEach(System.out::println);
  }

}
