public class TextEditorUndoRedo {

    class TextState {
        String content;
        TextState prev, next;

        TextState(String content) {
            this.content = content;
            this.prev = this.next = null;
        }
    }

    private TextState head = null;      
    private TextState tail = null;    
    private TextState current = null;   
    private final int MAX_HISTORY = 10;
    private int size = 0;

    // Add a new action/state
    void performAction(String newContent) {
        TextState newNode = new TextState(newContent);

        // Truncate redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        // Append new node
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        current = tail;
        size++;

        // Remove oldest if size exceeds limit
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo the last action
    void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        current = current.prev;
    }

    // Redo the next action
    void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }
        current = current.next;
    }

    // Display current text
    void displayCurrentState() {
        if (current == null) {
            System.out.println("[Empty Document]");
        } else {
            System.out.println("Current Text: " + current.content);
        }
    }

    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();

        editor.performAction("Hello");
        editor.performAction("Hello World");
        editor.performAction("Hello World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.undo();
        editor.performAction("Hi Universe");
        editor.displayCurrentState();

        System.out.println("Performing 10 more edits to test history limit:");
        for (int i = 1; i <= 10; i++) {
            editor.performAction("Edit #" + i);
        }

        editor.displayCurrentState();
    }
}