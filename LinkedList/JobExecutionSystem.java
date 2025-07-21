import java.util.LinkedList;

interface Executable {
    void execute();
}

class DataSyncJob implements Executable {
    @Override
    public void execute() {
        System.out.println("Executing Data Sync Job");
    }
}

class EmailAlertJob implements Executable {
    @Override
    public void execute() {
        System.out.println("Executing Email Alert Job");
    }
}

class CleanupJob implements Executable {
    @Override
    public void execute() {
        System.out.println("Executing Cleanup Job");
    }
}

class JobQueue {
    private LinkedList<Executable> queue = new LinkedList<>();
    public void add(Executable job) {
        queue.add(job);
    }
    public void executeAll() {
        while (!queue.isEmpty()) {
            Executable job = queue.poll();
            job.execute();
        }
    }
}

public class JobExecutionSystem {
    public static void main(String[] args) {
        JobQueue queue = new JobQueue();
        queue.add(new DataSyncJob());
        queue.add(new EmailAlertJob());
        queue.add(new CleanupJob());
        queue.executeAll();
    }
}