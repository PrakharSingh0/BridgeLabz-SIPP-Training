import java.util.*;

class IntegerHashMap {
    private static final int SIZE = 16;
    private LinkedList<Entry>[] table = new LinkedList[SIZE];

    static class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(int key, int value) {
        int index = Math.abs(Integer.hashCode(key)) % SIZE;
        if (table[index] == null)
            table[index] = new LinkedList<>();
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        table[index].add(new Entry(key, value));
    }

    public Integer get(int key) {
        int index = Math.abs(Integer.hashCode(key)) % SIZE;
        if (table[index] == null) return null;
        for (Entry entry : table[index]) {
            if (entry.key == key) return entry.value;
        }
        return null;
    }

    public void remove(int key) {
        int index = Math.abs(Integer.hashCode(key)) % SIZE;
        if (table[index] == null) return;
        table[index].removeIf(entry -> entry.key == key);
    }

    public static void main(String[] args) {
        IntegerHashMap map = new IntegerHashMap();
        map.put(1, 100);
        map.put(2, 200);
        System.out.println("Value for key 1: " + map.get(1));  // 100
        map.remove(1);
        System.out.println("Value for key 1 after removal: " + map.get(1)); // null
    }
}