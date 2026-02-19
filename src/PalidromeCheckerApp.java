import java.util.*;

class Palindrome {
    void start() {
        System.out.println("Palindrome app is starting");
        String javaVersion = System.getProperty("java.version");
        System.out.println("Java Version: " + javaVersion);
    }
}

public class PalidromeCheckerApp {

    static void checkPalindrome(String s) {
        int size = s.length();
        boolean isPalindrome = true;

        for (int i = 0; i < size / 2; i++) {
            if (s.charAt(i) != s.charAt(size - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The string is a palindrome");
        } else {
            System.out.println("The string is NOT a palindrome");
        }
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        p.start();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String s = sc.nextLine();

        checkPalindrome(s);

    }
}
