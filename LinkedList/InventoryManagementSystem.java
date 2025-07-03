public class InventoryManagementSystem {

    class ItemNode {
        String name;
        int id;
        int quantity;
        double price;
        ItemNode next;

        ItemNode(String name, int id, int quantity, double price) {
            this.name = name;
            this.id = id;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    ItemNode head = null;

    void addAtBeginning(String name, int id, int quantity, double price) {
        ItemNode newNode = new ItemNode(name, id, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    void addAtEnd(String name, int id, int quantity, double price) {
        ItemNode newNode = new ItemNode(name, id, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
    }

    void addAtPosition(String name, int id, int quantity, double price, int pos) {
        if (pos <= 0 || head == null) {
            addAtBeginning(name, id, quantity, price);
            return;
        }

        ItemNode newNode = new ItemNode(name, id, quantity, price);
        ItemNode curr = head;
        for (int i = 1; i < pos && curr.next != null; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    void removeById(int id) {
        if (head == null) return;

        if (head.id == id) {
            head = head.next;
            return;
        }

        ItemNode curr = head;
        while (curr.next != null && curr.next.id != id) {
            curr = curr.next;
        }
        if (curr.next != null) curr.next = curr.next.next;
    }

    void updateQuantity(int id, int newQty) {
        ItemNode curr = head;
        while (curr != null) {
            if (curr.id == id) {
                curr.quantity = newQty;
                return;
            }
            curr = curr.next;
        }
        System.out.println("Item ID not found.");
    }

    void searchById(int id) {
        ItemNode curr = head;
        while (curr != null) {
            if (curr.id == id) {
                printItem(curr);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Item ID not found.");
    }

    void searchByName(String name) {
        ItemNode curr = head;
        boolean found = false;
        while (curr != null) {
            if (curr.name.equalsIgnoreCase(name)) {
                printItem(curr);
                found = true;
            }
            curr = curr.next;
        }
        if (!found) System.out.println("Item name not found.");
    }

    void calculateTotalValue() {
        double total = 0;
        ItemNode curr = head;
        while (curr != null) {
            total += curr.quantity * curr.price;
            curr = curr.next;
        }
        System.out.printf("Total Inventory Value: ₹%.2f%n", total);
    }

    void sortInventory(String field, boolean ascending) {
        head = mergeSort(head, field, ascending);
    }

    ItemNode mergeSort(ItemNode head, String field, boolean asc) {
        if (head == null || head.next == null) return head;

        ItemNode mid = getMiddle(head);
        ItemNode right = mid.next;
        mid.next = null;

        ItemNode leftSorted = mergeSort(head, field, asc);
        ItemNode rightSorted = mergeSort(right, field, asc);

        return merge(leftSorted, rightSorted, field, asc);
    }

    ItemNode merge(ItemNode a, ItemNode b, String field, boolean asc) {
        ItemNode dummy = new ItemNode("", -1, 0, 0);
        ItemNode tail = dummy;

        while (a != null && b != null) {
            int cmp;
            if (field.equalsIgnoreCase("name")) {
                cmp = a.name.compareToIgnoreCase(b.name);
            } else {
                cmp = Double.compare(a.price, b.price);
            }

            if ((asc && cmp <= 0) || (!asc && cmp > 0)) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    ItemNode getMiddle(ItemNode head) {
        if (head == null) return head;
        ItemNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void printInventory() {
        ItemNode curr = head;
        while (curr != null) {
            printItem(curr);
            curr = curr.next;
        }
    }

    void printItem(ItemNode item) {
        System.out.println("Item ID: " + item.id + ", Name: " + item.name +
                ", Quantity: " + item.quantity + ", Price: ₹" + item.price);
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addAtEnd("Pen", 101, 50, 10.0);
        ims.addAtBeginning("Notebook", 102, 20, 50.0);
        ims.addAtPosition("Pencil", 103, 100, 5.0, 1);

        System.out.println("All items:");
        ims.printInventory();

        System.out.println("\nUpdate quantity of ID 101 to 70");
        ims.updateQuantity(101, 70);
        ims.searchById(101);

        System.out.println("\nSearch by name: 'Pencil'");
        ims.searchByName("Pencil");

        System.out.println("\nTotal inventory value:");
        ims.calculateTotalValue();

        System.out.println("\nSorting by Price (Descending):");
        ims.sortInventory("price", false);
        ims.printInventory();

        System.out.println("\nRemoving item with ID 102:");
        ims.removeById(102);
        ims.printInventory();
    }
}