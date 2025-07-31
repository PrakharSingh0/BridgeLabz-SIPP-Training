import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class FileHandling {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt");
                FileOutputStream fos = new FileOutputStream("output.txt")) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}