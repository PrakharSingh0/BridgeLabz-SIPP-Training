public class NullPointerExample {
    public static void generateException() {
        String text = null;
        System.out.println(text.length()); // This will throw NullPointerException
    }

    public static void handleException() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        generateException();
        handleException();
    }
}