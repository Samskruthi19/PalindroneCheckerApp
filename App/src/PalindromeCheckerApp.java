import java.util.*;

interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}

class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        PalindromeStrategy strategy;

        System.out.println("Choose Strategy: 1.Stack  2.Deque");
        int choice = sc.nextInt();

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.checkPalindrome(input);

        System.out.println("Palindrome? " + result);
    }
}