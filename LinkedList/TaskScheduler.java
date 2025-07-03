public class TaskScheduler {

    class TaskNode {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        TaskNode next;

        TaskNode(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }

    private TaskNode head = null;
    private TaskNode current = null;

    // Add task at beginning
    void addAtBeginning(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
            return;
        }
        TaskNode tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    // Add task at end
    void addAtEnd(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
            return;
        }
        TaskNode tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.next = head;
    }

    // Add task at specific position
    void addAtPosition(int id, String name, int priority, String date, int pos) {
        if (pos <= 0 || head == null) {
            addAtBeginning(id, name, priority, date);
            return;
        }
        TaskNode newNode = new TaskNode(id, name, priority, date);
        TaskNode temp = head;
        for (int i = 1; i < pos && temp.next != head; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove task by ID
    void removeById(int id) {
        if (head == null) return;

        // If only one node
        if (head.taskId == id && head.next == head) {
            head = null;
            current = null;
            return;
        }

        TaskNode temp = head, prev = null;
        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    TaskNode tail = head;
                    while (tail.next != head) {
                        tail = tail.next;
                    }
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                if (current == temp) {
                    current = head;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // View and move to next task
    void viewCurrentTaskAndMoveNext() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName +
                ", Priority: " + current.priority + ", Due: " + current.dueDate);
        current = current.next;
    }

    // Display all tasks from head
    void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        TaskNode temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search tasks by priority
    void searchByPriority(int targetPriority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }
        boolean found = false;
        TaskNode temp = head;
        do {
            if (temp.priority == targetPriority) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName +
                        ", Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + targetPriority);
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtBeginning(1, "Task A", 2, "2025-07-10");
        scheduler.addAtEnd(2, "Task B", 1, "2025-07-12");
        scheduler.addAtPosition(3, "Task C", 3, "2025-07-14", 1);

        System.out.println("All tasks:");
        scheduler.displayAllTasks();

        System.out.println("\nViewing and rotating tasks:");
        scheduler.viewCurrentTaskAndMoveNext();
        scheduler.viewCurrentTaskAndMoveNext();
        scheduler.viewCurrentTaskAndMoveNext();

        System.out.println("\nSearch by priority 1:");
        scheduler.searchByPriority(1);

        scheduler.removeById(2);
        System.out.println("\nAfter removing Task ID 2:");
        scheduler.displayAllTasks();
    }
}