public class Course {

    private String courseName;
    private int duration; 
    private double fee;
    private static String instituteName = "Tech Academy";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
        System.out.println("Institute name updated to: " + instituteName);
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 8, 5000);
        Course c2 = new Course("Web Development", 10, 6000);

        c1.displayCourseDetails();
        c2.displayCourseDetails();

        Course.updateInstituteName("CodeVerse");
        c1.displayCourseDetails(); // after updating institute name
    }
}