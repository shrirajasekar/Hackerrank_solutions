public class ReverseString {
  public static void main(String[] args) {
    String input = "Shri";
    int l = input.length();
    String reverse = "";

    for (int i = l - 1; i >= 0; i--) {
      reverse = reverse + input.charAt(i);
      System.out.println(reverse);

    }
    System.out.println(reverse);
  }
}
