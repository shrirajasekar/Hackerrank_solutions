import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QueensAttackPositionsEmptyBoard {

    // Find Queens Attack Position without considering any Obstacles / On an empty Board
    static int queensAttack(int n, int r, int c) {
        if (r > n || c > n) {
            System.out.println("Invalid input");
            return 0;
        }
        // Find folded coordinates
        int folded_r, folded_c;
        int maxAttackPositions;
        folded_r = (n - r + 1);
        folded_c = (n - c + 1);
        // Find the Maximum possible number of Attack Positions of the Queen
        // from Folded coordinates
        if (folded_c < folded_r) {
            // Folded co-ord is to the left of the 'L' shaped region of same attacking power
            maxAttackPositions = (n - 1) * 3 + (folded_r - 2) * 2; // Arithmetic progression
        } else {
            // Folded co-ord is to the right of the 'L' shaped region of same attacking
            // power
            maxAttackPositions = (n - 1) * 3 + (folded_r - 1) * 2; // Arithmetic progression
        }
        return maxAttackPositions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        String[] rC = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rC[0]);

        int c = Integer.parseInt(rC[1]);

        int result = queensAttack(n, r, c);

        System.out.println(String.valueOf(result));
        scanner.close();
    }
}
