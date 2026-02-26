// File: UseCase3PalindromeCheckerApp.java

import java.util.Scanner;

public class PalindromeCheckerApp
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String original = scanner.nextLine();
        StringBuilder sb = new StringBuilder(original);
        String reversed = sb.reverse().toString();
        if (original.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
        scanner.close();
    }
}
