import java.util.*;

public class MapInverter {
    public static <K, V> Map<V, List<K>> invert(Map<K, V> original) {
        Map<V, List<K>> inverted = new HashMap<>();
        for (Map.Entry<K, V> entry : original.entrySet()) {
            inverted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        return inverted;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);
        System.out.println("Inverted: " + invert(map));
    }
}