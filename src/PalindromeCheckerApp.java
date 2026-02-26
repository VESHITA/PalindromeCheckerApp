import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) return true;

        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : normalized.toCharArray()) {
            if (stack.pop() != ch) return false;
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) return true;

        String normalized = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public PalindromeCheckerContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.checkPalindrome(input);
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC12: Strategy Pattern Palindrome Checker ===");
        System.out.print("Enter a string to check: ");
        String input = sc.nextLine();

        System.out.println("Choose strategy: ");
        System.out.println("1. Stack-based");
        System.out.println("2. Deque-based");
        System.out.print("Enter choice (1-2): ");
        int choice = sc.nextInt();

        PalindromeStrategy strategy;
        if (choice == 1) strategy = new StackStrategy();
        else strategy = new DequeStrategy();

        PalindromeCheckerContext context = new PalindromeCheckerContext(strategy);
        boolean result = context.check(input);

        System.out.println("\nUC12 Result: \"" + input + "\" is "
                + (result ? "" : "NOT ") + "a palindrome using "
                + (choice == 1 ? "StackStrategy." : "DequeStrategy."));

        sc.close();
    }
}