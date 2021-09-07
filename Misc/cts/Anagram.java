package cts;

import java.util.Scanner;

public class Anagram {

  public static String anagramCheck(String input1, String input2) {
    char[] ch1 = new char[input1.length()];
    ch1 = input1.toCharArray();
    char[] ch2 = new char[input2.length()];
    ch2 = input2.toCharArray();
    int flag = 0;
    int sum1 = 0, sum2 = 0;
    int i, j, k;

    for (i = 0; i < input1.length(); i++) {
      if (input1.length() != input2.length()) {
        flag = 1;
        break;
      }
      sum1 = sum1 + ((int) ch1[i]);
      sum2 = sum2 + (int) ch2[i];
    }

    if (sum1 != sum2) {
      flag = 1;
    }
    if (flag == 0)
      return "yes";
    else
      return "no";
  }

  public static void main(String[] args) {
    System.out.println(anagramCheck("qwert", "twerq"));
  }
}
