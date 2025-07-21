import java.util.LinkedList;

interface Notification {
    void deliver();
}

class EmailNotification implements Notification {
    private String recipient;
    public EmailNotification(String recipient) { this.recipient = recipient; }
    @Override
    public void deliver() {
        System.out.println("Email sent to " + recipient);
    }
}

class SMSNotification implements Notification {
    private String phoneNumber;
    public SMSNotification(String phoneNumber) { this.phoneNumber = phoneNumber; }
    @Override
    public void deliver() {
        System.out.println("SMS sent to " + phoneNumber);
    }
}

class PushNotification implements Notification {
    private String deviceId;
    public PushNotification(String deviceId) { this.deviceId = deviceId; }
    @Override
    public void deliver() {
        System.out.println("Push notification sent to device " + deviceId);
    }
}

class NotificationQueue {
    private LinkedList<Notification> queue = new LinkedList<>();
    public void add(Notification notification) {
        queue.add(notification);
    }
    public void sendAll() {
        while (!queue.isEmpty()) {
            Notification n = queue.poll();
            n.deliver();
        }
    }
}

public class CustomNotificationSystem {
    public static void main(String[] args) {
        NotificationQueue queue = new NotificationQueue();
        queue.add(new EmailNotification("alice@example.com"));
        queue.add(new SMSNotification("+1234567890"));
        queue.add(new PushNotification("device123"));
        queue.sendAll();
    }
}