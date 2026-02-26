import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static void checkPalindromeUsingRecursion() {
        String input = "malayalam";
        boolean isPalindrome = isPalindromeRecursive(input, 0, input.length() - 1);
        System.out.println("\nUC9 Result: \"" + input + "\" is "
                + (isPalindrome ? "" : "NOT ") + "a palindrome.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        checkPalindromeUsingRecursion();

        sc.close();
    }
}