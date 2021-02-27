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
        // **** Find total Attack positions on an Empty Board for the given position ****
        if (r_q > n || c_q > n) {
            System.out.println("Invalid input");
            return 0;
        }
        // Find folded coordinates
        int folded_r_q, folded_c_q;
        folded_r_q = (n - r_q + 1);
        folded_c_q = (n - c_q + 1);
        // Map Folded Co-ordinatess  
        // to
        // total Attack Positions of the Queen
        if (folded_c_q < folded_r_q) {
            // Folded co-ord is to the left of the elbow in a row
            totalAttackPositions = (n - 1) * 3 + (folded_r_q - 2) * 2; // Arithmetic progression
        } else {
            // Folded co-ord is in the base of the 'L' shaped region of same Attacking powers
            totalAttackPositions = (n - 1) * 3 + (folded_r_q - 1) * 2; // Arithmetic progression
        }
        // **** For each Obstacle ****
        for(int i=0;i<obstacles.length;i++){
            // **** Check if its really an Obstacle ****
            // If Same row or column as Queen - Obstacle
            if(r_q == obstacles[i][0]){
                if(obstacles[i][1]<c_q){
                    //If Obstacle is to the left of the Queen
                    totalAttackPositions = totalAttackPositions - obstacles[i][1];
                }else{
                    //The Obstacle is to the right of the Queen
                    totalAttackPositions = totalAttackPositions - n - obstacles[i][1];
                }

            }else if (c_q == obstacles[i][1]){
                if(obstacles[i][0]<r_q){
                    //If Obstacle is to the north of the Queen
                    totalAttackPositions = totalAttackPositions - obstacles[i][0];
                }else{
                    //The Obstacle is to the south of the Queen
                    totalAttackPositions = totalAttackPositions - n - obstacles[i][0];
                }
            }
            // If Obstacle falls on the left diagonal path of the Queen
            // If col + row values are equal then the positions fall on right diagonal
            else if((obstacles[i][0]+obstacles[i][1]) == (r_q+c_q)){
                // Second Quadrant +,-
                if(obstacles[i][0]>r_q && obstacles[i][1]<c_q){
                    totalAttackPositions = totalAttackPositions - n - obstacles[i][0];
                }
                // Fourth Quadrant -,+
                else if (obstacles[i][0]<r_q && obstacles[i][1]>c_q){
                    totalAttackPositions = totalAttackPositions - n - obstacles[i][1];
                }
            }
            // If Obstacle falls on the left diagonal path of the Queen
            // If col - row values are equal then the positions fall on right diagonal
            else if((obstacles[i][1]-obstacles[i][0])== (c_q-r_q)){
                // First Quadrant +,+
                if(obstacles[i][0]>r_q && obstacles[i][1]>c_q){
                    totalAttackPositions = totalAttackPositions - n - obstacles[i][1];
                }
                // Third Quadrant -,-
                else if(obstacles[i][0]<r_q && obstacles[i][1]<c_q){
                    totalAttackPositions = totalAttackPositions - obstacles[i][0];
                }

                
            }
            

        }
        
        // **** Reduce number of blocks from Obstacle to End of board from totalAttackPositions ****

        return totalAttackPositions;
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

        scanner.close();
    }
}
