package interfaces;

public class ArrayTest {
  public static void main(String[] args) {
    int size = 25;
    Long[] array = new Long[size];
    for (long j = 0; j < size; j++) {
      System.out.println(j);
      System.out.println(array[(int) j]);
    }
  }
}