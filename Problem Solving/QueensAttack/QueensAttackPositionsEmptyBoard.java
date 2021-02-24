import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QueensAttackPositionsEmptyBoard {

    // Find Queens Attack Position without considering any Obstacles / On an empty Board
    static int queensAttack(int n, int r_q, int c_q) {
        if (r_q > n || c_q > n) {
            System.out.println("Invalid input");
            return 0;
        }
        // Find folded coordinates
        int folded_r_q, folded_c_q;
        int maxAttackPositions;
        folded_r_q = (n - r_q + 1);
        folded_c_q = (n - c_q + 1);
        // Find the Maximum possible number of Attack Positions of the Queen
        // from Folded coordinates
        if (folded_c_q < folded_r_q) {
            // Folded co-ord is to the left of the 'L' shaped region of same attacking power
            maxAttackPositions = (n - 1) * 3 + (folded_r_q - 2) * 2; // Arithmetic progression
        } else {
            // Folded co-ord is to the right of the 'L' shaped region of same attacking
            // power
            maxAttackPositions = (n - 1) * 3 + (folded_r_q - 1) * 2; // Arithmetic progression
        }
        return maxAttackPositions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int result = queensAttack(n, r_q, c_q);

        System.out.println(String.valueOf(result));
        scanner.close();
    }
}
