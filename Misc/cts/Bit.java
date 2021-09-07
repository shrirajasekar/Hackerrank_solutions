package cts;

public class Bit {
  public static String Bitwise(int input1) {
    String bin;
    bin = Integer.toBinaryString(input1);
    int lsb = 0, msb = PositionMSB(input1), setb = 0;
    for (Character c : bin.toCharArray()) {
      System.out.println(c);
      if (c == '1') {
        setb = setb + 1;
      }
    }
    lsb = bin.length() - 1;
    return setb + "#" + msb + "#" + lsb;
  }

  static int PositionMSB(int n) {
    int position = 0;
    int m = 1;

    while ((n & m) == 0) {
      m = m << 1;
      position++;
    }
    return position;
  }

  public static void main(String[] args) {
    System.out.println(Bitwise(10));
  }
}
