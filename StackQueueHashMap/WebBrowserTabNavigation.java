// package StackQueueHashMap;
import java.util.Stack;

interface NavigationManager {
    void openTab(String url);
    void back();
    void forward();
    String getCurrentTab();
}

class BrowserNavigationManager implements NavigationManager {
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentTab = null;

    @Override
    public void openTab(String url) {
        if (currentTab != null) {
            backStack.push(currentTab);
        }
        currentTab = url;
        forwardStack.clear();
    }

    @Override
    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentTab);
            currentTab = backStack.pop();
        }
    }

    @Override
    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentTab);
            currentTab = forwardStack.pop();
        }
    }

    @Override
    public String getCurrentTab() {
        return currentTab;
    }
}

public class WebBrowserTabNavigation {
    public static void main(String[] args) {
        NavigationManager manager = new BrowserNavigationManager();
        manager.openTab("google.com");
        manager.openTab("github.com");
        manager.openTab("stackoverflow.com");
        System.out.println("Current: " + manager.getCurrentTab()); // stackoverflow.com
        manager.back();
        System.out.println("Back: " + manager.getCurrentTab()); // github.com
        manager.back();
        System.out.println("Back: " + manager.getCurrentTab()); // google.com
        manager.forward();
        System.out.println("Forward: " + manager.getCurrentTab()); // github.com
        manager.openTab("oracle.com");
        System.out.println("Open new tab: " + manager.getCurrentTab()); // oracle.com
        manager.back();
        System.out.println("Back: " + manager.getCurrentTab()); // github.com
    }
}