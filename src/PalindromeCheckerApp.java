import java.util.*;


public class PalindromeCheckerApp {
    public static void main(String[] args){
        String s = "refer";
        Deque<Character> deque = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            deque.addLast(c);
        }
        boolean isPalindrome = true;
        while(deque.size() > 1){
            if( !deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
        System.out.println("completed");
    }
}
