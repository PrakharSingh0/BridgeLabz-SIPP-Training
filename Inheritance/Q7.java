interface Worker {
    void performDuties();
}

class Chef extends Person implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " prepares food.");
    }

    public static void main(String[] args) {
        Chef chef = new Chef("Raghav", 1);
        chef.performDuties();
    }
}

class Waiter extends Person implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " serves customers.");
    }

    public static void main(String[] args) {
        Waiter waiter = new Waiter("Amit", 2);
        waiter.performDuties();
    }
}