import java.util.LinkedList;

interface Order {
    void process();
}

class OnlineOrder implements Order {
    private String orderId;
    public OnlineOrder(String orderId) { this.orderId = orderId; }
    @Override
    public void process() {
        System.out.println("Processing online order: " + orderId);
    }
}

class OfflineOrder implements Order {
    private String orderId;
    public OfflineOrder(String orderId) { this.orderId = orderId; }
    @Override
    public void process() {
        System.out.println("Processing offline order: " + orderId);
    }
}

class SubscriptionOrder implements Order {
    private String orderId;
    public SubscriptionOrder(String orderId) { this.orderId = orderId; }
    @Override
    public void process() {
        System.out.println("Processing subscription order: " + orderId);
    }
}

class OrderQueue {
    private LinkedList<Order> queue = new LinkedList<>();
    public void add(Order order) {
        queue.add(order);
    }
    public void processAll() {
        while (!queue.isEmpty()) {
            Order o = queue.poll();
            o.process();
        }
    }
}

public class OrderProcessingSystem {
    public static void main(String[] args) {
        OrderQueue queue = new OrderQueue();
        queue.add(new OnlineOrder("ON123"));
        queue.add(new OfflineOrder("OFF456"));
        queue.add(new SubscriptionOrder("SUB789"));
        queue.processAll();
    }
}