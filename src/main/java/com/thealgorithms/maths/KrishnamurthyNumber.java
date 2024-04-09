package com.thealgorithms.maths;


import io.github.pixee.security.BoundedLineReader;
import java.io.*;

public class KrishnamurthyNumber {

    // returns True if the number is a Krishnamurthy number and False if it is not.

    public static boolean isKMurthy(int n) {
        // initialising the variable s that will store the sum of the factorials of the digits to 0
        int s = 0;
        // storing the number n in a temporary variable tmp
        int tmp = n;

        // Krishnamurthy numbers are positive
        if (n <= 0) {
            return false;
        } // checking if the number is a Krishnamurthy number
        else {
            while (n != 0) {
                // initialising the variable fact that will store the factorials of the digits
                int fact = 1;
                // computing factorial of each digit
                for (int i = 1; i <= n % 10; i++) {
                    fact = fact * i;
                }
                // computing the sum of the factorials
                s = s + fact;
                // discarding the digit for which factorial has been calculated
                n = n / 10;
            }

            // evaluating if sum of the factorials of the digits equals the number itself
            return tmp == s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number to check if it is a Krishnamurthy number: ");
        int n = Integer.parseInt(BoundedLineReader.readLine(br, 5_000_000));
        if (isKMurthy(n)) {
            System.out.println(n + " is a Krishnamurthy number.");
        } else {
            System.out.println(n + " is NOT a Krishnamurthy number.");
        }
    }
}
