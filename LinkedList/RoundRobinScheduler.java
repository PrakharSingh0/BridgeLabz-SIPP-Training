public class RoundRobinScheduler {

    class ProcessNode {
        int pid;
        int burstTime;
        int remainingTime;
        int priority;
        int waitingTime = 0;
        int turnaroundTime = 0;
        ProcessNode next;

        ProcessNode(int pid, int burstTime, int priority) {
            this.pid = pid;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
            this.next = null;
        }
    }

    private ProcessNode head = null;
    private ProcessNode tail = null;
    private int processCount = 0;

    void addProcess(int pid, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        processCount++;
    }

    void removeProcess(ProcessNode toRemove) {
        if (head == null || toRemove == null) return;

        if (head == toRemove && head == tail) {
            head = tail = null;
        } else {
            ProcessNode curr = head, prev = null;
            do {
                if (curr == toRemove) break;
                prev = curr;
                curr = curr.next;
            } while (curr != head);

            if (curr == head) {
                head = head.next;
                tail.next = head;
            } else {
                prev.next = curr.next;
                if (curr == tail) tail = prev;
            }
        }
        processCount--;
    }

    void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        ProcessNode curr = head;
        while (processCount > 0) {
            if (curr.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, curr.remainingTime);
                time += execTime;
                curr.remainingTime -= execTime;

                // Update waiting and turnaround for others
                ProcessNode temp = head;
                do {
                    if (temp != curr && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while (temp != head);

                if (curr.remainingTime == 0) {
                    curr.turnaroundTime = time;
                    System.out.println("Process " + curr.pid + " completed at time " + time);
                    removeProcess(curr);
                }
            }

            displayProcesses();
            curr = curr.next;
        }

        calculateAverages();
    }

    void displayProcesses() {
        if (head == null) return;

        System.out.println("\nCurrent Process Queue:");
        ProcessNode curr = head;
        do {
            System.out.println("PID: " + curr.pid + ", Remaining: " + curr.remainingTime +
                    ", Priority: " + curr.priority);
            curr = curr.next;
        } while (curr != head);
    }

    void calculateAverages() {
        double totalWT = 0, totalTAT = 0;
        int count = 0;
        System.out.println("\nFinal Results:");
        ProcessNode curr = head;
        do {
            System.out.println("PID: " + curr.pid + ", Waiting Time: " + curr.waitingTime +
                    ", Turnaround Time: " + curr.turnaroundTime);
            totalWT += curr.waitingTime;
            totalTAT += curr.turnaroundTime;
            curr = curr.next;
            count++;
        } while (curr != head && count < processCount);

        System.out.printf("Average Waiting Time: %.2f\n", totalWT / count);
        System.out.printf("Average Turnaround Time: %.2f\n", totalTAT / count);
    }

    public static void main(String[] args) {
        RoundRobinScheduler rrs = new RoundRobinScheduler();
        int quantum = 4;

        rrs.addProcess(1, 10, 2);
        rrs.addProcess(2, 5, 1);
        rrs.addProcess(3, 8, 3);

        rrs.simulateRoundRobin(quantum);
    }
}