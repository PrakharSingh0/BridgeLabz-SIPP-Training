import java.util.*;

public class StackViaQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int val) {
        q2.add(val);
        while (!q1.isEmpty()) q2.add(q1.remove());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) throw new RuntimeException("Empty stack");
        return q1.remove();
    }

    public int top() {
        if (q1.isEmpty()) throw new RuntimeException("Empty stack");
        return q1.peek();
    }

    public static void main(String[] args) {
        StackViaQueues stack = new StackViaQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top: " + stack.top()); // 3
        System.out.println("Popped: " + stack.pop()); // 3
        System.out.println("New Top: " + stack.top()); // 2
    }
}