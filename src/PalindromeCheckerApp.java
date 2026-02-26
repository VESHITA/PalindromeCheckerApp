import java.util.Scanner;

// Node class for singly linked list
class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) return true;

        Node head = null, tail = null;
        for (char ch : input.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) head = tail = newNode;
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null, current = slow;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node firstHalf = head, secondHalf = prev;
        while (secondHalf != null) {
            if (Character.toLowerCase(firstHalf.data) != Character.toLowerCase(secondHalf.data)) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to check palindrome: ");
        String input = sc.nextLine();

        boolean result = isPalindrome(input);

        System.out.println("\nUC8 Result: \"" + input + "\" is "
                + (result ? "" : "NOT ") + "a palindrome.");

        sc.close();
    }
}