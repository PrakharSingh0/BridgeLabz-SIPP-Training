import java.util.*;

public class SortStackRecursively {

    static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertSorted(stack, temp);
        }
    }

    static void insertSorted(Stack<Integer> stack, int val) {
        if (stack.isEmpty() || val > stack.peek()) {
            stack.push(val);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, val);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        sortStack(stack);
        System.out.println("Sorted Stack:");
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " "); // Output: 1 2 3 4
    }
}