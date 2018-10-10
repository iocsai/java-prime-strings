/**
 * A String is called a prime if it can't be constructed by concatenating
 * multiple (mora than one) equal strings.
 * For example: "abac" is prime, but "xyxy" in not ("xyxy" = "xy" + "xy")
 * The program outputs whether a given string is prime or not.
 */
package primestrings;

import java.util.Scanner;

public class PrimeStrings {
    
    private final String input;
    private final boolean isPrime;

    public PrimeStrings(String input) {
        this.input = input;
        this.isPrime = this.solve();
    }

    public static void main(String[] args) {
        PrimeStrings ps = new PrimeStrings(input(""));
        System.out.println(ps);
    }
    
    private static String input(String message) {
        Scanner sc = new Scanner (System.in);
        while (true) {
            System.out.print(message.length() < 1 ? "input: " : message);
            String msg = sc.nextLine();
            if (msg.length() > 0) {
                return msg;
            }
        }
    }

    private boolean solve() {
        int end = 0;
        String sub = String.valueOf(input.charAt(0));
        while (input.substring(1).contains(sub) && end++ <= input.length()) {
            sub += input.charAt(end);
        }
        if (sub.length() > 1) {
            sub = sub.substring(0, end);
        } else {
            return true;
        }
        while (sub.length() <= input.length()) {
            sub += sub;
        }
        return !sub.substring(0, input.length()).equals(input);
    }

    @Override
    public String toString() {
        return String.format("\"%s\" %s.%n", 
                input, isPrime ? "is prime" : "is not prime");
    }
}