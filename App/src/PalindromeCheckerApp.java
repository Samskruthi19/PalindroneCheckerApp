import java.util.*;

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
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

class ReverseStringStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        List<PalindromeStrategy> strategies = new ArrayList<>();
        strategies.add(new StackStrategy());
        strategies.add(new DequeStrategy());
        strategies.add(new ReverseStringStrategy());

        String[] names = {"Stack Strategy", "Deque Strategy", "Reverse String Strategy"};

        for (int i = 0; i < strategies.size(); i++) {
            PalindromeStrategy strategy = strategies.get(i);

            long startTime = System.nanoTime();
            boolean result = strategy.isPalindrome(input);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.println(names[i] + ": " + (result ? "Palindrome" : "Not Palindrome"));
            System.out.println("Execution Time: " + duration + " ns");
            System.out.println();
        }

        scanner.close();
    }
}