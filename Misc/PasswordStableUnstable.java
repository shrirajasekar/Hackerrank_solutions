import java.util.ArrayList;
import java.util.Collections;

public class PasswordStableUnstable {

  public static int findPassword(int input1, int input2, int input3, int input4, int input5) {
    ArrayList<Integer> stableNumbers = new ArrayList<>();
    int password = 0;
    if (isStable(input1)) {
      stableNumbers.add(input1);
    }
    if (isStable(input2)) {
      stableNumbers.add(input2);
    }
    if (isStable(input3)) {
      stableNumbers.add(input3);
    }
    if (isStable(input4)) {
      stableNumbers.add(input4);
    }
    if (isStable(input5)) {
      stableNumbers.add(input5);
    }
    password = Collections.max(stableNumbers) - Collections.min(stableNumbers);

    return password;

  }

  public static boolean isStable(int n) {
    int nums[] = new int[10];
    int x=nums.;

    int remainder, max = -1, i;

    while (n > 0) {
      remainder = n % 10;
      nums[remainder]++;
      n /= 10;
    }

    for (i = 0; i < nums.length; i++) {
      if (nums[i] > max)
        max = nums[i];
    }

    for (i = 0; i < nums.length; i++) {
      if (nums[i] > 0 && nums[i] != max)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(findPassword(12, 1313, 122, 678, 898));
  }
}
