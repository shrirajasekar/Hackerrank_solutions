import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class KaprekarNumbers {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        long n;
        String sq="";
        long r,l;
        String kaprekar = "";
        while(p<=q){
            n=p;
            if(n==1){
                kaprekar = kaprekar + Integer.toString(1) + " ";
            }
            sq = String.valueOf(n*n);
            if (sq.length() > 1) {
            l = Long.parseLong(sq.substring(0,(int)Math.ceil((sq.length()/2))));
            r = Long.parseLong(sq.substring((int)Math.ceil(sq.length()/2), sq.length()));
            if((r+l)==n){
                kaprekar = kaprekar + Long.toString(n) + " ";
            }
            }
            p++;
        }
        if(kaprekar.equals("")){
            System.out.println("INVALID RANGE");
        }else{
            System.out.println(kaprekar);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
