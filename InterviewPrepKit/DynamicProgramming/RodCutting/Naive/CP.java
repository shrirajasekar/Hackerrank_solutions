import java.util.Arrays;
import java.util.Comparator;

public class CP {

  public static void main(String[] args) {

  }

  public static String convertToBaseN(String number, int sBase, int dBase) {
    return Integer.toString(Integer.parseInt(number, sBase), dBase);
  }

  public String conversionPermutation(int input1) {
    String[] arr = new String[35];
    for (int i = 2, j = 0; i <= 36; i++, j++) {
      arr[j] = convertToBaseN(Integer.toString(input1), 10, i);
    }

    Comparator<Integer> lexCompare = new Comparator<Integer>() {
      int compareTo(Integer x, Integer y) {
        return x.toString().compareTo(y.toString());
      }
    };
    Arrays.sort(arr, lexCompare);
    return arr[0];

  }

}
