class Order {
    String orderId;
    String orderDate;

    Order(String id, String date) {
        this.orderId = id;
        this.orderDate = date;
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String id, String date, String trackingNumber) {
        super(id, date);
        this.trackingNumber = trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String id, String date, String trackingNumber, String deliveryDate) {
        super(id, date, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    void getOrderStatus() {
        System.out.println("Order Delivered on " + deliveryDate);
    }

    public static void main(String[] args) {
        DeliveredOrder d = new DeliveredOrder("ORD2025", "2025-07-01", "TRK1234", "2025-07-03");
        d.getOrderStatus();
    }
}