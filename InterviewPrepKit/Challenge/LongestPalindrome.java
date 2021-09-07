package InterviewPrepKit.Challenge;

public class LongestPalindrome {
  static void printResult(String str, int start, int end) {
    System.out.println(str.substring(start, end + 1));
  }

  static void printLongestPalindrome(String str) {
    int maxLength = 1;

    int start = 0;
    int len = str.length();

    int begin, end;

    for (int i = 1; i < len; ++i) {
      begin = i - 1;
      end = i;
      while (begin >= 0 && end < len && str.charAt(begin) == str.charAt(end)) {
        --begin;
        ++end;
      }

      ++begin;
      --end;
      if (str.charAt(begin) == str.charAt(end) && end - begin + 1 > maxLength) {
        start = begin;
        maxLength = end - begin + 1;
      }

      begin = i - 1;
      end = i + 1;
      while (begin >= 0 && end < len && str.charAt(begin) == str.charAt(end)) {
        --begin;
        ++end;
      }

      ++begin;
      --end;
      if (str.charAt(begin) == str.charAt(end) && end - begin + 1 > maxLength) {
        start = begin;
        maxLength = end - begin + 1;
      }
    }
    if (maxLength > 2) {
      printResult(str, start, start + maxLength - 1);
    } else {
      System.out.println("none");
    }
  }

  public static void main(String[] args) {

    String str = "abcdefgg";
    printLongestPalindrome(str);
  }
}
