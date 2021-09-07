package InterviewPrepKit.Challenge;

public class SearchPalindrome {
  static final int MAX = 200;

  static boolean compare(char arr1[], char arr2[]) {
    for (int i = 0; i < MAX; i++)
      if (arr1[i] != arr2[i])
        return false;
    return true;
  }

  static void search(String pat, String txt) {
    int M = pat.length();
    int N = txt.length();
    boolean output = false;
    char[] pInstances = new char[MAX];
    char[] wInstances = new char[MAX];
    for (int i = 0; i < M; i++) {
      (pInstances[pat.charAt(i)])++;
      (wInstances[txt.charAt(i)])++;
    }

    for (int i = M; i < N; i++) {
      if (compare(pInstances, wInstances))
        output = true;

      (wInstances[txt.charAt(i)])++;

      wInstances[txt.charAt(i - M)]--;
    }

    if (compare(pInstances, wInstances)) {
      output = true;
    }

    System.out.println(output);

  }

  public static void main(String args[]) {
    String txt = "oidbcaf";
    String pat = "abc";
    search(pat, txt);
  }
}
