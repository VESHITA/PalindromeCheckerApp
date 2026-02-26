import java.util.Scanner;
import java.util.Stack;

class PalindromeChecker {

    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : normalized.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC11: Object-Oriented Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = sc.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);

        System.out.println("\nUC11 Result: \"" + input + "\" is "
                + (result ? "" : "NOT ") + "a palindrome.");

        sc.close();
    }
}