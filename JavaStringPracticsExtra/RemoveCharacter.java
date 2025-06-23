public class RemoveCharacter {
    public static void main(String[] args) {
        String str = "Hello World";
        char toRemove = 'l';
        String result = str.replaceAll(Character.toString(toRemove), "");
        System.out.println("Modified String: " + result);
    }
}