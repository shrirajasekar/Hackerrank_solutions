import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QueensAttackPositionsEmptyBoard {

    // Find Queens Attack Position without considering any Obstacles / On an empty
    // Board
    static int queensAttack(int n, int r_q, int c_q) {
        if (r_q > n || c_q > n) {
            System.out.println("Invalid input");
            return 0;
        }
        // Find folded coordinates
        int folded_r_q = r_q, folded_c_q = c_q;
        int totalAttackPositions;
        if (!(r_q <= n / 2)) {
            folded_r_q = (n - r_q + 1);
        }
        if (!(c_q <= n / 2)) {
            folded_c_q = (n - c_q + 1);
        }

        System.out.println("Folded r: "+ folded_r_q);
        System.out.println("Folded c: "+ folded_c_q);
        // Map Folded Co-ordinatess
        // to
        // total Attack Positions of the Queen
        if (folded_c_q < folded_r_q) {
            // Folded co-ord is to the left of the elbow in a row
            totalAttackPositions = (n - 1) * 3 + (folded_c_q - 1) * 2; // Arithmetic progression
        } else {
            // Folded co-ord is in the base of the 'L' shaped region of same Attacking
            // powers
            totalAttackPositions = (n - 1) * 3 + (folded_r_q - 1) * 2; // Arithmetic progression
        }
        return totalAttackPositions;
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
