class Circle {
    private double radius;

    Circle(){
        radius=0.0;
    }

    Circle(double r){
        this.radius=r;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    double getCircumference() {
        return 2 * Math.PI * radius;
    }

    void displayDetails() {
        System.out.println("\nCircle Details:");
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        c.displayDetails();
        Circle c1 = new Circle(7);
        c1.displayDetails();
    }
}