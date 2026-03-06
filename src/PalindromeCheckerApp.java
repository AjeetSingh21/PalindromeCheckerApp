import java.util.*;

public class PalindromeCheckerApp {

    public static boolean checkWithTwoPointer(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean checkWithStack(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) stack.push(c);
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    public static boolean checkWithDeque(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : normalized.toCharArray()) deque.add(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== UC13: Performance Comparison of Palindrome Algorithms ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        long startTime, endTime;

        startTime = System.nanoTime();
        boolean twoPointerResult = checkWithTwoPointer(input);
        endTime = System.nanoTime();
        long twoPointerTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean stackResult = checkWithStack(input);
        endTime = System.nanoTime();
        long stackTime = endTime - startTime;

        startTime = System.nanoTime();
        boolean dequeResult = checkWithDeque(input);
        endTime = System.nanoTime();
        long dequeTime = endTime - startTime;

        System.out.println("\nResults:");
        System.out.println("Two-Pointer: " + twoPointerResult + " | Time: " + twoPointerTime + " ns");
        System.out.println("Stack:       " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Deque:       " + dequeResult + " | Time: " + dequeTime + " ns");

        scanner.close();
    }
}
