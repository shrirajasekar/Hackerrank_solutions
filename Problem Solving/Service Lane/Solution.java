import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the serviceLane function below.
    static int[] serviceLane(int n, int t, int[] width, int[][] cases) {
        int [] result = new int[t];
        int start = 0;
        int end =0;
        for (int i=0; i<t; i++){
            start = cases[i][0];
            end = cases[i][1];
            System.out.println(Arrays.toString(Arrays.copyOfRange(width, start, end)));
            result[i] = minOfArray(Arrays.copyOfRange(width, start, end+1));
        }
        return result;
    }


    private static int minOfArray(int [] a){
        int min = a[0];
        for(int i=0; i<a.length;i++){
            if(a[i]<min){
                min = a[i];
            }
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nt = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nt[0]);

        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }

        int[][] cases = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        int[] result = serviceLane(n, t, width, cases);

        for (int i = 0; i < result.length; i++) {
            System.out.println((result[i]));

            if (i != result.length - 1) {
                System.out.println("\n");
            }
        }

        scanner.close();
    }
}
