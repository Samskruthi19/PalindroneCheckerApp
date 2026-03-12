import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        boolean result = isPalindrome(input);

        System.out.println("Palindrome? " + result);
    }
}