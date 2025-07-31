import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImageToByteArray {

    public static void main(String[] args) {
        String sourceImagePath = "img.png";
        String outputImagePath = "output_image.png";

        try {
            // 1. Read image into byte array
            byte[] imageBytes;
            try (FileInputStream fis = new FileInputStream(sourceImagePath)) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);


                }
                imageBytes = baos.toByteArray();
                System.out.println("Image read into byte array. Size: " + imageBytes.length + " bytes.");
            }

            // 2. Write byte array back to a new image file
            try (FileOutputStream fos = new FileOutputStream(outputImagePath);
                 ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("Byte array written back to image file: " + outputImagePath);
            }

            // 3. Verify that the new file is identical to the original
            boolean areIdentical = Files.mismatch(Paths.get(sourceImagePath), Paths.get(outputImagePath)) == -1L;
            if (areIdentical) {
                System.out.println("Verification successful: Original and new image files are identical.");
            } else {
                System.out.println("Verification failed: Original and new image files are NOT identical.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }


}
