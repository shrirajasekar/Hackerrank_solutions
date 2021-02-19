import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversionProblem {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        // 12:00:00AM sample
        String ampm = "";
        String tme = "";
        String hr = "";
        String min = "";
        String sec = "";
        String test = "";
        ampm = s.substring(8);
        tme = s.substring(0,8);
        hr = tme.substring(0,2);
        min = tme.substring(3,5);
        sec = tme.substring(6,8);
        test = hr + min + sec + ampm;
        return test;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);
        System.out.println(result);
        // bw.write(result);
        // bw.newLine();

        // bw.close();
    }
}
