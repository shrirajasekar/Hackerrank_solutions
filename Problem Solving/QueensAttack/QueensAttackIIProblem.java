import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QueensAttackIIProblem {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int totalAttackPositions = 0;
        ArrayList<Integer> northObstacles = new ArrayList<Integer>();
        ArrayList<Integer> northEastObstacles = new ArrayList<Integer>();
        ArrayList<Integer> eastObstacles = new ArrayList<Integer>();
        ArrayList<Integer> southEastObstacles = new ArrayList<Integer>();
        ArrayList<Integer> southObstacles = new ArrayList<Integer>();
        ArrayList<Integer> southWestObstacles = new ArrayList<Integer>();
        ArrayList<Integer> westObstacles = new ArrayList<Integer>();
        ArrayList<Integer> northWestObstacles = new ArrayList<Integer>();

        String iObstacle = "";
        // **** Find total Attack positions on an Empty Board for the given position
        // ****
        if (r_q > n || c_q > n) {
            System.out.println("Invalid input");
            return 0;
        }
        // Find folded coordinates
        int folded_r_q = r_q, folded_c_q = c_q;
        if (r_q > n / 2) {
            folded_r_q = (n - r_q + 1);
        }
        if (c_q > n / 2) {
            folded_c_q = (n - c_q + 1);
        }

        System.out.println("Folded r: " + folded_r_q);
        System.out.println("Folded c: " + folded_c_q);
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
        // **** For each Obstacle ****
        for (int i = 0; i < obstacles.length; i++) {
                // **** Check if its really an Obstacle ****
                // If Same row or column as Queen - Obstacle
                if (r_q == obstacles[i][0]) {
                    if (obstacles[i][1] < c_q) {
                        // West
                        westObstacles.add(obstacles[i][1]);
                    } else {
                        // East
                        eastObstacles.add(obstacles[i][1]);
                    }
                } else if (c_q == obstacles[i][1]) {
                    if (obstacles[i][0] < r_q) {
                        // South
                        southObstacles.add(obstacles[i][0]);
                    } else {
                        // North
                        northObstacles.add(obstacles[i][0]);
                    }
                }
                // If Obstacle falls on the left diagonal \ path of the Queen
                // If col + row values are equal then the positions fall on left diagonal
                else if ((obstacles[i][0] + obstacles[i][1]) == (r_q + c_q)) {
                    // If obstacle is on the second quadrant to the Queen
                    if (obstacles[i][0] > r_q && obstacles[i][1] < c_q) {
                        // North West
                        // Storing only col position
                        northWestObstacles.add(obstacles[i][1]);
                    } else if (obstacles[i][0] < r_q && obstacles[i][1] > c_q) {
                        // South East
                        southEastObstacles.add(obstacles[i][1]);
                    }
                }
                // If Obstacle falls on the right diagonal / path of the Queen
                // If col - row values are equal then the positions fall on right diagonal
                else if ((obstacles[i][1] - obstacles[i][0]) == (c_q - r_q)) {
                    if (obstacles[i][0] > r_q && obstacles[i][1] > c_q) {
                        // North East - Storing rows
                        northEastObstacles.add(obstacles[i][0]);
                    } else if (obstacles[i][0] < r_q && obstacles[i][1] < c_q) {
                        // South West
                        southWestObstacles.add(obstacles[i][0]);
                    }
                }
        }
        // Compute Obstacle Impact of closest Obstacle from
        // NORTH
        if (!northObstacles.isEmpty()) {
            totalAttackPositions = computeObstacleImpact(n, totalAttackPositions, r_q, c_q,
                    Collections.min(northObstacles), c_q);
        }
        // SOUTH
        if (!southObstacles.isEmpty()) {
            totalAttackPositions = computeObstacleImpact(n, totalAttackPositions, r_q, c_q,
                    Collections.max(southObstacles), c_q);
        }
        // WEST
        if (!westObstacles.isEmpty()) {
            totalAttackPositions = computeObstacleImpact(n, totalAttackPositions, r_q, c_q, r_q,
                    Collections.max(westObstacles));
        }
        // EAST
        if (!eastObstacles.isEmpty()) {
            totalAttackPositions = computeObstacleImpact(n, totalAttackPositions, r_q, c_q, r_q,
                    Collections.min(eastObstacles));
        }
        // NORTHEAST - First Quadrant - (c_o - r_o == c_q - r_q)
        if (!northEastObstacles.isEmpty()) {
            totalAttackPositions = computeObstacleImpact(n, totalAttackPositions, r_q, c_q,
                    Collections.min(northEastObstacles), (c_q - r_q + Collections.min(northEastObstacles)));
        }
        // SOUTHWEST - Third Quadrant - (c_o - r_o == c_q - r_q)
        if (!southWestObstacles.isEmpty()) {
            totalAttackPositions = computeObstacleImpact(n, totalAttackPositions, r_q, c_q,
                    Collections.max(southWestObstacles), (c_q - r_q + Collections.max(southWestObstacles)));
        }
        // NORTHWEST - Second Quadrant - (r_o + c_o == r_q + c_q)
        if (!northWestObstacles.isEmpty()) {
            totalAttackPositions = computeObstacleImpact(n, totalAttackPositions, r_q, c_q,
                    (r_q + c_q - Collections.max(northWestObstacles)), Collections.max(northWestObstacles));
        }
        // SOUTHEAST - Fourth Quadrant - (r_o + c_o == r_q + c_q)
        if (!southEastObstacles.isEmpty()) {
            totalAttackPositions = computeObstacleImpact(n, totalAttackPositions, r_q, c_q,
                    (r_q + c_q - Collections.min(southEastObstacles)), Collections.min(southEastObstacles));
        }

        return totalAttackPositions;

    }

    public static int computeObstacleImpact(int n, int TAP, int r_q, int c_q, int r_o, int c_o) {

        if (r_q == r_o) {
            if (c_o < c_q) {
                // If Obstacle is to the left of the Queen
                TAP = TAP - c_o;
            } else {
                // The Obstacle is to the right of the Queen
                TAP = TAP - (n - c_o + 1);
            }

        } else if (c_q == c_o) {
            if (r_o < r_q) {
                // If Obstacle is to the South of the Queen
                TAP = TAP - r_o;
            } else {
                // The Obstacle is to the North of the Queen
                TAP = TAP - (n - r_o + 1);
            }
        }
        // If Obstacle falls on the left diagonal \ path of the Queen
        // If col + row values are equal then the positions fall on left diagonal
        else if ((r_o + c_o) == (r_q + c_q)) {
            // If obstacle is on the second quadrant to the Queen
            if (r_o > r_q && c_o < c_q) {
                // Reduce blocks along Second Quadrant + row,- col from Obstacle to End of Board
                if ((n - r_o) <= (c_o - 1)) {
                    TAP = TAP - (n - r_o + 1);
                } else {
                    TAP = TAP - c_o;
                }

            }
            // If obstacle is on the fourth quadrant to the Queen
            else if (r_o < r_q && c_o > c_q) {
                // Reduce blocks along Fourth Quadrant - row,+ col from Obstacle to End of Board
                if ((r_o - 1) <= (n - c_o)) {
                    TAP = TAP - r_o;
                } else {
                    TAP = TAP - (n - c_o + 1);
                }
            }
        }
        // If Obstacle falls on the right diagonal / path of the Queen
        // If col - row values are equal then the positions fall on right diagonal
        else if ((c_o - r_o) == (c_q - r_q)) {
            // If Obstacle is on the First Quadrant of Queen
            if (r_o > r_q && c_o > c_q) {
                // Reduce blocks along on First Quadrant + row, +col from Obstacle to End of
                // Board
                if ((n - r_o) <= (n - c_o)) {
                    TAP = TAP - (n - r_o + 1);
                } else {
                    TAP = TAP - (n - c_o + 1);
                }
            }
            // If Obstacle is on the Third Quadrant of Queen
            else if (r_o < r_q && c_o < c_q) {
                // Reduce blocks along third Quadrant - row, - col from Obstacle to End of Board
                if ((r_o - 1) <= (c_o)) {
                    TAP = TAP - r_o;
                } else {
                    TAP = TAP - c_o;
                }
            }

        }
        // **** Reduce number of blocks from Obstacle to End of board from
        // TAP ****

        return TAP;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
        scanner.close();
    }
}
