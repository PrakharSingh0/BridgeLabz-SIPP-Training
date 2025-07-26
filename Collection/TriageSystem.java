import java.util.*;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String toString() {
        return name + " (" + severity + ")";
    }
}

public class TriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> queue = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.severity, a.severity)
        );

        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}