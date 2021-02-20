import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SuperReducedString {


    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        for( int i=0; i<(s.length()-1); i++){

            if((s.charAt(i)==s.charAt(i+1))){
                s = i==0? s.substring(2): (i+2) < s.length()?   s.substring(0, i)+s.substring(i+2):s.substring(0, i);               
                i=-1;
            }
        }

    return s.isEmpty()?"Empty String" : s;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = superReducedString(s);
        System.out.println(result);
    }
}
