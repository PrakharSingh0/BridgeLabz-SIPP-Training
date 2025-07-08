import java.util.*;

class MyHashMap {
    private static final int SIZE = 10;
    private LinkedList<Entry>[] map = new LinkedList[SIZE];

    static class Entry {
        String key;
        int value;

        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(String key, int value) {
        int index = key.hashCode() % SIZE;
        if (map[index] == null) map[index] = new LinkedList<>();
        for (Entry entry : map[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        map[index].add(new Entry(key, value));
    }

    public Integer get(String key) {
        int index = key.hashCode() % SIZE;
        if (map[index] == null) return null;
        for (Entry entry : map[index]) {
            if (entry.key.equals(key))
                return entry.value;
        }
        return null;
    }

    public void remove(String key) {
        int index = key.hashCode() % SIZE;
        if (map[index] == null) return;
        map[index].removeIf(entry -> entry.key.equals(key));
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("apple", 100);
        map.put("banana", 200);
        System.out.println(map.get("apple"));   // 100
        map.remove("apple");
        System.out.println(map.get("apple"));   // null
    }
}