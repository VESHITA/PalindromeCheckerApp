import java.util.Scanner;

public class PalindromeCheckerApp {
    public static void checkCaseInsensitivePalindrome(String input) {
        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        int left = 0, right = normalized.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("\nUC10 Result: \"" + input + "\" is "
                + (isPalindrome ? "" : "NOT ") + "a palindrome (ignoring case & spaces).");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string for UC10 case-insensitive check: ");
        String inputUC10 = sc.nextLine();
        checkCaseInsensitivePalindrome(inputUC10);

        sc.close();
    }
}