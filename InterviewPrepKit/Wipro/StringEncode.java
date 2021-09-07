import java.util.*;

public class StringEncode {
  public static void main(String[] args) {
    String input1 = "John";
    String input2 = "Johny";
    String input3 = "Janardhan";

    // String[] str = divideString(input1);
    // String[] str2 = divideString(input2);
    // String[] str3 = divideString(input3);

    // String in1 = str[0] + str2[1] + str3[2];
    // String in2 = str[1] + str2[2] + str3[0];
    // String in3 = str[2] + str2[0] + str3[1];

    // String fstr1 = toggleString(in1);
    // String fstr2 = toggleString(in2);
    // String fstr3 = toggleString(in3);

    // System.out.println(fstr1);
    // System.out.println(fstr2);
    // System.out.println(fstr3);

    encodeThreeStrings(input1, input2, input3);
  }

  public static class Result {
    public final String output1;
    public final String output2;
    public final String output3;

    public Result(String out1, String out2, String out3) {
      output1 = out1;
      output2 = out2;
      output3 = out3;

    }
  }

  public static Result encodeThreeStrings(String input1, String input2, String input3) {
    class Local {
      public String[] divideString(String input) {
        int rem = input.length() % 3;
        int quo = input.length() / 3;
        String first = null;
        String middle = null;
        String last = null;
        if (rem == 1) {
          first = input.substring(0, quo);
          middle = input.substring(first.length(), first.length() + quo + rem);
          last = input.substring(first.length() + middle.length(), input.length());
        }

        if (rem == 2) {
          first = input.substring(0, quo + 1);
          middle = input.substring(first.length(), first.length() + quo);
          last = input.substring(first.length() + middle.length(), input.length());
        }
        if (rem == 0) {
          first = input.substring(0, quo);
          middle = input.substring(first.length(), first.length() + quo);
          last = input.substring(first.length() + middle.length(), input.length());

        }
        return new String[] { first, middle, last };
      }

      public String toggleString(String input) {
        char[] c = input.toCharArray();
        String s = "";
        for (int i = 0; i < c.length; i++) {
          if (Character.isLowerCase(c[i])) {
            s = s + Character.toUpperCase(c[i]);
          }
          if (Character.isUpperCase(c[i])) {
            s = s + Character.toLowerCase(c[i]);
          }
        }
        return s;
      }
    }

    Local local = new Local();
    String[] str = local.divideString(input1);
    String[] str2 = local.divideString(input2);
    String[] str3 = local.divideString(input3);

    String in1 = str[0] + str2[1] + str3[2];
    String in2 = str[1] + str2[2] + str3[0];
    String in3 = str[2] + str2[0] + str3[1];

    String fstr3 = local.toggleString(in3);

    Result res = new Result(in1, in2, fstr3);

    System.out.println(in1);
    System.out.println(in2);
    System.out.println(fstr3);

    return res;
  }

}
