import java.util.*;

public class ListRotator {
    public static <T> void rotate(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size;
        List<T> rotated = new ArrayList<>();
        for (int i = positions; i < size; i++) rotated.add(list.get(i));
        for (int i = 0; i < positions; i++) rotated.add(list.get(i));
        for (int i = 0; i < size; i++) list.set(i, rotated.get(i));
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotate(list, 2);
        System.out.println("Rotated List: " + list);
    }
}