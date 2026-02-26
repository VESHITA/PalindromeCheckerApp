import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static boolean stackPalindrome(String input) {
        if (input == null || input.isEmpty()) return true;

        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray()) {
            if (stack.pop() != ch) return false;
        }
        return true;
    }

    public static boolean dequePalindrome(String input) {
        if (input == null || input.isEmpty()) return true;

        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    public static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursivePalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison of Palindrome Algorithms ===");
        System.out.print("Enter a string to check: ");
        String input = sc.nextLine();

        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endStack = System.nanoTime();
        long durationStack = endStack - startStack;

        long startDeque = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long endDeque = System.nanoTime();
        long durationDeque = endDeque - startDeque;

        long startRec = System.nanoTime();
        boolean recResult = recursivePalindrome(normalized, 0, normalized.length() - 1);
        long endRec = System.nanoTime();
        long durationRec = endRec - startRec;

        System.out.println("\nResults:");
        System.out.printf("Stack-based: %s, Time: %d ns\n", stackResult ? "Palindrome" : "NOT palindrome", durationStack);
        System.out.printf("Deque-based: %s, Time: %d ns\n", dequeResult ? "Palindrome" : "NOT palindrome", durationDeque);
        System.out.printf("Recursive  : %s, Time: %d ns\n", recResult ? "Palindrome" : "NOT palindrome", durationRec);

        sc.close();
    }
}