public class CircularBuffer {
    private int[] buffer;
    private int size, head = 0;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = 0;
    }

    public void insert(int val) {
        buffer[head] = val;
        head = (head + 1) % buffer.length;
        if (size < buffer.length) size++;
    }

    public void printBuffer() {
        System.out.print("Buffer: ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % buffer.length] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1); cb.insert(2); cb.insert(3);
        cb.printBuffer(); // [1, 2, 3]
        cb.insert(4);
        cb.printBuffer(); // [2, 3, 4]
    }
}