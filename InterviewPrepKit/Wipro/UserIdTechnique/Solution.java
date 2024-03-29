package UserIdTechnique;

import java.util.*;

public class Solution {

  private static String output1;

  public static void userIdGeneration(String input1, String input2, int input3, int input4) {
    String longer = "";
    String smaller = "";
    int s1 = input1.length();
    int s2 = input2.length();
    output1 = "";

    if (s1 == s2) {
      if (input1.compareTo(input2) > 0) {
        longer = input1;
        smaller = input2;
      } else {
        longer = input2;
        smaller = input1;
      }
    } else if (s1 > s2) {
      longer = input1;
      smaller = input2;
    } else {
      longer = input2;
      smaller = input1;
    }
    String pin = input3 + "";
    String output = smaller.charAt(0) + longer + pin.charAt(input4 - 1) + pin.charAt(pin.length() - input4);
    for (int i = 0; i < output.length(); i++) {
      if (Character.isUpperCase(output.charAt(i))) {
        output1 += Character.toLowerCase(output.charAt(i));
      } else if (Character.isLowerCase(output.charAt(i))) {
        output1 += Character.toUpperCase(output.charAt(i));
      } else {
        output1 += output.charAt(i);
      }
    }

  }

  public static void main(String[] args) {
    /* Do NOT Alter main() */
    Scanner in = new Scanner(System.in);
    String input1 = in.next();
    String input2 = in.next();
    int input3 = in.nextInt();
    int input4 = in.nextInt();
    userIdGeneration(input1, input2, input3, input4);
    System.out.println(output1);
  }
}
