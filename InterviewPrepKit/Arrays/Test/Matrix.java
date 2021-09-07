public class Matrix {

  public static void main(String[] args) {
    Scanner x = new Scanner(System.in);
    System.out.println("Enter Square Matrix Size: ");
    int n = x.nextInt();
    int val = 1;

    int[][] matrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = val;
        val++;
        if (val == 3) {
          val = 1;
        }
      }
    }
  }

}
