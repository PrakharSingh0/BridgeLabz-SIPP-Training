class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        System.out.println("Teacher of: " + subject);
    }

    public static void main(String[] args) {
        Teacher t = new Teacher("Mrs. Sharma", 35, "Mathematics");
        t.displayRole();
    }
}