package Java8.Streams;

import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

import java.util.Arrays;

public class StreamsBasic {
  public static void main(String[] args) {
    List<String> animals = Stream.of("Monkey", "Lion", "Giraffe", "Lemur").filter(s -> s.startsWith("L"))
        .map(String::toUpperCase).sorted().collect(toList());

    System.out.println(animals);

    List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
    List<String> result = givenList.stream().collect(toUnmodifiableList());
    assertThatThrownBy(() -> result.add("foo"))
  .isInstanceOf(UnsupportedOperationException.class);
  }
}
