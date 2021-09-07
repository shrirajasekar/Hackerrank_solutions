import java.util.Scanner;

public class ExpressionEvaluator {

  static char evaluateExpression(StringBuilder s) {
    int n = s.length();
    for (int i = 0; i < n; i += 2) {
      if (i + 1 < n && i + 2 < n) {
        switch (s.charAt(i + 1)) {
          case 'A':
            if (s.charAt(i + 2) == '0' || s.charAt(i) == 0)
              s.setCharAt(i + 2, '0');
            else
              s.setCharAt(i + 2, '1');
            break;
          case 'B':
            if (s.charAt(i + 2) == '1' || s.charAt(i) == '1')
              s.setCharAt(i + 2, '1');
            else
              s.setCharAt(i + 2, '0');
            break;
          case 'C':
            if (s.charAt(i + 2) == s.charAt(i))
              s.setCharAt(i + 2, '0');
            else
              s.setCharAt(i + 2, '1');
            break;
          default:
            System.err.println("Invalid Operator");
            return 'X';
        }
      }
    }
    return s.charAt(n - 1);
  }

  public static void main(String[] args) {
    char output;
    StringBuilder inputSb = new StringBuilder("1A0B1");
    output = evaluateExpression(inputSb);
    if (output != 'X') {
      System.out.println(output);
    }
  }
}
