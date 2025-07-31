import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StudentDataStream {

    private static final String FILE_NAME = "student_data.dat";

    public static void main(String[] args) {
        // Student details to store
        int rollNumber = 101;
        String name = "Alice Smith";
        double gpa = 3.85;

        // 1. Store student details in a binary file
        System.out.println("Storing student data...");
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data stored successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Error storing student data: " + e.getMessage());
        }

        // 2. Retrieve student details from the binary file
        System.out.println("\nRetrieving student data...");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            int retrievedRollNumber = dis.readInt();
            String retrievedName = dis.readUTF();
            double retrievedGpa = dis.readDouble();

            System.out.println("Retrieved Student Details:");
            System.out.println("Roll Number: " + retrievedRollNumber);
            System.out.println("Name: " + retrievedName);
            System.out.println("GPA: " + retrievedGpa);
        } catch (IOException e) {
            System.err.println("Error retrieving student data: " + e.getMessage());
        }
    }
}